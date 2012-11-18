package com.casual.sprint;

import com.ladybug.engine.game.Global;
import com.ladybug.engine.game.LayerManager;
import com.ladybug.engine.gameobject.GameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.casual.sprint.platform.Platform;

import com.ladybug.engine.components.BoxCollider;
import com.ladybug.engine.components.Collider;
import com.ladybug.engine.components.Rigidbody;

public class Player extends GameObject {
	public static Player instance;
	
	Platform m_collPlatf;
	Vector2 m_dirCollPlatf;
	
	float jumpForce = 3;
	
	boolean m_jumping = false;
		
	Player(){
		super(100,200);
		instance = this;
		m_textureName = "data/Images/player.png";
		//COMPONENT
		addComponent(new Rigidbody());
		addComponent(new BoxCollider(32,32));
		collider.LAYER = LayerManager.PLAYER;
		m_speed = 3;
		m_maxSpeed = 3;
		m_oldPos = getPosition();
	}
	
	public void jump(){
		if(rigidbody.m_onGround){
			rigidbody.setAcceleration(-jumpForce);
			rigidbody.m_onGround = false;
			m_jumping = true;
		}else{
			//try wall jump
			if(m_collPlatf != null){
				m_speed *= -1;
				rigidbody.setVelocity(m_speed,0);
				rigidbody.setAcceleration(-jumpForce);
				m_jumping = true;
			}
		}
	}
	
	//=================================
	//			UPDATES
	//=================================
	
	@Override
	public void update(){
		//input
		if(Gdx.input.justTouched()){
			jump();
		}
		
		if(rigidbody.m_onGround){
			if(m_speed < m_maxSpeed){
				m_speed += 0.5;
				if(m_speed > m_maxSpeed)
					m_speed = m_maxSpeed;
			}
			rigidbody.setVelocity(m_speed,0);
		}
		
	}
	
	@Override
	public void postUpdate(){
		//translate camera
		Global.mainCamera.translate(new Vector3(getDeltaDir().x,getDeltaDir().y,0));
	}
	
	
	public void setCollider(Platform p, Vector2 dirColl){	
		m_collPlatf = p;
		m_dirCollPlatf = dirColl;
	}
	
	@Override
	public void die(){
		Global.currentScene.reset();
	}
	
	//=====================================
	// 			COLLISIONS
	//=====================================
	@Override
	public void OnCollisionEnter(Collider objCollider){
	}
}
