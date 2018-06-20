package com.upsidedown.juego.Actions.Drag;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class Drag extends DragListener
{
	private Dragable elemento;

	public Drag(Dragable elemento)
	{
		this.elemento=elemento;
	}

	@Override
	public void touchDragged(InputEvent event, float x, float y, int pointer)
	{
		this.elemento.drag(x,y);
	}
}