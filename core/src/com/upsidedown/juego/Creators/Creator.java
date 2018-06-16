package com.upsidedown.juego.Creators;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Grupos.Grupo;

import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.GrupoBloques;
import com.upsidedown.juego.BloqueCreador;
import com.upsidedown.juego.Board;

public abstract class Creator extends Grupo
{
	private Array<BloqueCreador>lienzo=new Array<BloqueCreador>();
	private Previsualizer previsualizer=new Previsualizer();
	private Board board;

	public Creator()
	{
		setBackground(new TexturaColor());
	}
	public Creator(Polygon...elementos)
	{
		super(elementos);
	}
	public Creator(Array<Polygon> poligonos)
	{
		super(poligonos);
	}


	public Board getBoard()
	{
		return board;
	}
	public void setBoard(Board board)
	{
		this.board = board;
	}
	public void addToBoard(GrupoBloques p)
	{
		board.addElementos(p);
	}


	@Override
	public void dibujar()
	{
		super.dibujar();
		previsualizer.draw();
	}

	public Array<BloqueCreador> getLienzo()
	{
		return lienzo;
	}
	public void addLienzo(BloqueCreador bloqueCreador)
	{
		lienzo.add(bloqueCreador);
	}

	public void setBackground(TexturaRelleno relleno)
	{
		previsualizer.setBackground(relleno);
	}
	public void cambiarRelleno(Creation c, TexturaRelleno relleno)
	{
		c.cambiarRelleno(relleno);
	}

	public TexturaRelleno getRellenoCreaciones()
	{
		return previsualizer.getCreation().getRelleno();
	}


	public void limpiar()
	{
		for(BloqueCreador a:lienzo)
			a.remove();

		previsualizer.getCreation().limpiar();
		previsualizer.getPreview().limpiar();
		super.limpiar();
	}
	public Polygon tipoAlmacenado()
	{
		return getElementos().get(0);
	}
	public void sustituirCreador(Creator c)
	{
		limpiar();
		lienzo=c.getLienzo();
		setPrevisualizer(c.getPrevisualizer());
		c.setBoard(board);
		setElementos(c.getElementos());
	}

	public Previsualizer getPrevisualizer()
	{
		return previsualizer;
	}

	public void setPrevisualizer(Previsualizer previsualizer)
	{
		this.previsualizer = previsualizer;
	}
}