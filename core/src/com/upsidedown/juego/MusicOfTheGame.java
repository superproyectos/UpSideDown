package com.upsidedown.juego;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicOfTheGame
{
	private Music music;
	public MusicOfTheGame(String path)
	{
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle(path, Files.FileType.Internal));
		music.play();
		music.setLooping(true);
	}
}