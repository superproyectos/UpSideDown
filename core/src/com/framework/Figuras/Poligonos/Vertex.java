package com.framework.Figuras.Poligonos;

public final class Vertex
{
    private float vertices[];
    private short triangulos[];
    public Vertex(float vertices[], short triangulos[])
    {
        this.vertices=vertices;
        this.triangulos=triangulos;
    }
    public float[] getVertices()
    {
        return vertices;
    }
    public short[] getTriangulos()
    {
        return triangulos;
    }

    public void setVertices(float[] vertices)
    {
        this.vertices = vertices;
    }
    public void setTriangulos(short[] triangulos)
    {
        this.triangulos = triangulos;
    }


    public void mostrar(float[] vertices)
    {
        for(int i=0;i<vertices.length;i++)
        {
            System.out.print(vertices[i]+" ");
        }
        System.out.println(" ");
    }
    public float [] redimensionar(float escala)
    {
        float aux[]=new float[vertices.length];
        for(int i=0;i<vertices.length;i++)
            aux[i]=vertices[i]/escala;
        return aux;
    }
}
