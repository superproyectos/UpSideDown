package com.upsidedown;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.framework.Camara;
import com.framework.Figuras.Coord;
import com.framework.Figuras.Drawable;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoEstatico;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoKinematico;
import com.framework.Figuras.Grupos.Grupo;
import com.framework.Figuras.Grupos.GrupoFisico;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Creators.Preview;

public class FinalShape implements Drawable
{
	private GrupoFisico grupoFisico;

	public FinalShape(Grupo grupo)
	{
		grupoFisico=new GrupoFisico(grupo);
		grupoFisico.setDensidad(1);
		grupoFisico.setFriccion(0.5f);
		grupoFisico.setRebote(0.1f);
		grupoFisico.setData("BodyOnFall");
	}
	public FinalShape(GrupoFisico grupo)
	{
		grupoFisico=grupo;
	}
	public int getSize()
	{
		return grupoFisico.getSize();
	}
	public void freez()
	{
		if(!getStatus().equals("Suelo"))
			grupoFisico.setData("BodyLanded");
		grupoFisico.changeColor(new TexturaColor(Color.CYAN));
		stop();
	}
	@Override
	public void draw()
	{
		grupoFisico.draw();
	}
	public void move(Vector2 velocidad)
	{
		grupoFisico.addVelocidad(velocidad);
	}
	public void stop()
	{
		grupoFisico.stop();
	}
	public String getStatus()
	{
		return grupoFisico.getData();
	}
	public float getY()
	{
		return grupoFisico.centerOfMass().y;
	}
}