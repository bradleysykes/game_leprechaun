package gae;

import gae.panels.EditPanel;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	List<EditPanel> myPanels = new ArrayList<EditPanel>();
	
	public void addPanel(EditPanel panel){
		myPanels.add(panel);
	}

}
