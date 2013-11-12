package gae;

import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ToyUnit implements BoardListItem{

	@Override
	public String getObjectClass() {
		// TODO Auto-generated method stub
		return this.getClass().toString();
	}


	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return Constants.ICON_PATH+"test_icon_image.png";
	}
	
	public String getRelativeImagePath(){
		return "test_icon_image.png";
	}

	
	

}
