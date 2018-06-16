package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

public class Hexagono extends RegularPolygon
{
    /**Crea un hexágono*/
    public Hexagono(float x, float y, float radio, TexturaRelleno relleno)
    {
        super(x,y,radio,relleno);
        setVertex(generarPoligonoRegular(x,y,radio,6));
        setPoligono(crearPoligono(getRelleno(), getVertex()));
        setOrigenPoligono();
    }
    @Override
    public Polygon copy()
    {
        return new Hexagono(this.getX(),this.getY(),this.getRadio(),this.getRelleno());
    }
}
