package engine.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import engine.GameEngine;
import engine.listeners.UnitListSelectionListener;
import model.unit.Unit;

public class UnitListArea extends JPanel {
	
	private JList myUnitList;
	private DefaultListModel myListModel;
	private JScrollPane myScrollPane;
	private List<Unit> myUnits;
	private final Dimension mySize = new Dimension(150, 70);
	
	
	public UnitListArea(GameEngine gameEngine) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		myListModel = new DefaultListModel();
		
		myUnitList = new JList(myListModel);
		myUnitList.addListSelectionListener(new UnitListSelectionListener(this, gameEngine));
		myUnitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myUnitList.setLayoutOrientation(JList.VERTICAL);
		myUnitList.setVisibleRowCount(-1);
		myUnitList.setPreferredSize(null);
		
		myScrollPane = new JScrollPane(myUnitList);
		myScrollPane.setPreferredSize(mySize);
		
		add(new Label("Av. Units:"));
		add(myScrollPane);
		
		
	}
	
	public void loadUnitList(List<Unit> unitList) {
		myListModel.clear();
		myUnits = unitList;
		for (Unit unit : unitList) {
			myListModel.addElement(unit.getID().split("\\|")[0]);
		}
		if (myUnits.size() == 1){
			myUnitList.setSelectedIndex(0);
		}
	}
	
	public List<Unit> getUnits() {
		return myUnits;
	}
	
}
