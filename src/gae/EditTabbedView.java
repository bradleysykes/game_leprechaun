package gae;

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

import util.Reflection;

public class EditTabbedView extends JTabbedPane {
	
	private Map<String,JList> myTabContents = new HashMap<String,JList>();
	private PackageClassFinder myFinder;
	
	public EditTabbedView(String[] tabs){
		myFinder = new PackageClassFinder();
		myTabContents.put("Units", populateList(new UnitList()));
		myTabContents.put("Tiles", populateList(new TileList()));
		myTabContents.put("Conditions", populateList(new ConditionList()));
		for(String tab : myTabContents.keySet()){
			JScrollPane scroll = new JScrollPane(myTabContents.get(tab));
			this.addTab(tab, scroll);
		}
	}
	
	public BoardList populateList(BoardList list){
		for(Class c:getClasses(list.getPackageName())){
			BoardListItem item = (BoardListItem) Reflection.createInstance(c.getName());
			list.addNewItem(item);
		}
		return list;
	}
	
	public void addTile(BoardListItem tile){
		for(int i = 0; i<this.getTabCount();i++){
			
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
}
