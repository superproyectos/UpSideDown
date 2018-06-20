package com.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Escenario
{
	private static Stage ESCENARIO=new Stage();
	public Escenario()
	{
		Gdx.input.setInputProcessor(ESCENARIO);
	}
	public static Stage getESCENARIO()
	{
		return ESCENARIO;
	}
	public static void setESCENARIO(Stage s)
	{
		ESCENARIO=s;
	}
	public static void act()
	{
		ESCENARIO.act();
	}
	public static void draw()
	{
		ESCENARIO.draw();
	}
	public static void addActor(Actor actor)
	{
		ESCENARIO.addActor(actor);
	}
	public static boolean isOnStage(Actor actor)
	{
		for(Actor a:ESCENARIO.getActors())
			if(a.equals(actor))
				return true;
		return false;
	}
}