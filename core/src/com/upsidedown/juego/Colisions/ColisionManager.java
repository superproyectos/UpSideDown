package com.upsidedown.juego.Colisions;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.framework.Figuras.Fisicas.Mundo;
import com.upsidedown.Sonidos;

public class ColisionManager implements ContactListener
{
	private GameOver gameOver;
	public ColisionManager()
	{
		Mundo.WORLD.setContactListener(this);
		gameOver=new GameOverByFall();
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
		gameOver.evalueContact(contact);
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
}