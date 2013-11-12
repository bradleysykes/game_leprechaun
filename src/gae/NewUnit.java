package gae;

import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewUnit implements BoardListItem {
	
	private String myType;
	
	public NewUnit(String type){
		myType = type;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return "Add New "+myType;
	}
	
	public String getImagePath(){
		return "";
	}


	@Override
	public String getRelativeImagePath() {
		// TODO Auto-generated method stub
		return Constants.NEW_ICON_RELATIVEPATH;
	}

	@Override
	public String getObjectClass() {
		// TODO Auto-generated method stub
		return this.getClass().toString();
	}
	
	
}
