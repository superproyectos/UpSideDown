package com.upsidedown.juego.Creators;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Grupos.Grupo;
import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.juego.Board;

public abstract class Creator extends Grupo
{
	private Array<CreatorSensor> creationArea=new Array<CreatorSensor>();

	private static Previsualizer previsualizer=new Previsualizer();

	public Creator()
	{
		previsualizer.setCounter();
		setColor(new TexturaColor());
	}

	public void setBoard(Board board)
	{
		previsualizer.setBoard(board);
	}

	@Override
	public void draw()
	{
		super.draw();
		previsualizer.draw();
	}

	public Array<CreatorSensor> getCreationArea()
	{
		return creationArea;
	}

	public void addCreatorSensor(CreatorSensor creatorSensor)
	{
		creationArea.add(creatorSensor);
	}

	public void setColor(TexturaRelleno relleno)
	{
		previsualizer.setBackground(relleno);
	}

	public TexturaRelleno getRellenoCreaciones()
	{
		return previsualizer.getCreation().getRelleno();
	}

	@Override
	public void clear()
	{
		for(CreatorSensor a: creationArea)
			a.remove();
		previsualizer.clear();
		super.clear();
	}

	public Polygon typeStored()
	{
		return getElementos().get(0);
	}

	public void sustituirCreador(Creator c)
	{
		clear();
		creationArea =c.getCreationArea();
		setElementos(c.getElementos());
	}

	public Previsualizer getPrevisualizer()
	{
		return previsualizer;
	}

}