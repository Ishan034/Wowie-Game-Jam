package com.wowie.jam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.wowie.jam.menuScreen;

public class MyGame extends Game {
	SpriteBatch batch;
	Texture character;
	public Screen menuScreen, mainScreen;

	@Override
	public void create () {
		menuScreen = (Screen) new menuScreen();
		setScreen(menuScreen);
	}
}
