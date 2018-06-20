package com.framework.Figuras.Grupos;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.framework.Camara;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoEstatico;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoKinematico;
import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Figuras.PropiedadesFisicas;
import com.framework.Figuras.Fisicas.Cuerpos.CuerpoPoligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoDinamico;

/** Grupo de polígonos que actúan como un bloque físico*/

public class GrupoFisico extends Grupo implements PropiedadesFisicas
{
    /** Cuerpo perteneciente al grupo*/

    private CuerpoPoligono cuerpoPoligono;

    /** Crea grupo físico*/

    public GrupoFisico(Array<Polygon> elementos)
    {
        super(elementos);
        crearCuerpo();
    }
    public GrupoFisico(Array<Polygon> elementos, float densidad, float friccion, float restitucion)
    {
        super(elementos);
        crearCuerpo(densidad,friccion,restitucion);
    }
    public GrupoFisico(Polygon... elementos)
    {
        super(elementos);
        crearCuerpo();
    }
    public GrupoFisico(Grupo grupo)
    {
        super(grupo.getElementos());
        crearCuerpo();
    }
    /** Crea el cuerpo para el grupo*/

    private void crearCuerpo()
    {
        cuerpoPoligono =new CuerpoPoligono(getElementos(),new CuerpoDinamico());
    }

    private void crearCuerpo(float densidad,float friccion,float restitucion)
    {
        cuerpoPoligono =new CuerpoPoligono(getElementos(),new CuerpoDinamico(),densidad,friccion,restitucion);
    }

    @Override
    public void cambioPosicion()
    {
        for (Polygon p:getElementos())
        {
            p.setPosicion(cuerpoPoligono.getX()* Camara.getPPM(), cuerpoPoligono.getY()*Camara.getPPM());
            p.setRotacion(cuerpoPoligono.getRotacion());
        }
    }
    @Override
    public void setDensidad(float densidad)
    {
        cuerpoPoligono.setDensidad(densidad);
    }
    @Override
    public void setFriccion(float friccion)
    {
        cuerpoPoligono.setFriccion(friccion);
    }
    @Override
    public void setRebote(float restitucion)
    {
        cuerpoPoligono.setRebote(restitucion);
    }
    @Override
    public void setSensor(boolean sensor)
    {
        cuerpoPoligono.setSensor(sensor);
    }
    @Override
    public void setPropiedades(float densidad,float friccion,float restitucion)
    {
        setDensidad(densidad);
        setRebote(restitucion);
        setFriccion(friccion);
    }
    @Override
    public void setTipoCuerpo(TipoCuerpo tipoCuerpo)
    {
        cuerpoPoligono.cambiarTipo(tipoCuerpo);
    }
    @Override
    public void addElemento(Polygon e)
    {
        super.addElemento(e);
        crearCuerpo();
    }

    @Override
    public void draw()
    {
        cambioPosicion();
        super.draw();
    }
    public void addVelocidad(Vector2 velocidad)
    {
        cuerpoPoligono.getCuerpo().setLinearVelocity(velocidad);
    }
    public void stop()
    {
        setTipoCuerpo(new CuerpoEstatico());
        setTipoCuerpo(new CuerpoKinematico());
    }
    public void setData(String s)
    {
        cuerpoPoligono.setInfoCuerpo(s);
    }
    public String getData()
    {
        return cuerpoPoligono.getCuerpo().getUserData().toString();
    }

}
