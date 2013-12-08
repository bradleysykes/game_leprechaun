package gae.listeners;

import java.util.List;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.stats.StatCollection;

public class SpawnableListSelectionListener implements ListSelectionListener {
	
	private StatCollection myStat;
	
	public SpawnableListSelectionListener(StatCollection stat){
		myStat = stat;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) { 
		JList spawnableList = (JList)e.getSource();
		List<String> selectedValues = spawnableList.getSelectedValuesList();
		myStat.setReferences(selectedValues);
		for(String s:myStat.getReferences()){
			System.out.println(s);
		}
	}

}
