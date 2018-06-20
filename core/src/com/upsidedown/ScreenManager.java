package com.upsidedown;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public final class ScreenManager {

	private static ScreenManager screenManager;

	private Game game;

	private ScreenManager() {
	}

	public static ScreenManager getScreenManager() {
		if (null == screenManager) {
			screenManager = new ScreenManager();
		}
		return screenManager;
	}

	public void initialize(Game game) {
		this.game = game;
	}
	public void show(Screen screen) {
		if (null == game) return;
			game.setScreen(screen);
	}
}