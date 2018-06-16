package com.upsidedown.juego.Creators;

import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Board;

public class Putter
{
	private Preview preview;

	private Creation creation;

	private Validator validator;

	public Putter(Previsualizer previsualizer)
	{
		this.preview=previsualizer.getPreview();
		this.creation=previsualizer.getCreation();
		validator=new Validator(previsualizer);
	}

	public void put(Polygon p)
	{
		if(!validator.isRepeat(p))
			addToElements(p);
		else
			erase(p);
	}

	private void addToElements(Polygon p)
	{
		if(validator.isFirst()||validator.isConsecutive(p))
		{
			creation.addElemento(p);
			preview.vistaPrevia(p);
			Board.contador.decrementa();
			playSound();
		}
	}

	private void playSound()
	{
		if(validator.isFirst())
			Sonidos.toque();
		else
			Sonidos.creando();
	}

	private void erase(Polygon p)
	{
		if (validator.isLast(p))
		{
			preview.pop();
			creation.pop();
			Board.contador.incrementa();
			Sonidos.pop();
		}
	}

	public void selectColor()
	{
		if(Board.contador.getContador()!=0)
			creation.cambiarRelleno(new TexturaColor(Colores.GRIS));
		else
			creation.cambiarRelleno(creation.getRelleno());
	}
}