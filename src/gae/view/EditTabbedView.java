package gae.view;

import gae.PackageClassFinder;
import gae.buttons.CreateCustomButton;
import gae.control.Controller;
import gae.listeners.DeselectListener;
import gae.panel_lists.BoardList;
import gae.panel_lists.ConditionList;
import gae.panel_lists.ResourceList;
import gae.panel_lists.TileList;
import gae.panel_lists.UnitList;
import gae.viewitems.ResourceViewItem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Resource;
import model.Resources;
import model.unit.Unit;
import data.GameElements;


public class EditTabbedView extends JTabbedPane {
	
	private Map<String,BoardList> myTabContents = new HashMap<String,BoardList>();
	private PackageClassFinder myFinder;
	private int mySelectedIndex = this.getSelectedIndex();
	
	public EditTabbedView(BoardList[] tabs, Controller controller){
		for(BoardList tab:tabs){
			myTabContents.put(tab.getListType(), tab);
			tab.setTabbedView(this);
		}
		// create a panel for each list that contains a toolbar and list to
		//display viewitems. 
		for(BoardList list : myTabContents.values()){
			JPanel panel = new JPanel(new BorderLayout());
			JToolBar tool = new JToolBar("Board Objectsj");
			CreateCustomButton button = new CreateCustomButton(list);
			tool.add(button);
			JButton deselect = new JButton("Unselect");
			deselect.addActionListener(new DeselectListener(list));
			tool.add(deselect);
			panel.add(list, BorderLayout.CENTER);
			panel.add(tool, BorderLayout.PAGE_START);
			JScrollPane scroll = new JScrollPane(panel);
			this.addTab(list.getListType(), scroll);
		}
	}
	
	
	public List<Class> getClasses(String packageName){
		try {
			List<Class> classes = myFinder.getClassesForPackage(packageName);
			return classes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList();
	}
	public GameElements giveStateObjects(GameElements currentState) {
		for (String s:myTabContents.keySet()) {
			currentState = myTabContents.get(s).giveStateObjects(currentState);
		}
		return currentState;
		
	}

	public List<Unit> getUnitTypes() {
		List<Unit> u = null;
		for (String s:myTabContents.keySet()) {
			u = myTabContents.get(s).getUnitTypes();
			if (u!=null) {
				break;
			}
		}
		return u;
	}


	public void loadData(GameElements elements) {
		for(BoardList list:myTabContents.values()){
			list.loadData(elements);
		}
	}

	public List<Resource> getUserResources() {
		BoardList resourceContents = myTabContents.get("Resources");
		List<Resource> userResources = new ArrayList<Resource>();
		int resourceCount = resourceContents.getModel().getSize();
		for(int i = 0; i<resourceCount;i++){
			ResourceViewItem item = (ResourceViewItem)resourceContents.getModel().getElementAt(i);
			userResources.add(item.getModelObject());
		}
		return userResources;
	}
}
