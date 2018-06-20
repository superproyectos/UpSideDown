package com.upsidedown.juego;

import com.framework.Camara;
import com.framework.Figuras.Coord;
import com.upsidedown.juego.Actions.Restarter;
import com.upsidedown.juego.Buttons.BotonTexto;
import com.upsidedown.juego.Labels.GameOverLabel;

public class GameOverScreen
{
	private GameOverLabel label;
	private BotonTexto botonTexto;
	public GameOverScreen()
	{
		label=new GameOverLabel();
		botonTexto=new BotonTexto("Reiniciar",new Coord(Camara.W/2,Camara.H/2),new Restarter());
	}
}