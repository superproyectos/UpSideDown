package com.upsidedown.juego.Buttons;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.framework.Escenario;
import com.framework.Figuras.Drawable;

public abstract class Boton extends Actor implements Drawable
{
	private EventListener evento;

	public void addEventListener(EventListener evento)
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