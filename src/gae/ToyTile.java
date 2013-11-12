package gae;

import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ToyTile implements BoardListItem {


	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return Constants.ICON_PATH+"test_tile.jpg";
	}
	
	public String getRelativeImagePath(){
		return "test_tile.jpg";
	}

	@Override
	public String getObjectClass() {
		// TODO Auto-generated method stub
		return this.getClass().toString();
	}

}
