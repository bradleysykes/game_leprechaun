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

import engine.listeners.UnitListSelectionListener;
import model.unit.Unit;

public class UnitListArea extends JPanel {
	
	private JList myUnitList;
	private DefaultListModel<String> myListModel;
	private JScrollPane myScrollPane;
	private List<Unit> myUnits;
	private final Dimension mySize = new Dimension(150, 70);
	
	
	public UnitListArea() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		myListModel = new DefaultListModel<String>();
		
		myUnitList = new JList(myListModel);
		myUnitList.addListSelectionListener(new UnitListSelectionListener(this));
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
			myListModel.addElement(unit.getID());
		}
	}
	
	public List<Unit> getUnits() {
		return myUnits;
	}
	
}
