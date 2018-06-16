package com.framework.Figuras;

import com.badlogic.gdx.math.Vector2;

public class Coord
{

	private float x,y;
	public Coord(float x,float y)
	{
		this.x=x;
		this.y=y;
	}
	public Vector2 getCoords()
	{
		return new Vector2(x,y);
	}
	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}
	public float getY()
	{
		return y;
	}
	public void setY(float y)
	{
		this.y = y;
	}
}