package com.upsidedown.juego.Creators;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.framework.Escenario;
import com.framework.Figuras.Poligonos.Polygon;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.juego.Creators.TouchCreator;

public class CreatorSensor extends Actor
{
	public Polygon polygon;
	private EventListener evento;
	public CreatorSensor(Polygon p, Previsualizer previsualizer)
	{
		polygon =p;
		evento=new TouchCreator(polygon,previsualizer);
		this.addListener(evento);
		setBounds(polygon.getX()- polygon.getRadio(), polygon.getY()- polygon.getRadio(), polygon.getRadio()*2, polygon.getRadio()*2);
		Escenario.addActor(this);
	}
}