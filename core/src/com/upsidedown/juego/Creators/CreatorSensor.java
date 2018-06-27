package com.upsidedown.juego.Creators;

import com.framework.Figuras.Poligonos.Polygon;
import com.upsidedown.juego.Actions.TouchCreator;
import com.upsidedown.juego.Buttons.Boton;

public class CreatorSensor extends Boton
{
	public CreatorSensor(Polygon p, Previsualizer previsualizer)
	{
		setBounds(p.getX()- p.getRadio(), p.getY()- p.getRadio(), p.getRadio()*2, p.getRadio()*2);
		addEventListener(new TouchCreator(p,previsualizer));
		addToStage();
	}
}