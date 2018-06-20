package com.upsidedown.juego.Colisions;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.framework.Camara;
import com.upsidedown.FinalShape;

public class Scroll
{
	private boolean permitido,recuperar,sensoractivo;

	public Scroll()
	{
		permitido=false;
		recuperar=false;
		sensoractivo=false;
	}
	public void detectarScroll(Array<FinalShape> finalShapes)
	{
		recuperar=true;
		for(FinalShape a:finalShapes)
		{
			if(a.getStatus().equals("BodyLanded")&&a.getY()< Camara.H/2)
			{
				if(!permitido)
					baja(finalShapes);
				permitido = true;
				recuperar=false;
				sensoractivo=true;
				break;
			}

		}
		if (recuperar&&sensoractivo)
		{
			stop(finalShapes);
			sensoractivo=false;
			permitido=false;
		}
	}
	public void baja(Array<FinalShape> finalShapes)
	{
		for (FinalShape a:finalShapes)
			a.move(new Vector2(0,1));
	}
	public void stop(Array<FinalShape> finalShapes)
	{
		for(FinalShape a:finalShapes)
			a.move(new Vector2(0,0));
	}
}