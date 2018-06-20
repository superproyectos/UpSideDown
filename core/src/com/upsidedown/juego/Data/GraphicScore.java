package com.upsidedown.juego.Data;

import com.upsidedown.juego.LabelOfGame;

public class GraphicScore extends Score
{
	private LabelOfGame score;

	public GraphicScore(float x, float y, float s)
	{
		score =new LabelOfGame(x,y,"0");
		score.setAlineacion(0);
		score.escalar(s);
	}

	@Override
	public void addScore(int x)
	{
		super.addScore(x);
		score.setTexto(getPuntos());
	}
}