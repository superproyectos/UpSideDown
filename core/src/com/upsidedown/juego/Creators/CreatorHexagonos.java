package com.upsidedown.juego.Creators;

import com.badlogic.gdx.graphics.Color;
import com.framework.Figuras.Poligonos.Hexagono;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;

public class CreatorHexagonos extends Creator
{
	public CreatorHexagonos(float x, float y, float radio, int filas, int columnas, float margen, TexturaRelleno relleno)
	{
		super();

		for(int i=0;i<filas;i++)
		{
			x = i % 2 == 0 ? x + 2*(radio-radio/4-margen/4) : x - 2*(radio-radio/4-margen/4);
			for (int j = 0; j < (i%2==0?columnas-1:columnas); j++)
			{
				Hexagono hexagono=new Hexagono(x+j*3*(radio-margen/2), y+i*(radio-radio/8f-margen/2), radio-margen, getRellenoCreaciones());
				addCreatorSensor(new CreatorSensor(hexagono,getPrevisualizer()));
				addElemento(new Hexagono(x+j*3*(radio-margen/2), y+i*(radio-radio/8f-margen/2), radio, new TexturaColor(Color.WHITE)));
				addElemento(new Hexagono(x+j*3*(radio-margen/2), y+i*(radio-radio/8f-margen/2), radio-margen, relleno));

			}
		}
	}

}