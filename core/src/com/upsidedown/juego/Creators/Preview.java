package com.upsidedown.juego.Creators;

import com.framework.Camara;
import com.framework.Figuras.Poligonos.Polygon;

public class Preview extends Creation
{
	public void vistaPrevia(Polygon p)
	{
		p.cambiarRelleno(getRelleno());
		Polygon ax=p.copy();
		ax.resize(1.5f);
		ax.setPosicion(Camara.W/6,Camara.W/2);
		addElemento(ax);
	}
	public void resultadoFinal()
	{
		for(Polygon p:getElementos())
			p.setPosicion(Camara.W/600,Camara.W/200);
	}
}