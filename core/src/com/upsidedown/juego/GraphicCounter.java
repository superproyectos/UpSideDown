package com.upsidedown.juego;

import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;
import java.awt.Font;

public class GraphicCounter extends Counter
{
	private Etiqueta faltantes;
	private FondoContadorCircular fondoContadorCircular;
	public GraphicCounter(float x, float y, float radio, int max)
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