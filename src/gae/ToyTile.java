package gae;

import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ToyTile implements BoardListItem {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Rock";
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(Constants.ICON_PATH+"test_tile.jpg");
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return Constants.ICON_PATH+"test_tile.jpg";
	}
	
	public String getRelativeImagePath(){
		return "test_tile.jpg";
	}

	@Override
	public Class getObjectClass() {
		// TODO Auto-generated method stub
		return this.getClass();
	}

}
