package com.upsidedown.juego.Creators;

import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.GrupoBloques;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Board;

public class Previsualizer
{
	private Creation creation =new Creation();

	private Preview preview =new Preview();

	private Board board;

	public Preview getPreview()
	{
		return preview;
	}

	public Creation getCreation()
	{
		return creation;
	}

	public void setBackground(TexturaRelleno relleno)
	{
		creation.setRelleno(relleno);
		preview.setRelleno(relleno);

	}
	public void clear()
	{
		creation.clear();
		preview.clear();
	}
	public void draw()
	{
		creation.draw();
		preview.draw();
	}

	public void setBoard(Board board)
	{
		this.board = board;
	}

	public Board getBoard()
	{
		return board;
	}

	public void becomeReal()
	{
		Sonidos.suelta();
		preview.resultadoFinal();
		GrupoBloques resultado = new GrupoBloques(preview);
		resultado.setDensidad(1);
		resultado.setFriccion(0.5f);
		resultado.setRebote(0.1f);
		clear();
		board.addElementos(resultado);
		changeCounterColor();
	}
	private void changeCounterColor()
	{
		Board.contador.nuevo();
		Board.contador.setColor(preview.getRelleno());
	}
}