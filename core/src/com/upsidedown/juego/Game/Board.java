package com.upsidedown.juego.Game;

import com.framework.Camara;
import com.framework.Figuras.Coord;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoKinematico;
import com.framework.Figuras.Grupos.GrupoFisico;
import com.framework.Figuras.Poligonos.Hexagono;
import com.framework.Figuras.Poligonos.Rectangle;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Actions.CreatorChanger;
import com.upsidedown.juego.Actions.TetrisMode;
import com.upsidedown.juego.Buttons.BotonFigura;
import com.upsidedown.juego.Buttons.PowerUp;
import com.upsidedown.juego.Colisions.ColisionManager;
import com.upsidedown.juego.Actions.Freezer;
import com.upsidedown.juego.Colisions.Scroll;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.FinalShape;
import com.upsidedown.juego.FabricOfCreators;

public class Board
{
	private Creator creator;

	private Interactor interactor;

	private SetOfShapes shapes;

	private Scroll scroll;

	public Board()
	{
		shapes=new SetOfShapes();
		addFloor();
		addCreator();
		createInteractor();
		scroll=new Scroll();
	}

	private void addCreator()
	{
		FabricOfCreators c=new FabricOfCreators();
		creator=c.createSquareCreator(this);
	}

	private void addFloor()
	{
		GrupoFisico suelo=new GrupoFisico(new Rectangle(Camara.W/4,Camara.H-50,Camara.W/2,50,new TexturaColor()));
		suelo.setTipoCuerpo(new CuerpoKinematico());
		suelo.setData("Suelo");
		shapes.addToSet(new FinalShape(suelo));
	}

	private void createInteractor()
	{
		interactor=new Interactor();
		interactor.add(creator);
		interactor.add(new PowerUp(new Coord(Camara.W-Camara.W/6-10,Camara.H/2+Camara.W/6+10),"tettris.png", new TetrisMode(shapes.getShapes())));
		interactor.add(new PowerUp(new Coord(Camara.W-Camara.W/6-10,Camara.H/2),"nieve.png",new Freezer(shapes.getShapes())));
		interactor.add(new PowerUp(new Coord(Camara.W-Camara.W/6-10,Camara.H/2-Camara.W/6-10),"sel.png", new CreatorChanger(creator)));
	}

	public void addElement(FinalShape finalShape)
	{
		shapes.addToSet(finalShape);
		creator.setColor(new TexturaColor());
	}

	public void draw()
	{
		interactor.draw();
		shapes.draw();
		scroll.detectarScroll(shapes.getShapes());
	}
}