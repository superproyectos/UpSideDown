package com.upsidedown.juego.Actions;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.framework.Figuras.Poligonos.Polygon;
import com.upsidedown.juego.Creators.Previsualizer;
import com.upsidedown.juego.Creators.Putter;

public class TouchCreator extends Action
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
	public void execute()
	{
		Putter putter=new Putter(previsualizer);
		putter.put(polygon);
		putter.selectColor();
	}

	@Override
	public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
	{
		execute();
	}

	@Override
	public void touchUp (InputEvent event, float x, float y, int pointer, int button)
	{
		previsualizer.drop();
	}
}