package com.upsidedown.juego.Creators;

import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.TexturaRelleno;

public class Previsualizer
{
	private Creation creation =new Creation();
	private Preview preview =new Preview();

	public Preview getPreview()
	{
		return preview;
	}

	public Creation getCreation()
	{
		return creation;
	}
	public void setCreation(Creation creation)
	{
		this.creation=creation;
	}
	public void setPreview(Creation creation)
	{
		this.creation=creation;
	}

	public void addCreation(Polygon polygon)
	{
		creation.addElemento(polygon);
	}

	public void setBackground(TexturaRelleno relleno)
	{
		creation.setRelleno(relleno);
		preview.setRelleno(relleno);

	}
	public void clear()
	{
		creation.limpiar();
		preview.limpiar();
	}
	public void draw()
	{
		creation.dibujar();
		preview.dibujar();
	}
}