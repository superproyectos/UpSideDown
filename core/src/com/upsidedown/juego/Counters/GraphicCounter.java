package com.upsidedown.juego.Counters;

import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.framework.Texturas.TexturaRelleno;
import com.upsidedown.juego.LabelOfGame;

public class GraphicCounter extends Counter
{
	private LabelOfGame leftover;

	private CounterBackground counterBackground;

	public GraphicCounter(float x, float y, float radio, int max)
	{
		super(max);
		leftover =new LabelOfGame(x,y,"0");
		leftover.setBounds(x-radio,y-radio,radio*2,radio*2);
		leftover.setWrap(true);
		leftover.escalar(1.5f);
		counterBackground =new CounterBackground(x,y,radio,new TexturaColor(Colores.AZUL));
	}

	public void setBackground(TexturaRelleno background)
	{
		counterBackground.setBackground(background);
	}

	public void animate()
	{
		counterBackground.animate();
	}

	@Override
	public void newCounter()
	{
		super.newCounter();
		animate();
	}

	@Override
	public void draw()
	{
		leftover.setTexto(Integer.toString(getCounter()>0? getCounter():0));
		counterBackground.draw();
	}

	public void remove()
	{
		leftover.remove();
	}
}