package com.upsidedown.juego;

import com.framework.Figuras.Drawable;

import java.util.Random;

public abstract class Counter implements Drawable
{
	private int contador,aux;
	private int max;
	public Counter(int max)
	{
		this.max=max;
		contador=aux=numAleatorio();

	}
	private int numAleatorio()
	{
		return new Random(System.currentTimeMillis()).nextInt(max)+1;
	}
	public int getContador()
	{
		return contador;
	}
	public void resetear()
	{
		contador=aux;
	}
	public void nuevo()
	{
		contador=aux=numAleatorio();
	}
	public void setContador(int contador)
	{
		this.contador = contador;
	}
	public void decrementa()
	{
		contador--;
	}
	public void incrementa()
	{
		contador++;
	}
}