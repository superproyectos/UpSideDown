package com.upsidedown.juego.Actions;

import com.framework.Camara;
import com.framework.Figuras.Poligonos.Hexagono;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.juego.Creators.SquareCreator;
import com.upsidedown.juego.Creators.HexagonCreator;

public class CreatorChanger extends Action
{
	private Creator creator;

	public CreatorChanger(Creator creator)
	{
		this.creator = creator;
	}

	@Override
	public void execute()
	{
		if(creator.typeStored() instanceof Hexagono)
			creator.sustituirCreador(new SquareCreator(Camara.W/4,Camara.W/8,Camara.W/8,3,5,5, new TexturaColor(Colores.getColor(105, 52, 127,1))));
		else
			creator.sustituirCreador(new HexagonCreator(Camara.W/4,Camara.W/8,Camara.W/12,5,3,5, new TexturaColor(Colores.getColor(105, 52, 127,1))));
	}
}