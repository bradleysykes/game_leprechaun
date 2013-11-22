package gae.dialogues;

import gae.Controller;
import gae.panel_lists.BoardList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import model.stats.Stat;
import model.unit.Unit;
import model.Player;
import model.Condition;

@SuppressWarnings("serial")
public class ConditionDialogue extends InputDialogue {
	private JComboBox<String> players;// = new JComboBox<String>();
	private JComboBox<String> conditions;// = new JComboBox<String>();
	private JComboBox<String> units;// = new JComboBox<String>();

	public ConditionDialogue(List<Stat> props, BoardList list) {
		super(props, list);
	}

	public ConditionDialogue(Controller controller) {
		super(controller);
		this.myController=controller;
	}

	@Override
	public JPanel createGutsPanel() {
		JPanel guts = new JPanel();
		
		/*JComboBox<String> players = new JComboBox<String>();
		JComboBox<String> conditions = new JComboBox<String>();
		JComboBox<String> units = new JComboBox<String>();*/
		
		players = new JComboBox<String>();
		conditions = new JComboBox<String>();
		units = new JComboBox<String>();
		
		List<Condition> myConditions = new ArrayList<Condition>();
		try {
			for(Class<Condition> c : reflectOnConditionsPackage()){
				myConditions.add(c.newInstance());
			}
		} catch (Exception e) {

		}
		for (Condition c : myConditions){
			conditions.addItem(c.getName());
		}
		for (Player p : myController.getPlayers()){
			players.addItem(p.getName());
		}
		players.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("if only players had units to add...");
				Player playa = myController.getPlayers().get(players.getSelectedIndex());
				units.removeAll();
/*				for(Unit u : playa.getAllUnits()){
					units.addItem(u.getName());
				}*/
			}
		});
		guts.add(conditions);
		guts.add(players);
		guts.add(units);
		return guts;
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

}
