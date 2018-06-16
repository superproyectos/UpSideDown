package com.upsidedown.juego;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Drawable;
import com.framework.Texturas.TexturaColor;

public class CreadorderCreadores implements Drawable
{
	private Array<ElementosCreadores>bloquescreadores=new Array<ElementosCreadores>();
	public CreadorderCreadores()
	{
		bloquescreadores.add(new CuadradoCreador(200,200,20,new TexturaColor(Color.PURPLE)));
	}
	@Override
	public void draw()
	{
		for(ElementosCreadores elemento:bloquescreadores)
			elemento.draw();
	}
}