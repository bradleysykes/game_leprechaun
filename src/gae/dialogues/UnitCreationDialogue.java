package gae.dialogues;

import gae.Controller;
import gae.TileEditor;
import gae.ViewItemField;
import gae.panel_lists.BoardList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.things.Stat;
import model.tile.Tile;
import model.unit.Unit;

public class UnitCreationDialogue extends InputDialogue {
	
	private JButton myEnterButton;
	private Map<Stat,ViewItemField> myFieldViews = new HashMap<Stat,ViewItemField>();
	private BoardList myList;
	
	public UnitCreationDialogue(String frameTitle, List<Stat> modelProperties, BoardList list) {
		super(modelProperties);
		myList = list;
		this.setLayout(new FlowLayout());
		myEnterButton = new JButton("Create");
		myEnterButton.addActionListener(new GetDataAction());
		this.add(myEnterButton, BorderLayout.SOUTH);		
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
		myList.postInput(inputData);
		disposeDialogue();
	}

	@Override
	public JPanel createGutsPanel() {
		JPanel mainPanel = new JPanel();
		for(Stat t:myProperties){
			if(t.getValue()!=null){
				ViewItemField<Double> fieldView = new ViewItemField<Double>(t.getName(),t.getField());
				mainPanel.add(fieldView);
				myFieldViews.put(t,fieldView);
			}
			else{
				JButton button = new JButton("Edit"+t.getName());
				button.addActionListener(new ActionListener(){
	
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//UnitCreationDialogue d = new UnitCreationDialogue(t.getName(),t.getThings());
					}
					
				});
				mainPanel.add(button);
			}
	}
		return mainPanel;
//		JPanel panel = new JPanel();
//	for(int x=0;x<12;x++){
//		JPanel fieldPanel = new JPanel(new BorderLayout());
//		JLabel fieldTitle = new JLabel("Field Name");
//		JLabel fieldDescription = new JLabel("Field description");
//		JTextField field = new JTextField();
//		fieldPanel.add(fieldTitle,BorderLayout.PAGE_START);
//		fieldPanel.add(fieldDescription,BorderLayout.CENTER);
//		fieldPanel.add(field,BorderLayout.PAGE_END);
//		panel.add(fieldPanel, BorderLayout.NORTH);
//	}
//	return panel;
	
	}
}

