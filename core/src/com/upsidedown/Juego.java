package com.upsidedown;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
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


public class Juego implements Screen
{
	Camara camara;
	Board board;
	Escenario escenario;
	Background background;
	static BackgroundImage f;
	MusicOfTheGame musicOfTheGame;
	public static boolean gameOver=false;
	public static boolean restart=false;
	public Juego()
	{
		initialize();
		musicOfTheGame=new MusicOfTheGame("Electrodoodle.mp3");

	}
	private void initialize()
	{
		Escenario.getESCENARIO().clear();

		Data.resetScore();
		Camara.setPPM(100);
		camara=new Camara();
		f=new BackgroundImage();
		board =new Board();
		escenario=new Escenario();
		background =new Daymer(Colores.getColor(  74, 35, 90 ,1),6);
		new ColisionManager();
	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		background.draw();
		if(!gameOver)
		{
			Mundo.WORLD.step(Gdx.graphics.getDeltaTime(), 6, 2);
			board.draw();
			Mundo.WORLD.setGravity(new Vector2(-Gdx.input.getAccelerometerX() / 10, 7f));
		}
		Escenario.act();
		Escenario.draw();
		if(restart)
		{
			Previsualizer.resetCounter();
			gameOver=false;
			restart=false;
			initialize();
		}
		//camara.modoDebug(Mundo.WORLD);
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
	public static void clear()
	{
		Escenario.getESCENARIO().clear();
		Mundo.destroyTheWorld();
		f=new BackgroundImage();
	}
}