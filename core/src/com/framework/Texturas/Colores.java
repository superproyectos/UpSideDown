package com.framework.Texturas;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Colores
{
    //PALETA DE COLORES https://htmlcolorcodes.com/es/
    public static final Color AZUL=getColor(133, 193, 233   ,1);
    public static final Color ROJO=getColor(241, 148, 138,1);
    public static final Color MORADO=getColor(187, 143, 206  ,1);
    public static final Color TURQUESA=getColor(163, 228, 215    ,1);
    public static final Color VERDE=getColor(171, 235, 198   ,1);
    public static final Color AMARILLO=getColor(249, 231, 159  ,1);
    public static final Color NARANJA=getColor(237, 187, 153  ,1);
    public static final Color GRIS=getColor(174, 182, 191  ,1);
    public static final Color ROSADO=getColor(195, 155, 211 ,1);
    public static final Color AZULGRIS=getColor(171, 178, 185,1);
    public static final Color MORADOINTENSO=getColor(165, 105, 189,1);
    public static final Color GRISCLARO=getColor(215, 219, 221,1);
    public static final Array<Color> RANDOM=new Array<Color>(new Color[]{AZUL,ROJO,MORADO,TURQUESA,VERDE,
            AMARILLO,NARANJA,ROSADO,AZULGRIS,MORADOINTENSO,GRISCLARO});
    public static final Color aleatorio()
    {
    	int aux=new Random(System.currentTimeMillis()).nextInt(RANDOM.size);
        return RANDOM.get(aux);
    }
    public static final Color getColor(float r,float g,float b,float a)
    {
        return new Color(r/255f,g/255f,b/255f,a);
    }
    public static final Color degradado(Color color,float degradado)
    {
        degradado/=100;
        return new Color(color.r-degradado,color.g-degradado,color.b-degradado,color.a);
    }
}
