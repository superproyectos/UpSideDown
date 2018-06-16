package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Vector2;
import com.framework.Figuras.Canvas;
import com.framework.Figuras.Figura;
import com.framework.Texturas.TexturaRelleno;

/**Polígonos que se puedan dibujar*/

public abstract class Polygon extends Figura
{
    /**Lienzo que comparten todas las figuras*/

    protected static Canvas canvas;
    public static final PolygonSpriteBatch LIENZO=new PolygonSpriteBatch();

    /**Conjunto de estructuras para formar un polígono*/

    private Vertex vertex;

    /**Figura a dibujar*/

    private PolygonSprite poligono;

    /**Textura de la figura*/

    private TexturaRelleno relleno;

    /**Retorna la estuctura que conforma al polígono*/

    public Vertex getVertex()
    {
        return vertex;
    }

    /**Retorna la forma del polígono*/

    public PolygonSprite getPoligono()
    {
        return poligono;
    }

    /**Retorna el relleno del polígono*/

    public TexturaRelleno getRelleno()
    {
        return relleno;
    }

    /**Establece el relleno del polígono*/

    public void setRelleno(TexturaRelleno color)
    {
        this.relleno = color;
    }

    public void cambiarRelleno(TexturaRelleno relleno)
    {
        setRelleno(relleno);
        poligono=crearPoligono(relleno, getVertex());
    }
    public boolean esConsecutivo(Polygon p)
    {
        return deltaX(p)<2*getRadio()&&deltaY(p)<2*getRadio();
    }
    public boolean esMismoX(Polygon p)
    {
        return getX()==p.getX();
    }
    public boolean esMismoY(Polygon p)
    {
        return getY()==p.getY();
    }
    public float deltaY(Polygon p)
    {
        return ((int) Math.abs(getY() - p.getY()));
    }
    public float deltaX(Polygon p)
    {
        return ((int) Math.abs(getX() - p.getX()));
    }
    public boolean esMismaPosicion(Polygon p)
    {
        return esMismoX(p)&&esMismoY(p);
    }

    public Vector2 getCentro()
    {
        return new Vector2(getX(),getY());
    }
    /**Establece la forma del polígono*/

    public void setPoligono(PolygonSprite poligono)
    {
        this.poligono = poligono;
    }

    /**Establece la estuctura que conforma al polígono*/

    public void setVertex(Vertex vertex)
    {
        this.vertex = vertex;
    }

    /**Crear polígono*/

    public PolygonSprite crearPoligono(TexturaRelleno relleno,Vertex vertex)
    {
        return new PolygonSprite(new PolygonRegion(new TextureRegion(relleno.getTextura(),0,0,
                relleno.getTextura().getWidth(),
                relleno.getRelleno().getHeight()), vertex.getVertices(),
                new EarClippingTriangulator().computeTriangles(vertex.getVertices()).toArray()));
    }

    /**Establecer origen de rotación del polígono*/
    public void setOrigenPoligono(float x,float y)
    {
        poligono.setOrigin(x,y);
    }
    public void setOrigenPoligono()
    {
        poligono.setOrigin(poligono.getX(),poligono.getY());
    }

    /**Establecer posición del polígono*/

    public void setPosicion(float x,float y)
    {
        poligono.setPosition(x,y);
    }

    /**Establecer rotación del polígono*/

    public void setRotacion(float grados)
    {
        poligono.setRotation(grados);
    }

    @Override
    public Vector2 getPosicionRelativa()
    {
        return new Vector2(poligono.getX(),poligono.getY());
    }

    /**Dibuja en un lienzo estático*/

    @Override
    public void dibujar()
    {
        LIENZO.begin();
        poligono.draw(LIENZO);
        LIENZO.end();
    }

    public void resize(float escala)
    {
        vertex =new Vertex(getVertex().redimensionar(escala), getVertex().getTriangulos());
        poligono=crearPoligono(relleno, vertex);
    }
    public abstract Polygon copy();
}
