package com.upsidedown.juego;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.framework.Figuras.Poligonos.Square;
import com.framework.Figuras.Poligonos.Polygon;
import com.framework.Texturas.Colores;
import com.framework.Texturas.TexturaColor;
import com.upsidedown.juego.Creators.Creation;
import com.upsidedown.juego.Creators.Creator;
import com.upsidedown.GrupoBloques;
import com.upsidedown.Sonidos;
import com.upsidedown.juego.Creators.Preview;
import com.upsidedown.juego.Creators.Putter;

public class Toque extends InputListener
{
	private Polygon polygon;
	private Creator creator;
	public Toque(Polygon p, Creator g)
	{
		polygon =p;
		creator =g;
	}
	@Override
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button)
	{
		return true;
	}
	@Override
	public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
	{
		Creation formacion= creator.getPrevisualizer().getCreation();
		Preview preview = creator.getPrevisualizer().getPreview();
		Contador contador= Board.contador;

		/*int index=formacion.buscarPosicion(polygon);
		if(index==-1&&!formacion.isBloqueado())
		{
			if (formacion.getElementos().size==0)
			{
				formacion.addElemento(polygon);
				preview.vistaPrevia(polygon);
				contador.decrementa();
				Sonidos.toque();
			}
			else
			{
				Polygon ax = formacion.getElementos().get(formacion.getElementos().size - 1);
				if (polygon.esConsecutivo(ax))
					if (!(ax instanceof Square)||(polygon.esMismoY(ax)|| polygon.esMismoX(ax)))
					{
						formacion.addElemento(polygon);
						preview.vistaPrevia(polygon);
						contador.decrementa();
						Sonidos.creando();
					}
			}
		}
		else if(index==formacion.getElementos().size-2)
		{
			formacion.pop();
			preview.pop();
			contador.incrementa();
		}*/
		Putter putter=new Putter(creator.getPrevisualizer());
		putter.put(polygon);
		if(contador.getContador()!=0)
			creator.cambiarRelleno(formacion,new TexturaColor(Colores.GRIS));
		else
			creator.cambiarRelleno(formacion,formacion.getRelleno());
	}
	@Override
	public void touchUp (InputEvent event, float x, float y, int pointer, int button)
	{
		if(Board.contador.getContador()==0)
		{
			Sonidos.suelta();

			creator.getBoard().animarContador();
			creator.getPrevisualizer().getPreview().resultadoFinal();
			GrupoBloques resultado = new GrupoBloques(creator.getPrevisualizer().getPreview());
			//resultado.setDensidad(1);
			//resultado.setFriccion(0.5f);
			//resultado.setRebote(0.1f);
			creator.getBoard().addPuntaje(resultado.getElementos().size);
			creator.addToBoard(resultado);
			Board.contador.nuevo();
			creator.getPrevisualizer().getPreview().limpiar();
			creator.getPrevisualizer().getCreation().limpiar();
			creator.setBackground(new TexturaColor());

			return;
		}
		Board.contador.resetear();
		creator.getPrevisualizer().getPreview().limpiar();
		creator.getPrevisualizer().getCreation().limpiar();
	}
}