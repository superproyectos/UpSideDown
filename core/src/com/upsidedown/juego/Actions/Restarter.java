package com.upsidedown.juego.Actions;

import com.upsidedown.Juego;

public class Restarter extends Action
{
	@Override
	public void execute()
	{
		Juego.restart=true;
	}
}