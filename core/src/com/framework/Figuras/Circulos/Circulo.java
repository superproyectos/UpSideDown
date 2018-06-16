package com.framework.Figuras.Circulos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.framework.Figuras.Canvas;
import com.framework.Figuras.Figura;
import com.framework.Texturas.TexturaRelleno;

public class Circulo extends Figura
{
    protected static Canvas canvas;
    public static final ShapeRenderer LIENZO=new ShapeRenderer();
    public Circulo(float x,float y,float radio)
    {
        setCentro(x,y);
        setRadio(radio);
    }
    public Circulo(float x, float y, float radio, TexturaRelleno relleno)
    {
        setCentro(x,y);
        setRadio(radio);
        LIENZO.setColor(relleno.getColor());
    }

    public void setColor(Color color)
    {
        LIENZO.setColor(color);
    }
    public void setColor(TexturaRelleno relleno)
    {
        LIENZO.setColor(relleno.getColor());
    }
    public void cambiaAlpha(float f)
    {
        LIENZO.setColor(LIENZO.getColor().r,LIENZO.getColor().g,LIENZO.getColor().b,LIENZO.getColor().a+f);
    }
    @Override
    public void draw()
    {
        LIENZO.begin(ShapeRenderer.ShapeType.Filled);
            LIENZO.circle(getX(),getY(),getRadio());
        LIENZO.end();
    }

    @Override
    public Vector2 getPosicionRelativa()
    {
        return new Vector2(getX(),getY());
    }
}
