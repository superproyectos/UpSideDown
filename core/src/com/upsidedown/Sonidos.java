package com.upsidedown;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Sonidos
{
	public static final Sound SONIDOS[]=
			{
			/*0*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/lose.mp3", Files.FileType.Internal)),
			/*1*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/pu.wav", Files.FileType.Internal)),
			/*2*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/suelta.mp3", Files.FileType.Internal)),
			/*3*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/shoot.wav", Files.FileType.Internal)),
			/*4*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/toca.mp3", Files.FileType.Internal)),
			/*5*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/explo.wav", Files.FileType.Internal)),
			/*6*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/llego.wav", Files.FileType.Internal)),
			/*7*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/destroy.wav", Files.FileType.Internal)),
			/*8*/Gdx.audio.newSound( Gdx.files.getFileHandle("sounds/pop.mp3", Files.FileType.Internal))
	};
	public static void toque()
	{
		SONIDOS[4].play();
	}
	public static void creando()
	{
		SONIDOS[6].play();
	}
	public static void suelta()
	{
		SONIDOS[2].play();
	}
	public static void pop(){SONIDOS[8].play();}
	public static void congelar(){SONIDOS[1].play();}
	public static void land(){SONIDOS[5].play();}
}