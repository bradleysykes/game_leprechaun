package gae;

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
	public void onSelected(UnitList list) {
		BoardBuffer.push(this);
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return Constants.ICON_PATH+"test_icon_image.png";
	}
	
	

}
