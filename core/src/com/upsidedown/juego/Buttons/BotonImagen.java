package com.upsidedown.juego.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.framework.Camara;
import com.framework.Figuras.Coord;
import com.upsidedown.juego.Actions.Action;
import com.upsidedown.juego.Animations.ActorBounce;

public abstract class BotonImagen extends Boton
{
	private ImageButton imageButton;
	public BotonImagen(Coord coord, String path, Action action)
	{
		setBounds(coord.getX(),coord.getY(), Camara.W/6,Camara.W/6);
		imageButton=new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(path))));
		imageButton.setBounds(coord.getX(),coord.getY(), Camara.W/6,Camara.W/6);
		setAnimation(new ActorBounce(imageButton.getImage()));
		addEventListener(action);
		addToStage();
	}

	@Override
	public void draw(Batch batch,float d)
	{
		imageButton.draw(batch,d);
		animate();
	}
}