package gae;

import gae.panels.EditPanel;

import java.util.ArrayList;
import java.util.List;

import model.things.Thing;

public class Controller {
	
	List<EditPanel> myPanels = new ArrayList<EditPanel>();
	
	public void addPanel(EditPanel panel){
		myPanels.add(panel);
	}
	
	public void postProperties(List<Thing> props){
		for(EditPanel p:myPanels){
			p.postProperties(props);
		}
	}

}
