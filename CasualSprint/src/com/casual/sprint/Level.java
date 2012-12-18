package com.casual.sprint;

import com.ladybug.engine.components.Script;
import com.ladybug.engine.gameobject.GameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.casual.sprint.enemies.Enemy;
import com.casual.sprint.platform.Platform;
import com.casual.sprint.platform.PlatformHoriz;
import com.casual.sprint.platform.PlatformVert;

public class Level extends GameObject {
		
	public Level(){
		//big horizontal					x    y  w  h
		createChild(new PlatformHoriz(), 100, 0,20,1);
		//2 verticals
		/*createChild(new PlatformVert(), 500, 120,1,4);
		createChild(new PlatformVert(), 640, 30,1,5);	/*
		//
		this.addChild(new PlatformHoriz(), 800, 190,10,1);		

		this.addChild(new PlatformVert(), 1350, -160,1,6);
		this.addChild(new PlatformVert(), 1490, 100,1,4);
		
		this.addChild(new PlatformHoriz(), 2090, 0,20,1);
		
		//enemy
		this.addChild(new Enemy(1000,222));
		this.addChild(new Enemy(1200,222));
		this.addChild(new Enemy(600,30));*/
		
	}
	
	public void createChild(Script script,float x, float y,float w, float h){
		GameObject go = new GameObject();
		go.addComponent(script);
		this.addChild(go, x, y, w, h);
	}
}
