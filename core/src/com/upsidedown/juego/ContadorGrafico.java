package com.upsidedown.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.framework.Escenario;
import com.framework.Figuras.Drawable;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;

import java.awt.Font;

public class ContadorGrafico extends Contador implements Drawable
{
	private Etiqueta faltantes;
	private FondoContadorCircular fondoContadorCircular;
	public ContadorGrafico(float x,float y,float radio,int max)
	{
		super(max);
		faltantes=new Etiqueta(x,y,"0");
		faltantes.setAlineacion(Font.CENTER_BASELINE);
		faltantes.setBounds(x-radio,y-radio,radio*2,radio*2);
		faltantes.escalar(1.5f);
		faltantes.setWrap(true);
		fondoContadorCircular =new FondoContadorCircular(x,y,radio,new TexturaColor(Colores.AZUL));
	}
	public void setColor(TexturaRelleno relleno)
	{
		fondoContadorCircular.setColor(relleno);
	}
	public void animar()
	{
		fondoContadorCircular.animar();
	}

	@Override
	public void nuevo()
	{
		super.nuevo();
		animar();
	}
	@Override
	public void draw()
	{
		faltantes.setTexto(Integer.toString(getContador()>0?getContador():0));
		fondoContadorCircular.dibujar();
	}
}