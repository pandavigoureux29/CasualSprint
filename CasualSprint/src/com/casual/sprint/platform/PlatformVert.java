package com.casual.sprint.platform;

import com.ladybug.engine.game.LayerManager;
import com.ladybug.engine.gameobject.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.casual.sprint.Player;
import com.ladybug.engine.components.BoxCollider;

public class PlatformVert extends Platform{
	boolean m_didCollide = false;
	
	public void start() {
		getObject().addComponent( new Renderer( "data/Images/platformV.png"));
		getObject().addComponent(new BoxCollider(new Rectangle(0,0,32,64)));
		getCollider().LAYER = LayerManager.GROUND;
	}
	
	/*@Override
	public void update(){
		if(collider.collide(Player.instance.collider)){
			Vector2 pos =  Player.instance.getPosition();
			
			Player.instance.replaceToOldX();
			
			if(!m_didCollide){
				Vector2 dir ;
				if(pos.x < getX())
					dir = new Vector2(-1,0);
				else
					dir = new Vector2(1,0);
				Player.instance.setCollider(this,dir);
				//Player.instance.m_speed = 0;
				m_didCollide = true;
			}
		}else if(m_didCollide){
			Player.instance.setCollider(null,null);
			m_didCollide = false;
		}
	}*/
	
	@Override
	public void setSize(float s){
		getObject().setScale(getObject().getScaleX(), s);
	}
	
}

