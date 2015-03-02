package com.gdxjam.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ai.fma.Formation;
import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.steer.Steerable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gdxjam.ai.formation.SquadFormationPattern;
import com.gdxjam.ai.formation.SquadFormationPattern.PatternType;
import com.gdxjam.ai.states.UnitState;
import com.gdxjam.utils.Location2;

public class SquadComponent extends Component{
	
	public Array<Entity> members;
	public Formation<Vector2> formation;
	public Location2 targetLocation;
	public State<Entity> state = UnitState.FORMATION;

	public boolean selected = false;
	
	public SquadComponent(){
		members = new Array<Entity>();
		targetLocation = new Location2();
	}
	
	public SquadComponent init(Steerable<Vector2> steerable){
		formation = new Formation<Vector2>(steerable, SquadFormationPattern.patterns.get(SquadFormationPattern.defaultPattern));
		return this;
	}
	
	
	public void addMember(Entity entity){
		members.add(entity);
		formation.addMember(Components.SQUAD_MEMBER.get(entity));
	}
	
	public void setState(State<Entity> state){
		this.state = state;
		for(Entity entity : members){
			Components.STATE_MACHINE.get(entity).stateMachine.changeState(state);
		}
	}
	
	public void setFormationPattern(PatternType pattern){
		formation.setPattern(SquadFormationPattern.patterns.get(pattern));
		formation.updateSlotAssignments();
	}
	

	public void setTarget(Vector2 target) {
		targetLocation.getPosition().set(target);
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
