package com.upsidedown;

import com.framework.Figuras.Grupos.GrupoFisico;
import com.upsidedown.juego.Creators.Preview;

public class GrupoBloques extends GrupoFisico
{
	private Preview preview;
	public GrupoBloques(Preview preview)
	{
		super(preview.getElementos());
	}
}