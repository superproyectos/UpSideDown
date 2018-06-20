package com.upsidedown.juego.Creators;

import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Figuras.Poligonos.Square;

public class Validator
{
	private Creation creation;

	public Validator(Previsualizer previsualizer)
	{
		creation=previsualizer.getCreation();
	}
	public boolean isRepeat(Polygon p)
	{
		return creation.buscarPosicion(p)!=-1;
	}

	public boolean isFirst()
	{
		return creation.getSize()==0;
	}

	public boolean isConsecutive(Polygon p)
	{
		Polygon ax = creation.getElementos().get(creation.getSize() - 1);
		return p.esConsecutivo(ax)&& squareCondition(p,ax);
	}

	private boolean squareCondition(Polygon p,Polygon q)
	{
		return (!(p instanceof Square))||(p.esMismoX(q))||(p.esMismoY(q));
	}

	public boolean isLast(Polygon p)
	{
		return creation.buscarPosicion(p)==creation.getSize()-2;
	}
}