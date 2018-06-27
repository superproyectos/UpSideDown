package com.upsidedown.juego.Screens;

import com.badlogic.gdx.Screen;
import com.framework.Camara;
import com.framework.Escenario;
import com.framework.Figuras.Coord;
import com.framework.Texturas.Colores;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Actions.Restarter;
import com.upsidedown.juego.Background.Background;
import com.upsidedown.juego.Background.BackgroundImage;
import com.upsidedown.juego.Background.Daymer;
import com.upsidedown.juego.Buttons.BotonTexto;
import com.upsidedown.juego.Buttons.PowerUp;
import com.upsidedown.juego.Labels.GameOverLabel;

public class GameOverScreen implements Screen
{
	private GameOverLabel label;
	private PowerUp restart;
	private Background background;
	private BackgroundImage f;

	public GameOverScreen()
	{
		Sonidos.gameOver();
		Escenario.getESCENARIO().clear();
		f=new BackgroundImage();
		background =new Daymer(Colores.getColor(  74, 35, 90 ,1),6);
		show();
	}

	@Override
	public void show()
	{
		label=new GameOverLabel();
		restart=new PowerUp(new Coord(Camara.W/2-Camara.W/10,Camara.H/2-Camara.W/3),"restart.png",new Restarter());
	}

	@Override
	public void render(float delta)
	{
		background.draw();
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