package com.upsidedown.juego.Actions;

import com.badlogic.gdx.utils.Array;
import com.upsidedown.FinalShape;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Actions.Action;

public class Freezer extends Action
{
	private Array<FinalShape> elementos=new Array<FinalShape>();
	public Freezer(Array<FinalShape> shapes)
	{
		this.elementos=shapes;
	}
	@Override
	public void execute()
	{
		Sonidos.congelar();
		for(FinalShape a:elementos)
			a.freez();
	}


}