package com.upsidedown.juego.Buttons;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.framework.Escenario;
import com.framework.Figuras.Drawable;
import com.upsidedown.juego.Actions.Action;

public abstract class Boton extends Actor implements Drawable
{
	private Action evento;

	public void addEventListener(Action evento)
	{
		this.evento = evento;
		this.addListener(this.evento);

	}
	public void addToStage()
	{
		Escenario.addActor(this);
	}
	@Override
	public void draw()
	{

	}
}