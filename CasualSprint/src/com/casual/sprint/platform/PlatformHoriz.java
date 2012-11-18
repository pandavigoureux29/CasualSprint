package com.casual.sprint.platform;

import com.ladybug.engine.game.LayerManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.casual.sprint.Player;
import com.ladybug.engine.components.BoxCollider;
import com.ladybug.engine.components.Collider;

public class PlatformHoriz extends Platform {

	public PlatformHoriz(){
		this.m_textureName = "data/Images/platformH.png";
		addComponent(new BoxCollider(new Rectangle(0,0,64,32)));
		collider.LAYER = LayerManager.GROUND;
	}
	
		
	@Override 
	public Vector2 getEndPosition(){
		return new Vector2( getBoundingRectangle().x + getBoundingRectangle().width,
							getY());
	}
	
	@Override
	public void OnCollisionEnter(Collider objCollider){
		//System.out.println("collisionEnter " + objCollider.getObject());
		if(objCollider.LAYER != LayerManager.PLAYER)
			return;
		//case  it's ground
		if(this.collider.top() <= objCollider.bottom())
			objCollider.getObject().rigidbody.m_onGround = true;
		objCollider.getObject().replaceToOldY();
		objCollider.getObject().rigidbody.setAcceleration(0);
	}
	
}
