package com.upsidedown.juego.Game;

import com.badlogic.gdx.utils.Array;
import com.upsidedown.FinalShape;

public class SetOfShapes
{
	private Array<FinalShape> shapes;

	public SetOfShapes()
	{
		shapes=new Array<FinalShape>();
	}

	public void addToSet(FinalShape finalShape)
	{
		shapes.add(finalShape);
	}

	public void draw()
	{
		for (FinalShape f:shapes)
			f.draw();
	}

	public Array<FinalShape> getShapes()
	{
		return shapes;
	}

}