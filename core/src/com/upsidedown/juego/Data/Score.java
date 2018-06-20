package com.upsidedown.juego.Data;

public class Score
{
	private int puntos;

	public Score()
	{
		puntos=0;
	}

	public int getPuntos()
	{
		return puntos;
	}

	public void setPuntos(int puntos)
	{
		if (puntos>0)
			this.puntos = puntos;
	}

	public void addScore(int x)
	{
		puntos+=x;
	}
}