package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

public class Octagon extends RegularPolygon
{
    /**Crea un octágono*/
    public Octagon(float x, float y, float radio, TexturaRelleno relleno)
    {
        super(x,y,radio,relleno);
        setVertex(generarPoligonoRegular(x,y,radio,8));
        setPoligono(crearPoligono(getRelleno(), getVertex()));
        setOrigenPoligono();
    }
    @Override
    public Polygon copy()
    {
        return new Octagon(this.getX(),this.getY(),this.getRadio(),this.getRelleno());
    }
}
