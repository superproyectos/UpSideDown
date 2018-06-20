package com.upsidedown.juego.Data;

import com.framework.Camara;

public class Data
{
	public static Score score;
	public static void resetScore()
	{
		score=(new GraphicScore(30,Camara.H-30,1.5f));
	}
}