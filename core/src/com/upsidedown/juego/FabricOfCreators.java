package com.upsidedown.juego;

import com.framework.Camara;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.juego.Creators.HexagonCreator;
import com.upsidedown.juego.Creators.SquareCreator;

public class FabricOfCreators
{
	private Creator creator;

	public Creator createSquareCreator(Board board)
	{
		creator=new SquareCreator(Camara.W/4,Camara.W/8,Camara.W/8,3,5,5, new TexturaColor(Colores.getColor(105, 52, 127,1)));
		creator.setBoard(board);
		return creator;
	}
	public Creator createHexagonCreator(Board board)
	{
		creator =new HexagonCreator(Camara.W/4,Camara.W/8,Camara.W/12,5,3,5, new TexturaColor(Colores.getColor(105, 52, 127,1)));
		creator.setBoard(board);
		return creator;
	}
	public void draw()
	{
		creator.draw();
	}
}