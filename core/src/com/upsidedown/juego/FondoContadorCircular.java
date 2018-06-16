package com.upsidedown.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.framework.Camara;
import com.framework.Figuras.Circulos.Circulo;
import com.framework.Texturas.TexturaRelleno;

public class FondoContadorCircular
{
	private Circulo c1;
	private Circulo c2;
	private float MAX= 2*Camara.W/13;
	private float radio,radio2;
	private boolean actFondo;
	private TexturaRelleno relleno;

	public FondoContadorCircular(float x,float y, float radio,TexturaRelleno relleno)
	{
		this.relleno=relleno;
		this.radio=radio2=radio;
		c1=new Circulo(x,y,radio, relleno);
		c2=new Circulo(x,y,radio,relleno);
		actFondo=true;
	}
	public void dibujar()
	{
		c1.dibujar();
		if(actFondo)
		{
			Gdx.gl.glEnable(GL20.GL_BLEND);
			Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			radio+=0.5f;
			c2.setRadio(radio);
			c2.cambiaAlpha(-0.01f);
			if(radio>MAX)
			{
				actFondo=false;
				radio=radio2;
				c2.setColor(relleno);
				c2.setRadio(radio2);
			}
		}

		c2.dibujar();
	}
	public void animar()
	{
		actFondo=true;
	}
	public void setColor(TexturaRelleno relleno)
	{
		this.relleno = relleno;
		c1.setColor(relleno);
	}
}