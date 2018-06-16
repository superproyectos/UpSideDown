package com.framework.Texturas;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class TexturaColor extends TexturaRelleno
{
    private Color color;
    public TexturaColor()
    {
        setRelleno(new Pixmap(1, 1, Pixmap.Format.RGBA8888));
        setColor(Colores.aleatorio());
        setTextura(new Texture(getRelleno()));
    }
    public TexturaColor(Color color)
    {
        setRelleno(new Pixmap(1, 1, Pixmap.Format.RGBA8888));
        setColor(color);
        setTextura(new Texture(getRelleno()));
    }
    public void setColor(Color color)
    {
        this.color=color;
        getRelleno().setColor(color);
        getRelleno().fill();
    }

    @Override
    public Color getColor()
    {
        return color;
    }
}
