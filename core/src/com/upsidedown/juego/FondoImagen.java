package com.upsidedown.juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.framework.Camara;
import com.framework.Escenario;

public class FondoImagen extends Actor
{
	private Texture textura;
	public FondoImagen()
	{
		textura=new Texture("slider-bg-grey.png");
		Escenario.addActor(this);
	}
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		super.draw(batch,parentAlpha);
		batch.setColor(batch.getColor().r,batch.getColor().g,batch.getColor().b,0.4f);
		batch.draw(textura, 0, 0, Camara.W, Camara.H);
		batch.setColor(batch.getColor().r,batch.getColor().g,batch.getColor().b,1f);
	}
}