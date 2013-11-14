package gae.dialogues;

import gae.TileEditor;
import gae.ViewItemField;

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

import model.things.Thing;
import model.tile.Tile;
import model.unit.Unit;

public class UnitCreationDialogue extends JFrame {
	private Dimension myPreferredSize = new Dimension(600, 600);
	private static String myModelPackage = "model.";
	private List<String> myRuleNames;
	private JButton myEnterButton;
	private TileEditor myTileEditor;
	private String myPackage;
	private List<Thing> myProperties;
	private Map<Thing,ViewItemField> myFieldViews = new HashMap<Thing,ViewItemField>();
		
	public UnitCreationDialogue(String frameTitle, List<Thing> modelProperties) {
		super(frameTitle);
		//myPackage = myModelPackage+packageExtension;
		myProperties = modelProperties;
		myRuleNames = new ArrayList<String>();
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		//JTextArea titleArea = new JTextArea();
		//titleArea.setEditable(false);
	
		//myTileEditor = new TileEditor();
		//this.add(new PropertiesChooser("Turn Rules", myModelPackage+packageExtension), BorderLayout.CENTER);
		//this.add(myTileEditor, BorderLayout.CENTER);
		myEnterButton = new JButton("Create");
		myEnterButton.addActionListener(new CreateUnitAction());
		this.add(myEnterButton, BorderLayout.SOUTH);
		this.generateFields();
		this.pack();		
	}
	
	private void generateFields(){
//		for(Thing t:myProperties){
//			if(t.getValue()!=null){
//				ViewItemField fieldView = new ViewItemField(t.getName(),t.getField());
//				this.add(fieldView);
//				myFieldViews.put(t,fieldView);
//			}
//			else{
//				JButton button = new JButton("Edit"+t.getName());
//				button.addActionListener(new ActionListener(){
//
//					@Override
//					public void actionPerformed(ActionEvent arg0) {
//						//UnitCreationDialogue d = new UnitCreationDialogue(t.getName(),t.getThings());
//					}
//					
//				});
//				this.add(button);
//			}
//		}
		for(int x=0;x<12;x++){
			JPanel fieldPanel = new JPanel(new BorderLayout());
			JLabel fieldTitle = new JLabel("Field Name");
			JLabel fieldDescription = new JLabel("Field description");
			JTextField field = new JTextField();
			fieldPanel.add(fieldTitle,BorderLayout.PAGE_START);
			fieldPanel.add(fieldDescription,BorderLayout.CENTER);
			fieldPanel.add(field,BorderLayout.PAGE_END);
			this.add(fieldPanel, BorderLayout.NORTH);
		} 
	}
	
	private class CreateUnitAction implements ActionListener {
		private CreateUnitAction() {}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// look through all fields and gather information
			for(Thing thing:myFieldViews.keySet()){
				//get the user-inputted information
				String data = myFieldViews.get(thing).getData();
				// convert data to appropriate Type
			}
		}
		
		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			List<String> args= myTileEditor.getEditorAreaContents();
//			PackageClassFinder finder = new PackageClassFinder(); 
//			Tile t = null;
//			try {
//				Class className = finder.getClassesForPackage("model.tile").get(0);	
//				t = (Tile) Reflection.createInstance(className.getCanonicalName(), Double.parseDouble(args.get(0)), Integer.parseInt(args.get(1)));
//			}
//			catch (ClassNotFoundException CNFE){
//				System.out.println("This sucks");
//			}	
//			System.out.println(t.getPassability()+ t.getImageName());
//		}	
	}
//	public static void main(String[] args) {
//		new UnitCreationDialogue("tile");
//	}
}

