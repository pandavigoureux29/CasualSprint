package com.casual.sprint;

import com.ladybug.engine.game.Game2D;
import com.ladybug.engine.game.Global;
import com.ladybug.engine.game.LayerManager;
import com.ladybug.engine.game.Scene;
import com.ladybug.engine.gameobject.GameObject;


public class Sprint extends Game2D {
	
	Level m_level;
	Scene scene;
	
	public Sprint(){
		scene = new Scene();
		//add Objects to scene
		GameObject go = new GameObject(0,0,"data/Images/player.png", 16, 16, "Player");
		go.addComponent(new Player());
		scene.addObject(go);	
		//m_level = new Level();
		//scene.addObject(m_level);
		addScene(scene);
	}
	
	//this sets the collisions in the array. It is called automatically 
	//by the engine at the start
	@Override
	protected void setLayersCollisions(){
		LayerManager.setCollision(LayerManager.GROUND, LayerManager.GROUND, false);
	}
	
	
}
