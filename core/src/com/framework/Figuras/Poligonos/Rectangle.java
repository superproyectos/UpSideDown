package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

public class Rectangle extends Polygon
{
	public Rectangle(float x, float y, float ancho, float alto, TexturaRelleno relleno)
	{
		setCentro((x+ancho)/2,(y+alto)/2);
		setRelleno(relleno);
		setVertex(new Vertex(new float[]{x,y,x+ancho,y,x+ancho,y+alto,x,y+alto},null));
		setPoligono(crearPoligono(getRelleno(), getVertex()));
		setOrigenPoligono();
	}
	public Rectangle copy()
	{
		//return new Heptagon(polygon.getX(),polygon.getY(),polygon.getRadio(),polygon.getRelleno());
		return null;
	}
}