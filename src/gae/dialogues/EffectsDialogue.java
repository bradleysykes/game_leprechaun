package gae.dialogues;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gae.ResourceComboBox;
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
import model.effects.ModifyAttribute;
import model.stats.Stat;
import model.stats.StatCollection;
import model.unit.Unit;

public class EffectsDialogue extends JFrame {
	
	private AbilityList myListSource;
	private JComboBox<String> myAttributeChoices = new JComboBox<String>();
	private TextField myTextField = new TextField();
	private Effects myStat;
	
	public EffectsDialogue(BoardList myList, StatCollection stat){
		myListSource = (AbilityList) myList;
		myStat = (Effects) stat;
		JPanel main = createGutsPanel();
		this.add(main);
		this.pack();
		this.setVisible(true);
	}


	public JPanel createGutsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		Attributes myAttributes = new Attributes();
		for (Stat s : myAttributes.getStats()){
			myAttributeChoices.addItem(s.getName());
		}
		panel.add(myAttributeChoices);
		panel.add(myTextField);
		
		JButton confirm = new JButton("Add Effect");
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				createEffect();
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
		panel.add(confirm);
		return panel;
	}
	
	public void createEffect(){
		myStat.addEffect(new ModifyAttribute("Effect",(String) myAttributeChoices.getSelectedItem(),Double.parseDouble(myTextField.getText())));
	}
	
	public void postInput() {
		
		this.dispose();
	}

}
