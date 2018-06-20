package com.upsidedown.juego.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.framework.Camara;
import com.framework.Escenario;
import com.framework.Figuras.Coord;
import com.upsidedown.juego.Actions.Action;

public class BotonTexto extends Boton
{
	private TextButton button;
	public BotonTexto(String text, Coord pos, final Action action)
	{
		button=new TextButton(text,new Skin(Gdx.files.internal("skin/quantum-horizon-ui.json")));
		button.setScale(5);
		button.setPosition(pos.getX()-button.getWidth()/2,pos.getY()-2*button.getHeight());
		setBounds(button.getX(),button.getY(),button.getWidth(),button.getHeight());
		addEventListener(action);
		Escenario.getESCENARIO().addActor(button);
		addToStage();
	}
}