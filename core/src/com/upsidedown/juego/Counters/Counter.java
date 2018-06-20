package com.upsidedown.juego.Counters;

import com.framework.Figuras.Drawable;
import java.util.Random;

public abstract class Counter implements Drawable
{
	private int contador,aux;

	private int max;

	public Counter(int max)
	{
		this.max=max;
		contador=aux= randomNum();
	}

	private int randomNum()
	{
		return new Random(System.currentTimeMillis()).nextInt(max)+1;
	}

	public int getCounter()
	{
		return contador;
	}

	public void reset()
	{
		contador=aux;
	}

	public void newCounter()
	{
		contador=aux= randomNum();
	}

	public void decrease()
	{
		contador--;
	}

	public void increase()
	{
		contador++;
	}
}