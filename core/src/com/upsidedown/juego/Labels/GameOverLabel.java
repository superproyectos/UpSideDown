package com.upsidedown.juego.Labels;

import com.framework.Camara;
import com.upsidedown.Juego;
import com.upsidedown.juego.LabelOfGame;

public class GameOverLabel
{
	private LabelOfGame labelOfGame;
	public GameOverLabel()
	{
		Juego.clear();
		labelOfGame=new LabelOfGame(0, Camara.H/2,"Game Over");
		labelOfGame.setBounds(0,Camara.H/2,Camara.W,20);
		labelOfGame.escalar(1.8f);
	}
}