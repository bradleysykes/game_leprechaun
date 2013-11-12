package gae;

import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ToyUnit implements BoardListItem{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Tim the Tank";
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(Constants.ICON_PATH+"test_icon_image.png");
	}

	@Override
	public Class getObjectClass() {
		// TODO Auto-generated method stub
		return this.getClass();
	}

	@Override
	public void onSelected(BoardList list) {
		BoardBuffer.push(this);
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return Constants.ICON_PATH+"test_icon_image.png";
	}
	
	public String getRelativeImagePath(){
		return "test_icon_image.png";
	}

	@Override
	public void notifyListeners(Object object, String property,
			String oldValue, String newValue) {
		// cycle through all listeners and notify
	}

	@Override
	public void addChangeListener(PropertyChangeListener newListener) {
		myListeners.add(newListener);
	}
	
	

}
