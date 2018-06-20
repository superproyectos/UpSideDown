package com.upsidedown.juego;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Drawable;
import com.upsidedown.FinalShape;
import com.upsidedown.Sonidos;

public class Congelar extends Action
{
	private Array<FinalShape> elementos=new Array<FinalShape>();
	public Congelar(Array<FinalShape> shapes)
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