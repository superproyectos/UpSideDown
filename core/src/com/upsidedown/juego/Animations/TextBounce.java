package com.upsidedown.juego.Animations;


import com.upsidedown.juego.LabelOfGame;

public class TextBounce implements Animation
{
	private LabelOfGame label;
	private float ang=0;
	public TextBounce(LabelOfGame label)
	{
		this.label =label;
	}
	@Override
	public void animate()
	{
		ang=(ang+0.05f)%(2*3.141592653589f);
		label.escalar(1.8f+(float)Math.cos(ang)*.1f);
	}

	@Override
	public void letsAnimate()
	{

	}
}