package com.upsidedown.juego.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.framework.Camara;
import com.framework.Escenario;
import com.framework.Figuras.Fisicas.Mundo;
import com.upsidedown.juego.Background.BackgroundImage;
import com.framework.Texturas.Colores;
import com.upsidedown.juego.Background.Daymer;
import com.upsidedown.juego.Background.Background;
import com.upsidedown.juego.Colisions.ColisionManager;
import com.upsidedown.juego.Creators.Previsualizer;
import com.upsidedown.juego.Data.Data;
import com.upsidedown.juego.Game.Board;
import com.upsidedown.juego.MusicOfTheGame;
import com.upsidedown.juego.Screens.ScreenManager;
import com.upsidedown.juego.Screens.ScreenSelector;


public class Juego implements Screen
{
	private Camara camara;
	private Board board;
	private Escenario escenario;
	private Background background;
	private BackgroundImage f;

	public Juego()
	{
		show();
	}

	private void initialize()
	{
		camara=new Camara();
		f=new BackgroundImage();
		Data.resetScore();
		board =new Board();
		escenario=new Escenario();
		background =new Daymer(Colores.getColor(  74, 35, 90 ,1),6);
		new ColisionManager();

	}
	private void clear()
	{
		Escenario.getESCENARIO().clear();
		Mundo.destroyTheWorld();
		Camara.setPPM(100);
		Previsualizer.resetCounter();
	}
	@Override
	public void show()
	{
		clear();
		initialize();
	}

	@Override
	public void render(float delta)
	{
		background.draw();
		Mundo.WORLD.step(Gdx.graphics.getDeltaTime(), 6, 2);
		board.draw();
		Mundo.WORLD.setGravity(new Vector2(-Gdx.input.getAccelerometerX() / 10, 7f));
		Escenario.act();
		Escenario.draw();
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{

	}
}