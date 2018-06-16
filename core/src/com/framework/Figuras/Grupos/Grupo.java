package com.framework.Figuras.Grupos;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Drawable;
import com.framework.Figuras.Poligonos.Polygon;

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
}
