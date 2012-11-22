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
	
}
