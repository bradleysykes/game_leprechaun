package gae.dialogues;

import gae.Controller;
import gae.panel_lists.BoardList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import model.stats.Stat;
import model.unit.Unit;
import model.Player;
import model.Condition;

@SuppressWarnings("serial")
public class ConditionDialogue extends InputDialogue {

	private JComboBox<String> myConditions;// = new JComboBox<String>();
	private JComboBox<String> myPlayers;// = new JComboBox<String>();
	private JComboBox<String> myVariable1;
	private JComboBox<String> myVariable2;// = new JComboBox<String>();
	private Map<String, IConditionParameterSetter> myConditionsParameters;

	public ConditionDialogue(Controller controller) {
		super(controller);
		this.myController=controller;
	}

	@Override
	public JPanel createGutsPanel() {
		fillConditionParameters();
		JPanel guts = new JPanel();
		myConditions = new JComboBox<String>();
		myPlayers = new JComboBox<String>();
		myVariable1 = new JComboBox<String>();
		myVariable2 = new JComboBox<String>();
		for (String s:myConditionsParameters.keySet()) {
			myConditions.addItem(s);
		}
		for (Player p : myController.getPlayers()){
			myPlayers.addItem(p.getName());
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
		guts.add(myPlayers);
		guts.add(myVariable1);
		guts.add(myVariable2);
		JButton create = new JButton("Create");
		create.addActionListener(new CreateConditionListener());
		guts.add(create);
		return guts;
	}

	private void fillConditionParameters() {
		myConditionsParameters = new HashMap<String, IConditionParameterSetter>();
		myConditionsParameters.put("Create", new CreateParameterSetter(myController));
		myConditionsParameters.put("Defeat", new DefeatParameterSetter(myController));
		myConditionsParameters.put("WayPoint", new WaypointParameterSetter(myController));
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
	public class CreateConditionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	
}
