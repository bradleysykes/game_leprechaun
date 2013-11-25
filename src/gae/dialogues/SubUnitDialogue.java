package gae.dialogues;

import gae.ViewItemField;
import gae.buttons.FileButton;
import gae.buttons.SaveInputButton;
import gae.dialogues.InputDialogue.GetDataAction;
import gae.panel_lists.BoardList;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.stats.Stat;
import model.stats.StatCollection;

public class SubUnitDialogue extends UnitCreationDialogue {
	private Stat myStat;
	public SubUnitDialogue(Stat stat,String frameTitle, List<Stat> modelProperties,
			BoardList list) {
		super(frameTitle, modelProperties, list, true);
		
	}
	
	@Override
	public void postInput() {
		List<Stat> inputData = new ArrayList<Stat>();
		for(Stat stat:myFieldViews.keySet()){
			String data = myFieldViews.get(stat).getData();
			// convert data to appropriate Type
			stat.setValue(Double.parseDouble(data));
			inputData.add(stat);
		}
		disposeDialogue();
	}
	
	@Override
	public JPanel createGutsPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		for(Stat t:myProperties){
			if(t.getValue()!=null){
				ViewItemField fieldView = new ViewItemField(t);
				mainPanel.add(fieldView);
				myFieldViews.put(t,fieldView);
			}
			else{
				StatCollection test = (StatCollection) t;
				SaveInputButton button = new SaveInputButton(test,myList);
				mainPanel.add(button);
			}
		}
		myEnterButton = new JButton("Save");
		// add a different listener
		myEnterButton.addActionListener(new GetDataAction());
		mainPanel.add(myEnterButton);
		return mainPanel;
	}

}
