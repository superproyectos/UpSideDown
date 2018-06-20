package com.upsidedown.juego;


public class ScoreGrafico extends Score
{
	private Etiqueta puntaje;
	public ScoreGrafico(float x, float y, float s)
	{
		puntaje=new Etiqueta(x,y,"0");
		puntaje.setAlineacion(0);
		puntaje.escalar(s);
	}
	@Override
	public void addPuntaje(int x)
	{
		super.addPuntaje(x);
		puntaje.setTexto(getPuntos());
	}
}