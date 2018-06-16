package com.upsidedown.juego;

import com.badlogic.gdx.utils.Array;
import com.framework.Camara;
import com.framework.Figuras.Drawable;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoKinematico;
import com.framework.Figuras.Grupos.GrupoFisico;
import com.framework.Figuras.Poligonos.Hexagono;
import com.framework.Figuras.Poligonos.Rectangle;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.juego.Creators.CreatorHexagonos;
import com.upsidedown.GrupoBloques;

public class Board
{
	private Creator creator;
	private Array<Drawable> elementos=new Array<Drawable>();
	private Scroll scroll;
	public static ContadorGrafico contador;
	public static Puntaje puntaje;
	public Board()
	{
		puntaje=(new PuntajeGrafico(30,Camara.H-30,1.5f));
		setContador(5);
		elementos.add(contador);
		//creator=new CreatorCuadrados(Camara.W/4,Camara.W/8,Camara.W/8,3,5,5, new TexturaColor(Colores.getColor(105, 52, 127,1)));
		creator =new CreatorHexagonos(Camara.W/4,Camara.W/8,Camara.W/12,5,3,5, new TexturaColor(Colores.getColor(105, 52, 127,1)));
		creator.setBoard(this);
		contador.setColor(creator.getRellenoCreaciones());
		elementos.add(creator);
		//GRID DE 12
		CreadorderCreadores x=new CreadorderCreadores();
		elementos.add(x);
		GrupoFisico suelo=new GrupoFisico(new Rectangle(Camara.W/4,Camara.H-50,Camara.W/2,50,new TexturaColor()));
		suelo.setTipoCuerpo(new CuerpoKinematico());
		elementos.add(suelo);
		elementos.add(new BotonFigura(new Hexagono(Camara.W-Camara.W/12,Camara.W/2,Camara.W/12, new TexturaColor()), creator));
		scroll=new Scroll();

	}
	public void addElementos(GrupoBloques grupoBloques)
	{
		elementos.add(grupoBloques);

		puntaje.addPuntaje(grupoBloques.getSize());
		scroll.setActivoSensor();
		creator.setColor(new TexturaColor());

	}
	public void dibujar()
	{
		scroll.detectarScroll(elementos);

		for (Drawable d:elementos)
			d.draw();
	}
	private void setContador(int max)
	{
		contador=new ContadorGrafico(Camara.W/13+10, Camara.W/1.5f,Camara.W/13,max);
	}
	public void animarContador()
	{
		contador.animar();
	}
	public void addPuntaje(int x)
	{
		puntaje.addPuntaje(x);
	}
}