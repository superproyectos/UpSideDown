package com.upsidedown;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;
import com.framework.Camara;
import com.framework.Escenario;
import com.framework.Figuras.Fisicas.Mundo;
import com.upsidedown.juego.FondoImagen;
import com.framework.Texturas.Colores;
import com.upsidedown.juego.Daymer;
import com.upsidedown.juego.Fondo;
import com.upsidedown.juego.Board;


public class Juego implements Screen
{
	Camara camara;
	Board board;
	Escenario escenario;
	Fondo fondo;
	FondoImagen f;
	Music musica;
	public Juego()
	{
		Camara.setPPM(100);
		camara=new Camara();
		f=new FondoImagen();
		board =new Board();
		escenario=new Escenario();
		Mundo.MUNDO.setGravity(new Vector2(0,7f));
		fondo=new Daymer(Colores.getColor(  74, 35, 90 ,1),6);

	}
	@Override
	public void show()
	{
		musica = Gdx.audio.newMusic(Gdx.files.getFileHandle("Electrodoodle.mp3", Files.FileType.Internal));
		musica.play();
		musica.setLooping(true);
	}

	@Override
	public void render(float delta)
	{

		Mundo.MUNDO.step(Gdx.graphics.getDeltaTime(),6,2);
		fondo.dibujar();
		board.dibujar();
		Escenario.act();
		Escenario.draw();
		Mundo.MUNDO.setGravity(new Vector2(-Gdx.input.getAccelerometerX()/10,7f));
		//camara.modoDebug(Mundo.MUNDO);
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