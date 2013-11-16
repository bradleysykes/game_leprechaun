package gae.viewitems;

import java.util.ArrayList;
import java.util.List;

import gae.Constants;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.things.Stat;
import model.tile.Tile;

public class TileViewItem extends BoardListViewItem {

	
	public TileViewItem(){
		
	}
	
	@Override
	public List<Stat> getModel() {
		return new ArrayList<Stat>();
	}

	@Override
	public void createModel(List<String> inputData) {
		// TODO Auto-generated method stub
		
	}
	
}
