package gae;

import gae.panel_lists.BoardList;
import gae.panel_lists.ConditionList;
import gae.panel_lists.TileList;
import gae.panel_lists.UnitList;

import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


public class EditTabbedView extends JTabbedPane {
	
	private Map<String,JList> myTabContents = new HashMap<String,JList>();
	private PackageClassFinder myFinder;
	
	public EditTabbedView(String[] tabs, Controller controller){
		myFinder = new PackageClassFinder();
		myTabContents.put("Units", populateList(new UnitList(controller)));
		myTabContents.put("Tiles", populateList(new TileList(controller)));
		myTabContents.put("Conditions", populateList(new ConditionList(controller)));
		for(String tab : myTabContents.keySet()){
			JScrollPane scroll = new JScrollPane(myTabContents.get(tab));
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
}
