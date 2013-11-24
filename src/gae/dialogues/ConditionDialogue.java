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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.stats.Stat;
import model.unit.Unit;
import model.Player;
import model.Condition;

@SuppressWarnings("serial")
public class ConditionDialogue extends InputDialogue {

	private JTextField myNameField;
	private JComboBox<String> myConditions;// = new JComboBox<String>();
	private JComboBox<String> myPlayersCombo;// = new JComboBox<String>();
	private List<Player> myPlayers;
	private JComboBox<String> myVariable1Combo;
	private JComboBox<String> myVariable2Combo;// = new JComboBox<String>();
	private List<IConditionParameterSetter> myConditionsParameters;
	private List<Player> myVariable1; //may need to change type
	private List<Unit> myVariable2;
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
		myNameField= new JTextField("Name me!");
		conditionNames = new ArrayList<String>();
		myVariable1 = new ArrayList<Player>();
		myVariable2 = new ArrayList<Unit>();
		myPlayers = new ArrayList<Player>();
		conditionNames.add("Create"); 
		conditionNames.add("Defeat"); 
		conditionNames.add("Waypoint");
		fillConditionParameters();
		JPanel guts = new JPanel();
		myConditions = new JComboBox<String>();
		myPlayersCombo = new JComboBox<String>();
		myVariable1Combo = new JComboBox<String>();
		myVariable2Combo = new JComboBox<String>();
		myConditions.addActionListener(new WatchValueListener());
		myPlayersCombo.addActionListener(new WatchValueListener());
		myVariable1Combo.addActionListener(new Var1ValueListener());
		for (String s:conditionNames) {
			myConditions.addItem(s);
		}
		for (Player p : myController.getPlayers()){
			myPlayersCombo.addItem(p.getName());
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
		guts.add(myConditions);
		guts.add(myPlayersCombo);
		guts.add(myVariable1Combo);
		guts.add(myVariable2Combo);
		JButton create = new JButton("Create");
		create.addActionListener(new MakeConditionListener());
		guts.add(create);
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
				// TODO Auto-generated catch block
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
			if(myVariable1Combo.isEnabled()){
			Player target = myVariable1.get(myVariable1Combo.getSelectedIndex());
			}
			Unit goal=null;
			if (myVariable2Combo.isEnabled()) {
				goal = myVariable2.get(myVariable2Combo.getSelectedIndex());
				Condition condition = myParamsetter.getCondition(player, goal);
				String name = myNameField.getText();
				ConditionViewItem cvi = new ConditionViewItem(name, condition);
				myList.addNewItem(cvi);
				disposeDialogue();
			}
		}
	}

	public class WatchValueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int conditionNum = myConditions.getSelectedIndex();	
			myParamsetter = myConditionsParameters.get(conditionNum);
			int playerNum = myPlayersCombo.getSelectedIndex();
			myVariable1 = myParamsetter.getFirstVariableOptions(playerNum);
			if (myVariable1!=null) {
//				myVariable1Combo.setEnabled(true);
				myVariable1Combo.removeAllItems();
				for (Player p:myVariable1) {
					myVariable1Combo.addItem(p.getName());
				}
			}
			else {
				myVariable2Combo.setEnabled(false);
			}
		}

	}
	public class Var1ValueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) { 
			myVariable2Combo.removeAll();
			myVariable2 = myParamsetter.getSecondVariableOptions(myVariable1Combo.getSelectedIndex());
			if (myVariable2!=null) {
				myVariable2Combo.setEnabled(true);
				for (Unit u:myVariable2) {
					myVariable2Combo.addItem(u.getName());
				}
			}
			else {
				myVariable2Combo.setEnabled(false);
			}
		}
		
	}
}
