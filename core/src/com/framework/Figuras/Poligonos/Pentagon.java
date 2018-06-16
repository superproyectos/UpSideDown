package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

public class Pentagon extends RegularPolygon
{
    /**Crea un pentágono*/
    public Pentagon(float x, float y, float radio, TexturaRelleno relleno)
    {
        super(x,y,radio,relleno);
        setVertex(generarPoligonoRegular(x,y,radio,5));
        setPoligono(crearPoligono(getRelleno(), getVertex()));
        setOrigenPoligono();
    }
    @Override
    public Polygon copy()
    {
        return new Pentagon(this.getX(),this.getY(),this.getRadio(),this.getRelleno());
    }
}
