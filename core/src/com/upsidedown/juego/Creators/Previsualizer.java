package com.upsidedown.juego.Creators;

import com.framework.Camara;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.FinalShape;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Board;
import com.upsidedown.juego.GraphicCounter;
import com.upsidedown.juego.Data;

public class Previsualizer
{
	private final int MAX_NUM_OF_BLOCKS=7;

	private Creation creation =new Creation();

	private Preview preview =new Preview();

	private static GraphicCounter counter;

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
		counter.draw();
	}

	public void setBoard(Board board)
	{
		this.board = board;
	}

	public void becomeReal()
	{
		Sonidos.suelta();
		preview.resultadoFinal();
		FinalShape result = new FinalShape(preview);
		clear();
		board.addElement(result);
		Data.score.addPuntaje(result.getSize());
		changeCounterColor();
	}

	public void setCounter()
	{
		counter=new GraphicCounter(Camara.W/13+10, Camara.W/1.5f,Camara.W/13,MAX_NUM_OF_BLOCKS);
	}
	public GraphicCounter getCounter()
	{
		return counter;
	}
	private void changeCounterColor()
	{
		counter.nuevo();
		counter.setColor(preview.getRelleno());
	}
	public void drop()
	{
		if(counter.getContador()==0)
			becomeReal();
		else
		{
			counter.resetear();
			clear();
		}
	}
}