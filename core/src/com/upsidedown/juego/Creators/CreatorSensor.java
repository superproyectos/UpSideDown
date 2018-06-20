package com.upsidedown.juego.Creators;

import com.framework.Escenario;
import com.framework.Figuras.Poligonos.Polygon;
import com.upsidedown.juego.Buttons.Boton;

public class CreatorSensor extends Boton
{
	public Polygon polygon;
	public CreatorSensor(Polygon p, Previsualizer previsualizer)
	{
		polygon =p;
		setBounds(polygon.getX()- polygon.getRadio(), polygon.getY()- polygon.getRadio(), polygon.getRadio()*2, polygon.getRadio()*2);
		addEventListener(new TouchCreator(polygon,previsualizer));
		addToStage();
	}
}