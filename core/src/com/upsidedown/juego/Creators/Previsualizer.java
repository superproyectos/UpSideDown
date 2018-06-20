package com.upsidedown.juego.Creators;

import com.framework.Camara;
import com.framework.Escenario;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.FinalShape;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Game.Board;
import com.upsidedown.juego.Counters.GraphicCounter;
import com.upsidedown.juego.Data.Data;
import com.upsidedown.juego.Data.Score;

public class Previsualizer
{
	private final int MAX_NUM_OF_BLOCKS=7;

	private Creation creation=new Creation();

	private Preview preview=new Preview();

	private static GraphicCounter counter;

	private static Board board;

	private Score score=Data.score;

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
		score.addScore(result.getSize());
		changeCounterColor();
	}

	public void setCounter()
	{
		if(counter==null)
			counter=new GraphicCounter(Camara.W/13+10, Camara.W/1.5f,Camara.W/13,MAX_NUM_OF_BLOCKS);
	}
	public GraphicCounter getCounter()
	{
		return counter;
	}
	private void changeCounterColor()
	{
		counter.newCounter();
		counter.setBackground(preview.getRelleno());
	}
	public void drop()
	{
		if(counter.getCounter()==0)
			becomeReal();
		else
		{
			counter.reset();
			clear();
		}
	}
	public static void resetCounter()
	{
		counter=null;
	}
}