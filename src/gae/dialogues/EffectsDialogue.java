package gae.dialogues;

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

import model.Resource;
import model.Resources;
import model.stats.StatCollection;

public class EffectsDialogue extends JFrame {
	
	private AbilityList myListSource;
	private JComboBox<String> myAttributeChoices;
	private StatCollection myStat;
	
	public EffectsDialogue(BoardList myList, StatCollection stat){
		myListSource = (AbilityList) myList;
		myStat = stat;
		JPanel main = createGutsPanel();
		this.add(main);
		this.pack();
		this.setVisible(true);
	}


	public JPanel createGutsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

		
		JButton confirm = new JButton("Ok");
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				postInput();
			}
			
		});
		panel.add(confirm);
		return panel;
	}
	
	public void postInput() {
		
		this.dispose();
	}

}
