package gae.panel_lists;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gae.Constants;
import gae.Controller;
import gae.EditTabbedView;
import gae.popup_menus.AbilityPopupMenu;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.TilePopupMenu;
import gae.viewitems.AbilityViewItem;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.TileViewItem;
import gae.viewitems.UnitViewItem;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import data.GameElements;
import model.GameMap;
import model.Resource;
import model.Resources;
import model.abilities.CustomAbility;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class AbilityList extends BoardList {
	
	private int myIDCounter;
	
	public AbilityList(Controller controller){
		super(controller);
		myDefaultModel = DEFAULT_ABILITY_STATS;
	}
	
	@Override
	public String getListType() {
		return "Abilities";
	}
	
	@Override
	public String getDefaultName(){
		return "Default Ability Name";
	}
	
	public List<Resource> getUserResources(){
		return myTabbedView.getUserResources();
	}
	
	@Override
	public List<Stat> getDefaultStats(){
		return myDefaultModel;
	}
	@Override
	@Deprecated
	public String getPackageName() {
		return Constants.ABILITY_PACKAGE_NAME;
	}

	@Override
	public GAEPopupMenu getPopupMenu() {
		return new AbilityPopupMenu(myController, this);
	}

	@Override
	protected BoardListViewItem getNewItem(List<Stat> inputData, String name,File f,int counter) {
		myIDCounter = counter;
		return new AbilityViewItem(inputData,name,f,counter);
	}
	
}
