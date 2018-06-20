package com.upsidedown.juego.Creators;

import com.badlogic.gdx.graphics.Color;
import com.framework.Figuras.Poligonos.Square;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;


public class SquareCreator extends Creator
{
	public SquareCreator(float x, float y, float anchoCasilla, int filas, int columnas, float margen, TexturaRelleno relleno)
	{
		super();
		for(int i=0;i<filas;i++)
			for(int j=0;j<columnas;j++)
			{
				Square square =new Square(x + j * (anchoCasilla),
						y + i * (anchoCasilla), anchoCasilla-margen, getRellenoCreaciones());
				addCreatorSensor(new CreatorSensor(square,getPrevisualizer()));
				addElemento(new Square(x+j*anchoCasilla,y+i*anchoCasilla,anchoCasilla+margen,new TexturaColor(Color.WHITE)));
				addElemento(new Square(x + j * (anchoCasilla),
						y + i * (anchoCasilla), anchoCasilla - margen, relleno));
			}
	}
}