package com.upsidedown.juego;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.framework.Camara;
import com.framework.Figuras.Poligonos.Hexagono;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.juego.Creators.SquareCreator;
import com.upsidedown.juego.Creators.HexagonCreator;

public class Presion extends InputListener
{
	private Creator creator;
	public Presion(Creator creator)
	{
		this.creator = creator;
	}
	@Override
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button)
	{
		if(creator.typeStored() instanceof Hexagono)
			creator.sustituirCreador(new SquareCreator(Camara.W/4,Camara.W/8,Camara.W/8,3,5,5, new TexturaColor(Colores.getColor(105, 52, 127,1))));
		else
			creator.sustituirCreador(new HexagonCreator(Camara.W/4,Camara.W/8,Camara.W/12,5,3,5, new TexturaColor(Colores.getColor(105, 52, 127,1))));
		return true;
	}
}