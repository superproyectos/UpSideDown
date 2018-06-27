package com.upsidedown.juego.Actions;

import com.upsidedown.juego.Screens.ScreenManager;
import com.upsidedown.juego.Screens.ScreenSelector;

public class Restarter extends Action
{
	@Override
	public void execute()
	{
		ScreenManager.getInstance().showScreen(ScreenSelector.GAME);
	}
}