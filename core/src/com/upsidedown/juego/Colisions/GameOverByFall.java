package com.upsidedown.juego.Colisions;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.framework.Camara;
import com.framework.Figuras.Fisicas.Cuerpos.CuerpoPoligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoEstatico;
import com.framework.Figuras.Poligonos.Rectangle;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Screens.ScreenManager;
import com.upsidedown.juego.Screens.ScreenSelector;

public class GameOverByFall implements GameOver
{
	private CuerpoPoligono sensor;

	public GameOverByFall()
	{
		sensor=new CuerpoPoligono(new Rectangle(0, Camara.H+10,Camara.W,5,new TexturaColor()),new CuerpoEstatico());
		sensor.setSensor(true);
		sensor.setInfoCuerpo("Sensor");
	}

	private void setSensorFirst(Body a,Body b)
	{
		if(b.getUserData().equals("Sensor"))
		{
			Body ax=a;
			a=b;
			b=ax;
		}
	}
	private boolean isOnFall(Body b)
	{
		Float velocity=b.getLinearVelocity().y;
		return velocity>1.1f;
	}
	@Override
	public void evalueContact(Contact contact)
	{
		Body a=contact.getFixtureA().getBody();
		Body b=contact.getFixtureB().getBody();
		if(a.getUserData().equals("Sensor")||b.getUserData().equals("Sensor"))
		{
			setSensorFirst(a,b);
			if(isOnFall(b))
				gameOver();
		}
	}

	@Override
	public void gameOver()
	{
		ScreenManager.getInstance().showScreen(ScreenSelector.GAME_OVER);
	}
}