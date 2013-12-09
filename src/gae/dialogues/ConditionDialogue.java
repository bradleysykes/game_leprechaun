package gae.dialogues;

import gae.Controller;
import gae.panel_lists.BoardList;
import gae.viewitems.ConditionViewItem;
import gae.viewitems.ViewItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;
import model.Player;
import model.Condition;

@SuppressWarnings("serial")
public class ConditionDialogue extends InputDialogue {

	private JTextField myNameField;
	private JComboBox<String> myConditions;// = new JComboBox<String>();
	private JComboBox<NameObject> myPlayersCombo;// = new JComboBox<String>();
	private List<Player> myPlayers;
	private JComboBox<NameObject> myVariable1Combo;
	private JComboBox<NameObject> myVariable2Combo;// = new JComboBox<String>();
	private List<IConditionParameterSetter> myConditionsParameters;
	private List<StatCollection> myVariable1; //may need to change type
	private List<StatCollection> myVariable2;
	private List<String> conditionNames;
	private BoardList myList;
	private IConditionParameterSetter myParamsetter;

	public ConditionDialogue(Controller controller, BoardList list) {
		super(controller);
		this.myController=controller;
		myList=list;
	}

	@Override
	public JPanel createGutsPanel() {
		myNameField= new JTextField("Victory Condition");
		conditionNames = new ArrayList<String>();
		myVariable1 = new ArrayList<StatCollection>();
		myVariable2 = new ArrayList<StatCollection>();
		myPlayers = new ArrayList<Player>();
		conditionNames.add("Create"); 
		conditionNames.add("Defeat"); 
		conditionNames.add("Waypoint");
		fillConditionParameters();
		JPanel guts = new JPanel();
		guts.setLayout(new BoxLayout(guts,BoxLayout.Y_AXIS));
		myConditions = new JComboBox<String>();
		myPlayersCombo = new JComboBox<NameObject>();
		myVariable1Combo = new JComboBox<NameObject>();
		myVariable2Combo = new JComboBox<NameObject>();
		myConditions.addActionListener(new WatchValueListener());
		myPlayersCombo.addActionListener(new WatchValueListener());
		myVariable1Combo.addActionListener(new Var1ValueListener());
		for (String s:conditionNames) {
			myConditions.addItem(s);
		}
		for (Player p : myController.getPlayers()){
			myPlayersCombo.addItem(new NameObject(p.getID()));
			myPlayers.add(p);
		}		
		
		
		
//		/*JComboBox<String> players = new JComboBox<String>();
//		JComboBox<String> conditions = new JComboBox<String>();
//		JComboBox<String> units = new JComboBox<String>();*/
//		myConditions = new JComboBox<String>();
//		myPlayers = new JComboBox<String>();
//
//		units = new JComboBox<String>();
//		
//		List<Condition> conditions = new ArrayList<Condition>();
//		try {
//			for(Class<Condition> c : reflectOnConditionsPackage()){
//				conditions.add(c.newInstance());
//			}
//		} catch (Exception e) {
//
//		}
//		for (Condition c : conditions){
//			myConditions.addItem(c.getName());
//		}
//		for (Player p : myController.getPlayers()){
//			myPlayers.addItem(p.getName());
//		}
//		myPlayers.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("if only players had units to add...");
//				Player playa = myController.getPlayers().get(myPlayers.getSelectedIndex());
//				units.removeAll();
///*				for(Unit u : playa.getAllUnits()){
//					units.addItem(u.getName());
//				}*/
//			}
//		});
		JLabel conditionsLabel = new JLabel("Select a condition.");
		guts.add(conditionsLabel);
		guts.add(myConditions);
		JLabel playerLabel = new JLabel("Apply to a player");
		guts.add(playerLabel);
		guts.add(myPlayersCombo);
		JLabel unitLabel = new JLabel("Choose a player's units");
		guts.add(unitLabel);
		guts.add(myVariable1Combo);
		guts.add(myVariable2Combo);
		JButton create = new JButton("Create");
		create.addActionListener(new MakeConditionListener());
		guts.add(create);
		guts.add(myNameField);
		return guts;
	}

	private void fillConditionParameters() {
		myConditionsParameters = new ArrayList<IConditionParameterSetter>();
		myConditionsParameters.add(new CreateParameterSetter(myController));
		myConditionsParameters.add(new DefeatParameterSetter(myController));
		myConditionsParameters.add(new WaypointParameterSetter(myController));
	}

	@Override
	public void postInput() {

	}

	@SuppressWarnings("unchecked")
	public List<Class<Condition>> reflectOnConditionsPackage(){
		String packageName = "model.condition";
		List<Class<Condition>> commands = new ArrayList<Class<Condition>>();
		URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));

		// Filter .class files.
		File[] files = new File(root.getFile()).listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");
			}
		});

		// Find classes implementing ICommand.
		for (File file : files) {
			String className = file.getName().replaceAll(".class$", "");
			Class<?> cls;
			try {
				cls = Class.forName(packageName + "." + className);
				if (Condition.class.isAssignableFrom(cls)) {
					commands.add((Class<Condition>) cls);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		return commands;
	}
	public class MakeConditionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int conditionNum = myConditions.getSelectedIndex();	
			myParamsetter = myConditionsParameters.get(conditionNum);
			int playerNum = myPlayersCombo.getSelectedIndex();
			Player player = myPlayers.get(playerNum);
			StatCollection goal1 = null;
			if(myVariable1Combo.isEnabled()){
				goal1 = myVariable1.get(myVariable1Combo.getSelectedIndex());
			}
			
			StatCollection goal2=null;
			if (myVariable2Combo.isEnabled()) {
				goal2 = myVariable2.get(myVariable2Combo.getSelectedIndex());
			}
			Condition condition = myParamsetter.getCondition(player, goal1, goal2);
			player.addVictoryCondition(condition);
			String name = myNameField.getText();
			ConditionViewItem cvi = new ConditionViewItem(name, condition);
			myList.addNewItem(cvi);
			disposeDialogue();
		}
	}

	public class WatchValueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int conditionNum = myConditions.getSelectedIndex();	
			myParamsetter = myConditionsParameters.get(conditionNum);
			int playerNum = myPlayersCombo.getSelectedIndex();
			myVariable1 = myParamsetter.getFirstVariableOptions(playerNum);
			myVariable1Combo.removeAllItems();
			if (myVariable1!=null) {
//				myVariable1Combo.setEnabled(true);
				for (StatCollection sc:myVariable1) {
					myVariable1Combo.addItem(new NameObject(sc.getID()));
				}
			}
			else {
//				myVariable2Combo.setEnabled(false);
			}
		}

	}
	public class Var1ValueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (myVariable1Combo.getItemCount()!=0) {
			int var1Num =myVariable1Combo.getSelectedIndex();
			myVariable2 = myParamsetter.getSecondVariableOptions(var1Num);
			myVariable2Combo.removeAllItems();
			if (myVariable2!=null) {
//				myVariable2Combo.setEnabled(true);
				for (StatCollection sc:myVariable2) {
					myVariable2Combo.addItem(new NameObject(sc.getID()));
				}
			}
			else {
//				myVariable2Combo.setEnabled(false);
			}
			}
		}
		
	}
	private class NameObject {
		private String myName;
		public NameObject(String name) {
			myName = name;
		}
		public String toString() {
			return myName;
		}
	}
}
