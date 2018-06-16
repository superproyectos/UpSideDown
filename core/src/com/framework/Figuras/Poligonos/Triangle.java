package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

public class Triangle extends RegularPolygon
{
    public Triangle(float x, float y, float radio, TexturaRelleno relleno)
    {
        super(x,y,radio,relleno);
        setVertex(generarPoligonoRegular(x,y,radio,3));
        setPoligono(crearPoligono(getRelleno(), getVertex()));
        setOrigenPoligono();
    }
    @Override
    public Polygon copy()
    {
        return new Triangle(this.getX(),this.getY(),this.getRadio(),this.getRelleno());
    }
}
