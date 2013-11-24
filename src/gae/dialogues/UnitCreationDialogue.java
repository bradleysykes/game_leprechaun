package gae.dialogues;

import gae.Controller;
import gae.TileEditor;
import gae.ViewItemField;
import gae.buttons.FileButton;
import gae.buttons.SaveInputButton;
import gae.panel_lists.BoardList;
import gae.panel_lists.NullBoardList;
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
import javax.swing.JPanel;
import model.stats.Stat;
import model.stats.StatCollection;


public class UnitCreationDialogue extends InputDialogue {
	
	protected JButton myEnterButton;
	protected File myImage;
	protected ViewItemField myName;
	
	public UnitCreationDialogue(String frameTitle, List<Stat> modelProperties, BoardList list) {
		super(modelProperties, list);		
	}
	
	protected UnitCreationDialogue(String frameTitle, List<Stat> modelProperties, 
			BoardList list, boolean isSubUnit){
		super(modelProperties,list);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
		myEnterButton = new JButton("Create Subunit");
		myEnterButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(Stat t: myFieldViews.keySet()){
					ViewItemField field = myFieldViews.get(t);
					Double data = Double.valueOf(field.getData());
					t.setValue(data);
					disposeDialogue();
				}
			}
			
		});
		this.add(myEnterButton);	
	}
	
	public UnitCreationDialogue(String name, List<Stat> model,BoardListViewItem itemSource) {
		// launch edit properties view
		super(model,new NullBoardList());
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
		myName = new ViewItemField("Custom name");
		mainPanel.add(myName);
		FileButton imageButton = new FileButton("Upload image", this);
		mainPanel.add(imageButton);
		myEnterButton = new JButton("Create");
		myEnterButton.addActionListener(new GetDataAction());
		mainPanel.add(myEnterButton);
		return mainPanel;
	}
}

