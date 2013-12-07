package engine.gui;

import java.awt.Dimension;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import engine.GameEngine;
import engine.listeners.SpawnerListSelectionListener;
import engine.listeners.SpawnerListener;
import model.unit.Unit;

public class SpawnerPanel extends JPanel {
	
	private JScrollPane myScrollPane;
	private JList<String> myList;
	private DefaultListModel<String> myListModel;
	private List<Unit> myUnits;
	private Map<Unit, String> myUnitImageMap;
	private Dimension mySize = new Dimension(150, 120);
	
	public SpawnerPanel(List<Unit> unitList, SpawnerViewer spawnerViewer, GameEngine gameEngine) {
		myUnitImageMap = gameEngine.getGameLoader().getUnitImageMap();
		myUnits = unitList;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		myListModel = new DefaultListModel<String>();
		myList = new JList<String>(myListModel);
		myList.addListSelectionListener(new SpawnerListSelectionListener(myList, spawnerViewer.getIconPanel()));
		setPreferredSize(mySize);
		myScrollPane = new JScrollPane(myList);
		myScrollPane.setPreferredSize(new Dimension(130, 70));
		add(myScrollPane);
		add(new SpawnerButton(new SpawnerListener(this, spawnerViewer)));
	}
	
	public JList<String> getList() { 
		return myList;
	}
	
	public List<Unit> getUnits() {
		return myUnits;
	}
	
	public void setListContent(List<Unit> unitList) {
		myUnits = unitList;
		myList.clearSelection();
		myListModel.clear();
		for (Unit unit : unitList) {
			myListModel.addElement(unit.getID());
		}
		
	}
	
	public String unitImagePath(Unit unit) { 
		return myUnitImageMap.get(unit);
	}
	
}
