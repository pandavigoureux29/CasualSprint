package com.casual.sprint;

import com.ladybug.engine.game.Game2D;
import com.ladybug.engine.game.Global;
import com.ladybug.engine.game.LayerManager;
import com.ladybug.engine.game.Scene;
import com.badlogic.gdx.ApplicationListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.casual.sprint.platform.PlatformHoriz;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.badlogic.gdx.Input.Keys;

public class Sprint extends Game2D {
	
	Level m_level;
	Scene scene;
	
	public Sprint(){
		scene = new Scene();
		//add Objects to scene
		scene.addObject(new Player());	
		m_level = new Level();
		scene.addObject(m_level);
		addScene(scene);
//		scene.load();
//		scene.init();
	}
	
	//this sets the collisions in the array. It is called automatically 
	//by the engine at the start
	@Override
	protected void setLayersCollisions(){
		LayerManager.setCollision(LayerManager.GROUND, LayerManager.GROUND, false);
	}
	
	
}
