package com.upsidedown.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.framework.Escenario;
import com.upsidedown.juego.Animations.Animation;
import com.upsidedown.juego.Animations.TextBounce;

import java.awt.Font;

public class LabelOfGame
{
	private Label label;
	private Animation animation;
	public LabelOfGame(float x, float y, String s)
	{
		label=new Label(s,new Skin(Gdx.files.internal("skin/quantum-horizon-ui.json")));
		label.setAlignment(Font.CENTER_BASELINE);
		label.setPosition(x,y);
		label.getStyle().fontColor= Color.WHITE;
		//label.setWrap(true);
		Escenario.addActor(label);
	}
	public void setBounds(float x,float y,float w,float h)
	{
		label.setBounds(x,y,w,h);
	}
	public void setWrap(boolean wrap)
	{
		label.setWrap(wrap);
	}
	public void setColor(Color color)
	{
		label.getStyle().fontColor= color;
	}
	public void escalar(float escala)
	{
		label.setFontScale(escala);
	}
	public void setTexto(String s)
	{
		label.setText(s);
	}
	public void setTexto(int n)
	{
		label.setText(Integer.toString(n>0?n:0));
	}
	public void setAlineacion(int alineacion)
	{
		label.setAlignment(alineacion);
	}
	public void remove()
	{
		label.remove();
	}

	public void setAnimation(Animation animation)
	{
		this.animation=animation;
	}
	public void animate()
	{
		if (animation!=null)
			animation.animate();
	}
}