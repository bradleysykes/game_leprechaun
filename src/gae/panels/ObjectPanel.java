package gae.panels;


import gae.Controller;
import gae.ViewItemField;
import gae.buttons.SaveInputButton;
import gae.viewitems.ViewItem;

import java.awt.Color;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import data.GameElements;

import model.Player;
import model.stats.Stat;
import model.stats.StatCollection;

public class ObjectPanel extends EditPanel {
	
	private JList<String> myList;
	private DefaultListModel<String> myModel;

	public ObjectPanel(Controller controller){
		super(controller);
		myModel = new DefaultListModel<String>();
		myList = new JList<String>(myModel);
		myList.setBackground(Color.black);
		myList.setForeground(Color.red);
		this.add(myList);
		initialize(myList);
	}
	
	

	@Override
	public void postProperties(List<Stat> properties){
		myModel.clear();
		this.postTheProperties(properties);
	}
	
	public void postTheProperties(List<Stat> properties) {
		// send to list
		for(Stat t:properties){
			if(t.getValue()!=null){
				String dataView = t.getName() + ": " + t.getValue().toString();
				myModel.addElement(dataView);
			}
			else{
				postTheProperties(((StatCollection)t).getStats());
			}
		}
;	}



	@Override
	public String getTitle() {
		return OBJECT_PANEL_TITLE;
	}



	@Override
	public void loadData(GameElements elements) {
		
	}

}
