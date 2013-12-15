package gae.dialogues;

import gae.buttons.FileButton;
import gae.buttons.SaveInputButton;
import gae.control.Controller;
import gae.panel_lists.BoardList;
import gae.panel_lists.NullBoardList;
import gae.view.TileEditor;
import gae.view.ViewItemField;
import gae.viewitems.BoardListViewItem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.stats.Stat;
import model.stats.StatCollection;


public class UnitCreationDialogue extends InputDialogue {
	
	protected JButton myEnterButton;
	protected File myImage;
	protected ViewItemField myName;
	protected JPanel myMainPanel;
	
	public UnitCreationDialogue(String name, List<Stat> modelProperties, BoardList list) {
		super(name, modelProperties, list);
	}
	
	protected UnitCreationDialogue(String name, List<Stat> modelProperties, 
			BoardList list, boolean isSubUnit){
		super(name,modelProperties,list);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
	}
	
	public UnitCreationDialogue(String name, List<Stat> model,BoardListViewItem itemSource) {
		// launch edit properties view
		super(name,model,new NullBoardList());
	}
	
	
	@Override
	public void postInput() {
		// look through all fields and gather information
		List<Stat> inputData = new ArrayList<Stat>();
		for(Stat stat:myFieldViews.keySet()){
			String data = myFieldViews.get(stat).getData();
			// convert data to appropriate Type
			stat.setValue(Double.parseDouble(data));
			inputData.add(stat);
		}
		String name = myName.getData();
		myList.postNewInput(inputData, name, myImage);
		disposeDialogue();
	}
	
	public void setImage(File image){
		myImage = image;
	}

	@Override
	public JPanel createGutsPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		myName = new ViewItemField(myCurrentName);
		mainPanel.add(myName);
		for(Stat t:myProperties){
			if(t.getValue()!=null){
				ViewItemField fieldView = new ViewItemField(t);
				mainPanel.add(fieldView);
				myFieldViews.put(t,fieldView);
			}
			else{
				StatCollection test = (StatCollection) t;
				myFieldViews.put(test,new ViewItemField(t));
				SaveInputButton button = new SaveInputButton(test,myList);
				mainPanel.add(button);
			}
		}
		JPanel imageButtonPanel = new JPanel(new BorderLayout());
		FileButton imageButton = new FileButton("Upload image", this);
		imageButtonPanel.add(imageButton, BorderLayout.PAGE_START);
		JLabel imageHint = new JLabel("For best quality, please limit size to X by X.");
		imageButtonPanel.add(imageHint, BorderLayout.PAGE_END);
		mainPanel.add(imageButtonPanel);
		myEnterButton = new JButton("Create");
		myEnterButton.addActionListener(new GetDataAction());
		mainPanel.add(myEnterButton);
		myMainPanel = mainPanel;
		return mainPanel;
	}
}

