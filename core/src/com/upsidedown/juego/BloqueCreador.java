package com.upsidedown.juego;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.framework.Escenario;
import com.framework.Figuras.Poligonos.Polygon;
import com.upsidedown.juego.Creators.Creator;

public class BloqueCreador extends Actor
{
	public Polygon polygon;
	private EventListener evento;
	public BloqueCreador(Polygon p, Creator g)
	{
		polygon =p;
		evento=new Toque(polygon,g);
		this.addListener(evento);
		setBounds(polygon.getX()- polygon.getRadio(), polygon.getY()- polygon.getRadio(), polygon.getRadio()*2, polygon.getRadio()*2);
		Escenario.addActor(this);
	}
}