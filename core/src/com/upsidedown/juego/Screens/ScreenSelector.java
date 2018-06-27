package com.upsidedown.juego.Screens;

public enum ScreenSelector
{

	GAME
			{
		@Override
		public com.badlogic.gdx.Screen getScreenInstance() {
			return new Juego();
		}
	},

	MAIN_MENU {
		@Override
		public com.badlogic.gdx.Screen getScreenInstance() {
			return new Juego();
		}
	},

	GAME_OVER
			{
		@Override
		public com.badlogic.gdx.Screen getScreenInstance() {
			return new GameOverScreen();
		}
	};

	public abstract com.badlogic.gdx.Screen getScreenInstance();

}