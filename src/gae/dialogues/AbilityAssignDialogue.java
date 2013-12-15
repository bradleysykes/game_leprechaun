package gae.dialogues;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gae.ResourceComboBox;
import gae.control.Controller;
import gae.panel_lists.AbilityList;
import gae.panel_lists.BoardList;
import gae.panel_lists.TileList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Attributes;
import model.Effect;
import model.Effects;
import model.Resource;
import model.Resources;
import model.abilities.CustomAbility;
import model.effects.ModifyAttribute;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class AbilityAssignDialogue extends JFrame {
	
	private CustomAbility myAbility;
	private Controller myController;
	private JComboBox<String> myUnitChoices = new JComboBox<String>();
	
	
	public AbilityAssignDialogue(Controller controller, CustomAbility ability){
		myAbility = ability;
		myController = controller;
		if (myController.getUnitTypes().size() == 0){
			System.out.println("Display Error Message: No units have been created!");
			return;
		}
		JPanel main = createGutsPanel();
		this.add(main);
		this.pack();
		this.setVisible(true);
	}


	public JPanel createGutsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		Attributes myAttributes = new Attributes();
		for (Unit u : myController.getUnitTypes()){
			myUnitChoices.addItem(u.getID());
		}
		panel.add(myUnitChoices);
		
		JButton confirm = new JButton("Give Ability");
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				createEffect(myUnitChoices.getSelectedIndex());
			}
			
		});
		panel.add(confirm);
		
		JButton done = new JButton("Done");
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				postInput();
			}
			
		});
		panel.add(done);
		return panel;
	}
	
	public void createEffect(int index){
		myController.getUnitTypes().get(index).getStatCollection("Abilities").addStat(myAbility);
	}
	
	public void postInput() {
		
		this.dispose();
	}

}
