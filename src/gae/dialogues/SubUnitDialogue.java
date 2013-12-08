package gae.dialogues;

import gae.ViewItemField;
import gae.buttons.FileButton;
import gae.buttons.SaveInputButton;
import gae.dialogues.InputDialogue.GetDataAction;
import gae.listeners.SpawnableListSelectionListener;
import gae.panel_lists.BoardList;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import model.stats.Stat;
import model.stats.StatCollection;

public class SubUnitDialogue extends UnitCreationDialogue {
	private StatCollection myStat;
	private JPanel myMainPanel;
	
	public SubUnitDialogue(StatCollection stat,String frameTitle, List<Stat> modelProperties,
			BoardList list) {
		super(frameTitle, modelProperties, list, true);
		myStat = stat;
		if(myStat.getReferenceType()!=null){
			List<String> myReferenceTypes = myList.getSpawnableTypes();
			JLabel referenceLabel = new JLabel("Spawnable Types");
			myMainPanel.add(referenceLabel);
			JList referenceChoices = new JList();
			DefaultListModel referenceModel = new DefaultListModel();
			for(String s:myReferenceTypes){
				referenceModel.addElement(s);
			}
			referenceChoices.setModel(referenceModel);
			referenceChoices.addListSelectionListener(new SpawnableListSelectionListener(myStat));
			referenceChoices.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			myMainPanel.add(referenceChoices);
		}

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
		myMainPanel = new JPanel();
		myMainPanel.setLayout(new BoxLayout(myMainPanel,BoxLayout.PAGE_AXIS));
		for(Stat t:myProperties){
			if(t.getValue()!=null){
				ViewItemField fieldView = new ViewItemField(t);
				myMainPanel.add(fieldView);
				myFieldViews.put(t,fieldView);
			}
			else{
				StatCollection test = (StatCollection) t;
				SaveInputButton button = new SaveInputButton(test,myList);
				myMainPanel.add(button);
				if(test.getReferenceType()!=null){
		
				}
			}
		}
		myEnterButton = new JButton("Save");
		// add a different listener
		myEnterButton.addActionListener(new GetDataAction());
		myMainPanel.add(myEnterButton);
		return myMainPanel;
	}

}
