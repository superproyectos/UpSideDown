package com.framework.Figuras.Fisicas;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Mundo
{
    public static World WORLD =new World(new Vector2(0,0),true);
    public static void destroyTheWorld()
    {
        WORLD=new World(new Vector2(0,0),true);
    }
}
