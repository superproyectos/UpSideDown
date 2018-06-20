package com.upsidedown.juego;

import com.framework.Camara;
import com.framework.Figuras.Coord;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoKinematico;
import com.framework.Figuras.Grupos.GrupoFisico;
import com.framework.Figuras.Poligonos.Hexagono;
import com.framework.Figuras.Poligonos.Rectangle;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Buttons.BotonFigura;
import com.upsidedown.juego.Buttons.PowerUp;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.FinalShape;

public class Board
{
	private Creator creator;
	private Interactor interactor;
	private SetOfShapes shapes;
	private ColisionManager colisionManager;

	public Board()
	{
		shapes=new SetOfShapes();
		Data.score =(new ScoreGrafico(30,Camara.H-30,1.5f));
		interactor=new Interactor();
		FabricOfCreators c=new FabricOfCreators();
		creator=c.createSquareCreator(this);
		interactor.add(creator);

		GrupoFisico suelo=new GrupoFisico(new Rectangle(Camara.W/4,Camara.H-50,Camara.W/2,50,new TexturaColor()));
		suelo.setTipoCuerpo(new CuerpoKinematico());
		suelo.setData("Suelo");

		FinalShape aux=new FinalShape(suelo);
		shapes.addToSet(aux);
		interactor.add(new BotonFigura(new Hexagono(Camara.W-Camara.W/12,Camara.W/2,Camara.W/12, new TexturaColor()), creator));
		colisionManager =new ColisionManager();
		interactor.add(new PowerUp(new Coord(Camara.W-Camara.W/8-10,Camara.H/2),"nieve.png",new Congelar(shapes.getShapes())));
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
		colisionManager.detectarScroll(shapes.getShapes());
	}
}