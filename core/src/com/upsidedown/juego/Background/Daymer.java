package com.upsidedown.juego.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.framework.Texturas.Colores;


public class Daymer extends BackgroundColor
{
	private float ang;
	public Daymer(Color color,float hora)
	{
		super(color);
		ang=(float)Math.toRadians(hora*7.5);
	}

	@Override
	public void draw()
	{
		ang+=0.02;
		ang%=Math.PI;
		if(ang<0.02)
			setColor(Colores.degradado(Colores.aleatorio(),50));
		float aux=Math.abs((float)Math.sin(ang));
		Gdx.gl.glClearColor(getColor().r*aux,
				getColor().g*aux,
				getColor().b*aux,getColor().a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	}
}