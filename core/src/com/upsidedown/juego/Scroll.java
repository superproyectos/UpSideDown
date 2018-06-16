package com.upsidedown.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.utils.Array;
import com.framework.Camara;
import com.framework.Figuras.Drawable;
import com.framework.Figuras.Fisicas.Cuerpos.CuerpoPoligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoEstatico;
import com.framework.Figuras.Fisicas.Mundo;
import com.framework.Figuras.Grupos.GrupoFisico;
import com.framework.Figuras.Poligonos.Rectangle;
import com.framework.Texturas.TexturaColor;

public class Scroll implements ContactListener
{
	private CuerpoPoligono sensor;
	private int entradas=0;
	private float timer=0;
	private boolean permitido,recuperar,sensoractivo;
	public Scroll()
	{
		sensor=new CuerpoPoligono(new Rectangle(0,Camara.H/2+Camara.W/12,Camara.W,5f,new TexturaColor()),new CuerpoEstatico());
		sensor.setSensor(true);
		sensor.getCuerpo().setActive(false);
		Mundo.MUNDO.setContactListener(this);
	}

	@Override
	public void beginContact(Contact contact)
	{

		if((contact.getFixtureA().getBody().equals(sensor.getCuerpo())||contact.getFixtureB().getBody().equals(sensor.getCuerpo())))
		{
			entradas++;
			//System.out.println("Entro");
			permitido=true;
		}
	}

	@Override
	public void endContact(Contact contact)
	{
		if(permitido)
		{
			entradas--;
		}
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold)
	{

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse)
	{

	}
	public void setActivoSensor()
	{
		sensoractivo=true;
	}
	public void detectarScroll(Array<Drawable> dibujables)
	{
		if(entradas<0)
			entradas=0;
		if(sensoractivo)
		{
			if(timer<0.75f)
				timer+= Gdx.graphics.getDeltaTime();
			else
			{
				timer=0;
				sensor.getCuerpo().setActive(true);
				sensoractivo=false;
			}
		}
		else if(sensor.getCuerpo().isActive())
		{
			if (timer<0.5f)
				timer+=Gdx.graphics.getDeltaTime();
			else if(entradas==0)
			{
				entradas=0;
				timer=0;
				sensor.getCuerpo().setActive(false);
				recuperar=true;
			}
		}
		if(recuperar)
		{
		for (Drawable a:dibujables)
			if(a instanceof GrupoFisico)
				((GrupoFisico) a).addVelocidad(new Vector2(0,0));
			recuperar=false;

			//System.out.println("RECUPERAR");
		}
		if(entradas>0)
		{
			for (Drawable a:dibujables)
				if(a instanceof GrupoFisico)
					((GrupoFisico) a).addVelocidad(new Vector2(0,1f));

			//System.out.println("PERMITIDO");
		}

	}
}