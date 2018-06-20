package com.upsidedown.juego;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.framework.Escenario;
import com.framework.Figuras.Drawable;
import com.framework.Figuras.Poligonos.Polygon;
import com.upsidedown.juego.Actions.Drag.Drag;
import com.upsidedown.juego.Actions.Drag.Dragable;

public abstract class ElementosCreadores extends Actor implements Dragable,Drawable
{
	private Polygon figura;
	private Drag drag;

	public Polygon getFigura()
	{
		return figura;
	}

	public void setFigura(Polygon figura)
	{
		this.figura = figura;
	}
	@Override
	public void drag(float x,float y)
	{
		this.moveBy(x-getWidth()/2,y-getHeight()/2);
		figura.setPosicion(getX()-figura.getX()+getWidth()/2,getY()-figura.getY()+getHeight()/2);
	}
	@Override
	public void draw()
	{
		figura.draw();
	}
	public Drag getDrag()
	{
		return drag;
	}

	public void setDrag(Drag drag)
	{
		this.drag = drag;
	}
	public void establecerDrag()
	{
		drag=new Drag(this);
		this.addListener(drag);
		Escenario.addActor(this);
	}
}