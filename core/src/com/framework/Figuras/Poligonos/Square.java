package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

public class Square extends RegularPolygon
{
    /**Crea un cuadrado*/
    public Square(float x, float y, float lado, TexturaRelleno relleno)
    {
        super(x,y,lado*(float)Math.sqrt(2)/2,relleno);
        setVertex(generarPoligonoRegular(x,y,lado*(float)Math.sqrt(2)/2,4));
        setPoligono(crearPoligono(getRelleno(), getVertex()));
        setOrigenPoligono();
    }

    @Override
    public Polygon copy()
    {
        return new Square(this.getX(),this.getY(),2*this.getRadio()/(float)Math.sqrt(2),this.getRelleno());
    }
}
