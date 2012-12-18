package com.casual.sprint;

import com.ladybug.engine.game.Global;
import com.ladybug.engine.game.LayerManager;
import com.ladybug.engine.gameobject.GameObject;
import com.ladybug.engine.gameobject.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.casual.sprint.platform.Platform;

import com.ladybug.engine.components.BoxCollider;
import com.ladybug.engine.components.Collider;
import com.ladybug.engine.components.Rigidbody;
import com.ladybug.engine.components.Script;

public class Player extends Script {
	public static Player instance;
	
	Collider m_collPlatf;
	Vector2 m_dirCollPlatf;

	//Speed
	public float m_speed = 1;
	public float m_maxSpeed = 1;
	
	float jumpForce = 3;
	
	boolean m_jumping = false;
	
		
	@Override
	public void start(){
		this.getObject().setPosition(100, 200);
		instance = this;
		//getObject().addComponent( new Renderer( "data/Images/player.png", 32, 32) );
		//COMPONENT
		getObject().addComponent(new Rigidbody());
		getObject().addComponent(new BoxCollider(32,32));
		getObject().collider.LAYER = LayerManager.PLAYER;
		m_speed = 3;
		m_maxSpeed = 3;
	}
	
	public void jump(){
		if(getObject().rigidbody.m_onGround){
			getObject().rigidbody.setAcceleration(-jumpForce);
			getObject().rigidbody.m_onGround = false;
			m_jumping = true;
		}else{
			//try wall jump
			wallJump();
		}
	}
	
	void wallJump(){
		if(m_collPlatf != null){
			m_speed *= -1;
			getRigidbody().setVelocity(m_speed,0);
			getRigidbody().setAcceleration(-jumpForce);
			m_jumping = true;
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
		
		if(getRigidbody().m_onGround){
			if(m_speed < m_maxSpeed){
				m_speed += 0.5;
				if(m_speed > m_maxSpeed)
					m_speed = m_maxSpeed;
			}
			getRigidbody().setVelocity(m_speed,0);
		}		
	}
	
	@Override
	public void postUpdate(){
		//translate camera
		Global.mainCamera.translate(new Vector3(m_object.getDeltaDir().x,m_object.getDeltaDir().y,0));
	}
		
	public void die(){
		Global.currentScene.reset();
	}
	
	//=====================================
	// 			COLLISIONS
	//=====================================
	@Override
	public void onCollisionEnter(Collider objCollider){
		System.out.println("in "+objCollider);
		if(objCollider.LAYER == LayerManager.GROUND)
			m_collPlatf = objCollider;
	}
	
	@Override 
	public void onCollisionExit(Collider objCollider){
		System.out.println("out "+objCollider);
		if(objCollider.equals(m_collPlatf))
			m_collPlatf = null;
	}
}
