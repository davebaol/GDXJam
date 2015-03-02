
package com.gdxjam.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.IntMap;
import com.gdxjam.components.SquadComponent;

public class SquadManagmentTable extends Table {

	private final Skin skin;
	private IntMap<SquadCommandTable> squadTables;

	public SquadManagmentTable (Skin skin) {
		this.skin = skin;
		squadTables = new IntMap<SquadCommandTable>();

	}

	public void addSquad (SquadComponent squad, int index) {
		SquadCommandTable squadTable = new SquadCommandTable(squad, index, skin);
		squadTables.put(index, squadTable);
		
		add(squadTable).pad(2);
	}
	
	public void updateSquadTable(int index){
		squadTables.get(index).update();
	}

	
	public void setSelected (int index, boolean selected) {
		squadTables.get(index).setSelected(selected);
	}

}