package com.framework.Figuras.Grupos;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Drawable;
import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.TexturaRelleno;

/** Conjunto de polígonos*/
public class Grupo implements Drawable
{
    /** Polígonos pertenecientes al conjunto*/

    private Array<Polygon> elementos=new Array<Polygon>();

    private boolean bloqueado=false;

    public boolean isBloqueado()
    {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado)
    {
        this.bloqueado = bloqueado;
    }

    /** Nuevo grupo*/

    public Grupo(Array<Polygon> elementos)
    {
        this.elementos=new Array<Polygon>(elementos);
    }

    public Grupo(Polygon... elementos)
    {
        this.elementos=new Array<Polygon>(elementos);
    }

    /** Devuelve los polígonos pertenecientes al grupo*/

    public Array<Polygon> getElementos()
    {
        return elementos;
    }

    /** Establece los polígonos pertenecientes al grupo*/

    public void setElementos(Array<Polygon> elementos)
    {
	    this.elementos=new Array<Polygon>(elementos);
    }

    /** Añade un polígono al grupo*/

    public void addElemento(Polygon e)
    {
        elementos.add(e);
    }

    public int buscarPosicion(Polygon p)
    {
        return elementos.indexOf(p,false);
    }

    /** Recorre cada polígono para dibujarlo*/
    @Override
    public void draw()
    {
        for (Polygon elemento:elementos)
	        elemento.draw();
    }
    public void pop()
    {
    	elementos.pop();
    }
    public void clear()
    {
    	elementos.clear();
    }
    public int getSize()
    {
        return elementos.size;
    }
    public void changeColor(TexturaRelleno texturaRelleno)
    {
        for(Polygon p:elementos)
            p.cambiarRelleno(texturaRelleno);
    }
    public Vector2 centerOfMass()
    {
        float x=0,y=0;
        for(Polygon a:elementos)
        {
            x+=a.getPosicionRelativa().x;
            y+=a.getPosicionRelativa().y;
        }
        return new Vector2(x/elementos.size,y/elementos.size);
    }
}
