package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

public class Heptagon extends RegularPolygon
{
    /**Crea un heptágono*/
    public Heptagon(float x, float y, float radio, TexturaRelleno relleno)
    {
        super(x,y,radio,relleno);
        setVertex(generarPoligonoRegular(x,y,radio,7));
        setPoligono(crearPoligono(getRelleno(), getVertex()));
        setOrigenPoligono();
    }

    @Override
    public Polygon copy()
    {
        return new Heptagon(this.getX(),this.getY(),this.getRadio(),this.getRelleno());
    }
}
