package com.upsidedown;

import com.badlogic.gdx.Game;

public class Main extends Game
{
	@Override
	public void create ()
	{
		ScreenManager.getScreenManager().initialize(this);
		ScreenManager.getScreenManager().show(new Juego());
	}
}
