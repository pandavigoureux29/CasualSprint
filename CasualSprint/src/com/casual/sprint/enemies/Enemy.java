package com.casual.sprint.enemies;


import com.ladybug.engine.gameobject.GameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.casual.sprint.Player;
import com.ladybug.engine.components.BoxCollider;

public class Enemy extends GameObject{
	
	public Enemy(float x,float y){
		super(x,y);
		m_textureName = "data/Images/enemy.png";
		addComponent(new BoxCollider(32,32));
	}
	
	@Override
	public void update(){
		//if(Player.instance.collider.collide(collider))
		//	Player.instance.die();
	}
}
