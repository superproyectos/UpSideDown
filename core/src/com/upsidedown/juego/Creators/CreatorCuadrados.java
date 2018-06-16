package com.upsidedown.juego.Creators;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Figuras.Poligonos.Square;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.juego.BloqueCreador;


public class CreatorCuadrados extends Creator
{
	public CreatorCuadrados(float x, float y, float anchoCasilla, int filas, int columnas, float margen, TexturaRelleno relleno)
	{
		super();
		for(int i=0;i<filas;i++)
			for(int j=0;j<columnas;j++)
			{
				Square square =new Square(x + j * (anchoCasilla),
						y + i * (anchoCasilla), anchoCasilla-margen, getRellenoCreaciones());
				addLienzo(new BloqueCreador(square,this));
				addElemento(new Square(x+j*anchoCasilla,y+i*anchoCasilla,anchoCasilla+margen,new TexturaColor(Color.WHITE)));
				addElemento(new Square(x + j * (anchoCasilla),
						y + i * (anchoCasilla), anchoCasilla - margen, relleno));
			}
	}
	public CreatorCuadrados(Polygon...elementos)
	{
		super(elementos);
	}
	public CreatorCuadrados(Array<Polygon> poligonos)
	{
		super(poligonos);
	}
}