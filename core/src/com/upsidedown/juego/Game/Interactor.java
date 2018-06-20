package com.upsidedown.juego.Game;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Drawable;

public class Interactor
{
	private Array<Drawable> drawables;

	public Interactor()
	{
		drawables=new Array<Drawable>();
	}

	public void add(Drawable drawable)
	{
		drawables.add(drawable);
	}

	public void draw()
	{
		for (Drawable d:drawables)
			d.draw();
	}
}