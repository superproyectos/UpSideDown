package com.framework.Figuras.Fisicas.Cuerpos;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class PropiedadCuerpo
{
    private FixtureDef propiedades;
    public PropiedadCuerpo()
    {
        propiedades=new FixtureDef();
    }
    public PropiedadCuerpo(Shape shape, float densidad, float friccion, float restitucion)
    {
        propiedades=new FixtureDef();
        propiedades.shape=shape;
        propiedades.density=densidad;
        propiedades.friction=friccion;
        propiedades.restitution=restitucion;
    }
    public void setPropiedades(FixtureDef propiedades)
    {
        this.propiedades = propiedades;
    }
    public FixtureDef getPropiedades()
    {
        return propiedades;
    }
    public void setDensidad(float densidad)
    {
        propiedades.density=densidad;
    }
    public void setFriccion(float friccion)
    {
        propiedades.density=friccion;
    }
    public void setForma(Shape forma)
    {
        propiedades.shape = forma;
    }
    public void setRebote(float restitucion)
    {
        propiedades.restitution=restitucion;
    }
    public void setSensor(boolean sensor)
    {
        propiedades.isSensor = sensor;
    }

}
