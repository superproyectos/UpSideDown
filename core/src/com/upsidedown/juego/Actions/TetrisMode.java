package com.upsidedown.juego.Actions;

import com.badlogic.gdx.utils.Array;
import com.upsidedown.FinalShape;
import com.upsidedown.Sonidos;

public class TetrisMode extends Action
{
	private Array<FinalShape> shapes;
	public TetrisMode(Array<FinalShape> shapes)
	{
		this.shapes=shapes;
	}
	@Override
	public void execute()
	{
		Sonidos.shoot();
		if(shapes.size>0)
			shapes.get(0).setTetrisMode();
		for(FinalShape shape:shapes)
			shape.staticProperties();
	}
}