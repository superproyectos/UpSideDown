package com.upsidedown.juego.Creators;

import com.framework.Figuras.Grupos.Grupo;
import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.TexturaRelleno;

public class Creation extends Grupo
{
	private TexturaRelleno relleno;
	public void cambiarRelleno(TexturaRelleno relleno)
	{
		for(Polygon p:getElementos())
			p.cambiarRelleno(relleno);
	}

	public TexturaRelleno getRelleno()
	{
		return relleno;
	}

	public void setRelleno(TexturaRelleno relleno)
	{
		this.relleno = relleno;
		cambiarRelleno(relleno);
	}
}