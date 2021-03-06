package com.upsidedown.juego.Buttons;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.framework.Escenario;
import com.framework.Figuras.Poligonos.Polygon;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.juego.Actions.CreatorChanger;


public class BotonFigura extends Boton
{
	public Polygon polygon;
	private EventListener evento;
	public BotonFigura(Polygon p, Creator g)
	{
		polygon =p;
		evento=new CreatorChanger(g);
		this.addListener(evento);
		setBounds(polygon.getX()- polygon.getRadio(), polygon.getY()- polygon.getRadio(), polygon.getRadio()*2, polygon.getRadio()*2);
		Escenario.addActor(this);
	}
	@Override
	public void draw()
	{
		polygon.draw();
	}
}