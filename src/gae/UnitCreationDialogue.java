package gae;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

import model.things.Thing;
import model.tile.Tile;
import model.unit.Unit;
import util.Reflection;

public class UnitCreationDialogue extends JFrame {
	private Dimension myPreferredSize = new Dimension(600, 600);
	private static String myModelPackage = "model.";
	private List<String> myRuleNames;
	private JButton myEnterButton;
	private TileEditor myTileEditor;
	private String myPackage;
		
	public UnitCreationDialogue(String frameTitle, List<Thing> modelProperties) {
		super(frameTitle);
		//myPackage = myModelPackage+packageExtension;
		this.setLayout(new BorderLayout());
		myRuleNames = new ArrayList<String>();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		JTextArea titleArea = new JTextArea();
		titleArea.setEditable(false);
		this.add(titleArea, BorderLayout.NORTH);
		//myTileEditor = new TileEditor();
		//this.add(new PropertiesChooser("Turn Rules", myModelPackage+packageExtension), BorderLayout.CENTER);
		//this.add(myTileEditor, BorderLayout.CENTER);
		myEnterButton = new JButton("Create");
		myEnterButton.addActionListener(new CreateUnitAction());
		this.add(myEnterButton, BorderLayout.SOUTH);
		this.pack();		
	}
	
	private class CreateUnitAction implements ActionListener {
		private CreateUnitAction() {}

		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> args= myTileEditor.getEditorAreaContents();
			PackageClassFinder finder = new PackageClassFinder(); 
			Tile t = null;
			try {
				Class className = finder.getClassesForPackage("model.tile").get(0);	
				t = (Tile) Reflection.createInstance(className.getCanonicalName(), Double.parseDouble(args.get(0)), Integer.parseInt(args.get(1)));
			}
			catch (ClassNotFoundException CNFE){
				System.out.println("This sucks");
			}	
			System.out.println(t.getPassability()+ t.getImageName());
		}	
	}
//	public static void main(String[] args) {
//		new UnitCreationDialogue("tile");
//	}
}

