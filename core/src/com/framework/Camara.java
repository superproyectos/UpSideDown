package com.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Camara
{
    public static float W=0,H=0;
    private OrthographicCamera camara;
    private Box2DDebugRenderer camaraBordes;
    private static float PPM=1;
    public Camara()
    {
        camara=new OrthographicCamera();
        camara.setToOrtho(false,Gdx.graphics.getWidth()/PPM,Gdx.graphics.getHeight()/PPM);
        camara.position.set(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0);
        camaraBordes=new Box2DDebugRenderer();
        Camara.W=Gdx.graphics.getWidth();
        Camara.H=Gdx.graphics.getHeight();
    }
    public static void setPPM(float PPM)
    {
        if(PPM!=0)
            Camara.PPM=PPM;
    }
    public static float getPPM()
    {
        return PPM;
    }
    public void modoDebug(World mundo)
    {
        camaraBordes.render(mundo,camara.combined);
    }
}
