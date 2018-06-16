package com.framework.Figuras.Poligonos;

import com.framework.Texturas.TexturaRelleno;

/**Polígonos regulares*/

public abstract class RegularPolygon extends Polygon
{

    /**Establecer coordemnadas y relleno*/

    public RegularPolygon(float x, float y, float lado, TexturaRelleno relleno)
    {
        setCentro(x,y);
        setRadio(lado);
        setRelleno(relleno);
    }

    /**Crea vértices inscritos en un círculo*/

    private float[] generaVertices(float x, float y, float radio, int n)
    {
        double angulo=2*Math.PI/n;
        double aux;
        if(n==6)
            aux=angulo;
        else if(n%2==0)
            aux=angulo/2;
        else
            aux=Math.PI/2;
        float vertices[]=new float[n*2];
        for(int i=0;i<2*n;i+=2)
        {
            vertices[i]=x+radio*(float)Math.cos(aux)-(float)Math.cos(aux)* getMargen();
            vertices[i+1]=y+radio*(float)Math.sin(aux)-(float)Math.sin(aux)* getMargen();
            aux+=angulo;
        }
        return vertices;
    }

    /**Une cada tres vértices para formar un polígono*/

    private short[] generaTriangulos(int longitud)
    {
        short triangulos[]=new short[3*(longitud/2-2)];
        for(int i=1,index=0;index<triangulos.length;i++,index+=3)
        {
            triangulos[index]=0;
            triangulos[index+1]=(short)i;
            triangulos[index+2]=(short)(i+1);
        }
        return triangulos;
    }

    /**Genera un polígono regular de 3 a 8 vértices*/

    public Vertex generarPoligonoRegular(float x, float y, float radio, int nLados)
    {
        if(nLados>2&&nLados<9)
        {
            float vertices[]= generaVertices(x,y,radio,nLados);
            short triangulos[]=generaTriangulos(vertices.length);
            return new Vertex(vertices,triangulos);
        }
        return null;
    }
}
