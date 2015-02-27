package com.gdxjam.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

public class TargetFinderComponent extends Component{
	
	public Array<Entity> resources = new Array<Entity>();
	public Array<Entity> enemies = new Array<Entity>();
	
	public void addResource(Entity entity){
		if(!resources.contains(entity, true)){
			resources.add(entity);
		}
	}
	
	public void addEnemy(Entity entity){
		enemies.add(entity);
	}

}