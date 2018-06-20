package com.upsidedown.juego.Counters;

import com.framework.Figuras.Circulos.Circulo;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.juego.Animations.Animation;
import com.upsidedown.juego.Animations.CircleFader;

public class CounterBackground
{
	private Circulo c1;

	private Animation animation;

	public CounterBackground(float x, float y, float radio, TexturaRelleno relleno)
	{
		c1=new Circulo(x,y,radio, relleno);
		animation=new CircleFader(new Circulo(x,y,radio,relleno),relleno);
	}

	public void draw()
	{
		c1.draw();
		animation.animate();
	}

	public void animate()
	{
		animation.letsAnimate();
	}

	public void setBackground(TexturaRelleno relleno)
	{
		c1.setColor(relleno);
		animation=new CircleFader(new Circulo(c1.getX(),c1.getY(),c1.getRadio(),relleno),relleno);
	}
}