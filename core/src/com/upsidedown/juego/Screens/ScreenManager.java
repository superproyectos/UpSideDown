package com.upsidedown.juego.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager
{
	private static ScreenManager instance;

	private Game game;

	public static ScreenManager getInstance()
	{
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}
	public void initialize(Game game) {
		this.game = game;
	}

	public void showScreen(ScreenSelector screenEnum)
	{
		Screen currentScreen = game.getScreen();
		Screen newScreen = screenEnum.getScreenInstance();
		game.setScreen(newScreen);
		if (currentScreen != null)
			currentScreen.dispose();
	}
}