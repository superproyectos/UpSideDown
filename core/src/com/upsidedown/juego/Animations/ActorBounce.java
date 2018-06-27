package com.upsidedown.juego.Animations;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorBounce implements Animation
{
	private Actor image;
	private float ang=0;
	public ActorBounce(Actor image)
	{
		this.image=image;
	}
	@Override
	public void animate()
	{
		ang=(ang+0.05f)%(2*3.141592653589f);
		image.setScale(1+(float)Math.cos(ang)*.1f);
	}

	@Override
	public void letsAnimate()
	{

	}
}