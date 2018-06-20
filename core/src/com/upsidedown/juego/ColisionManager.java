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
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoKinematico;
import com.framework.Figuras.Fisicas.Mundo;
import com.framework.Figuras.Grupos.GrupoFisico;
import com.framework.Figuras.Poligonos.Rectangle;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.FinalShape;
import com.upsidedown.Sonidos;

public class ColisionManager implements ContactListener
{
	private boolean permitido,recuperar,sensoractivo;
	public ColisionManager()
	{
		Mundo.MUNDO.setContactListener(this);
	permitido=false;
	recuperar=false;
		sensoractivo=false;
	}

	@Override
	public void beginContact(Contact contact)
	{

		String a,b;
		a=(String)contact.getFixtureA().getBody().getUserData();
		b=(String)contact.getFixtureB().getBody().getUserData();
		if(!a.equals("Sensor")&&!b.equals("Sensor")&&(a.equals("BodyOnFall")||b.equals("BodyOnFall")))
		{
			if (!a.equals("Suelo"))
				contact.getFixtureA().getBody().setUserData("BodyLanded");
			if(!b.equals("Suelo"))
				contact.getFixtureB().getBody().setUserData("BodyLanded");
			Sonidos.land();
		}

	}
	@Override
	public void endContact(Contact contact)
	{

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold)
	{

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse)
	{

	}
	public void detectarScroll(Array<FinalShape> finalShapes)
	{
		recuperar=true;
		for(FinalShape a:finalShapes)
		{

			if(a.getStatus().equals("BodyLanded")&&a.getY()<Camara.H/2)
			{
				if(!permitido)
					baja(finalShapes);
				permitido = true;
				recuperar=false;
				sensoractivo=true;
				break;
			}

		}
		if (recuperar&&sensoractivo)
		{
			stop(finalShapes);
			sensoractivo=false;
			permitido=false;
		}
	}
	public void baja(Array<FinalShape> finalShapes)
	{
		for (FinalShape a:finalShapes)
			a.move(new Vector2(0,1));
	}
	public void stop(Array<FinalShape> finalShapes)
	{
		for(FinalShape a:finalShapes)
			a.move(new Vector2(0,0));
	}
}