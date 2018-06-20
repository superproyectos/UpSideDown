package com.upsidedown.juego.Colisions;

import com.badlogic.gdx.physics.box2d.Contact;

public interface GameOver
{
	void evalueContact(Contact contact);
	void gameOver();
}