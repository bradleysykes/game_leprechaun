package gae;

import gae.buttons.CreateCustomButton;
import gae.panel_lists.BoardList;
import gae.panel_lists.ConditionList;
import gae.panel_lists.TileList;
import gae.panel_lists.UnitList;

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

import data.GameElements;


public class EditTabbedView extends JTabbedPane {
	
	private Map<String,BoardList> myTabContents = new HashMap<String,BoardList>();
	private PackageClassFinder myFinder;
	
	public EditTabbedView(String[] tabs, Controller controller){
		myFinder = new PackageClassFinder();
		myTabContents.put("Units", populateList(new UnitList(controller)));
		myTabContents.put("Tiles", populateList(new TileList(controller)));
		myTabContents.put("Conditions", populateList(new ConditionList(controller)));
		// create a panel for each list that contains a toolbar and list to
		//display viewitems. 
		for(String tab : myTabContents.keySet()){
			BoardList list = myTabContents.get(tab);
			JPanel panel = new JPanel(new BorderLayout());
			JToolBar tool = new JToolBar("Board Objectsj");
			CreateCustomButton button = new CreateCustomButton(list);
			tool.add(button);
			panel.add(list, BorderLayout.CENTER);
			panel.add(tool, BorderLayout.PAGE_START);
			JScrollPane scroll = new JScrollPane(panel);
			this.addTab(tab, scroll);
		}
	}
	
	public BoardList populateList(BoardList list){
//		for(Class c:getClasses(list.getPackageName())){
//			BoardListItem item = (BoardListItem) Reflection.createInstance(c.getName());
//			list.addNewItem(item);
//		}
//		return list;
		return list;
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
}
