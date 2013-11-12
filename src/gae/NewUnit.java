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
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Add New "+myType;
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(Constants.ICON_PATH+Constants.NEW_ICON_RELATIVEPATH);
	}
	
	public String getImagePath(){
		return "";
	}

	@Override
	public Class getObjectClass() {
		// TODO Auto-generated method stub
		return this.getClass();
	}

	@Override
	public String getRelativeImagePath() {
		// TODO Auto-generated method stub
		return Constants.NEW_ICON_RELATIVEPATH;
	}
	
	
}
