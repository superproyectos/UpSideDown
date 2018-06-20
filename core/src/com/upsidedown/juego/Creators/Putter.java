package com.upsidedown.juego.Creators;

import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.GraphicCounter;

public class Putter
{
	private Preview preview;

	private Creation creation;

	private Validator validator;

	private GraphicCounter counter;

	public Putter(Previsualizer previsualizer)
	{
		this.preview=previsualizer.getPreview();
		this.creation=previsualizer.getCreation();
		counter=previsualizer.getCounter();
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
			playSound();
			creation.addElemento(p);
			preview.vistaPrevia(p);
			counter.decrementa();
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
			counter.incrementa();
			Sonidos.pop();
		}
	}

	public void selectColor()
	{
		if(counter.getContador()!=0)
			creation.cambiarRelleno(new TexturaColor(Colores.GRIS));
		else
			creation.cambiarRelleno(creation.getRelleno());
	}
}