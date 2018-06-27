package com.upsidedown;

import com.badlogic.gdx.Game;
import com.upsidedown.juego.MusicOfTheGame;
import com.upsidedown.juego.Screens.ScreenManager;
import com.upsidedown.juego.Screens.ScreenSelector;

public class Main extends Game
{
	private MusicOfTheGame musicOfTheGame;
	@Override
	public void create()
	{

		ScreenManager.getInstance().initialize(this);
		ScreenManager.getInstance().showScreen(ScreenSelector.GAME);
		musicOfTheGame=new MusicOfTheGame("Electrodoodle.mp3");
	}
}
