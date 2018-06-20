package com.upsidedown.juego.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.framework.Camara;
import com.framework.Figuras.Circulos.Circulo;
import com.framework.Texturas.TexturaRelleno;

public class CircleFader implements Animation
{
	private Circulo circle;
	private float radius, originalRadius;
	private boolean doAnimation = true;
	private TexturaRelleno background;
	private final float MAX = 2 * Camara.W / 13;

	public CircleFader(Circulo circle, TexturaRelleno background)
	{
		this.circle = circle;
		radius = originalRadius = circle.getRadio();
		this.background = background;
	}

	@Override
	public void letsAnimate()
	{
		doAnimation = true;
	}

	@Override
	public void animate()
	{
		if (doAnimation)
		{
			changeAlpha();
			resize();
			circle.draw();
			Gdx.gl.glEnable(GL20.GL_NONE);
		}
	}

	private void reset()
	{
		doAnimation =false;
		radius=originalRadius;
		circle.setColor(background);
		circle.setRadio(radius);
	}

	private void resize()
	{
		radius+=0.4f;
		circle.setRadio(radius);
		if(radius>MAX)
			reset();
	}

	private void changeAlpha()
	{
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		circle.cambiaAlpha(-0.015f);
	}
}