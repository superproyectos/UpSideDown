package com.upsidedown.juego.Actions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public abstract class Action extends InputListener
{
	@Override
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button)
	{
		execute();
		return true;
	}

	public abstract void execute();
}