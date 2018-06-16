package com.upsidedown.juego.Creators;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Board;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.GrupoBloques;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Creators.Putter;

public class TouchCreator extends InputListener
{
	private Polygon polygon;
	private Previsualizer previsualizer;
	public TouchCreator(Polygon p, Previsualizer previsualizer)
	{
		polygon =p;
		this.previsualizer =previsualizer;
	}
	@Override
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button)
	{
		return true;
	}
	@Override
	public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
	{
		Putter putter=new Putter(previsualizer);
		putter.put(polygon);
		putter.selectColor();
	}
	@Override
	public void touchUp (InputEvent event, float x, float y, int pointer, int button)
	{
		if(Board.contador.getContador()==0)
			previsualizer.becomeReal();
		else
		{
			Board.contador.resetear();
			previsualizer.clear();
		}
	}
}