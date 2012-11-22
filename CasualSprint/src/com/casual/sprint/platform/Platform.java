package com.casual.sprint.platform;


import com.ladybug.engine.components.Collider;
import com.ladybug.engine.game.LayerManager;
import com.ladybug.engine.gameobject.GameObject;

import com.badlogic.gdx.math.Vector2;

public class Platform extends GameObject {
	
	Platform(){
	}
	
	public void setSize(float s){}
	
	public Vector2 getEndPosition(){return new Vector2();}
	
	@Override
	public void OnCollisionEnter(Collider objCollider){
		//System.out.println("collisionEnter " + objCollider.getObject());
		if(objCollider.LAYER != LayerManager.PLAYER)
			return;
		//case  it's ground
		if(this.collider.top() <= objCollider.bottom()){
			objCollider.getObject().rigidbody.m_onGround = true;
			objCollider.getObject().replaceToOldY();
			objCollider.getObject().rigidbody.setAcceleration(0);
		}
		
		if(this.collider.right() <= objCollider.left() || this.collider.left() >= objCollider.right()){
			objCollider.getObject().replaceToOldX();
		}
	}
	
}
