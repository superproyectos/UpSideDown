package com.upsidedown.juego;


import com.framework.Figuras.Poligonos.Square;
import com.framework.Texturas.TexturaRelleno;

public class CuadradoCreador extends ElementosCreadores
{
	public CuadradoCreador(float x, float y, float lado, TexturaRelleno relleno)
	{
		setFigura(new Square(x,y,lado,relleno));
		setBounds(x-lado,y-lado,2*lado,2*lado);
		establecerDrag();
	}

}