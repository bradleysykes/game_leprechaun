
package gae.dialogues;

import gae.control.Controller;
import gae.viewitems.PlayerTaskViewItem;
import gae.viewitems.PlayerViewItem;
import gae.viewitems.TaskViewItem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;

public class PlayerDialogue extends InputDialogue {
	private JComboBox myCombo;
	
	public PlayerDialogue(Controller controller){
		super();
		this.myController = controller;
	}
	
	public PlayerDialogue(int numPlayers, Controller controller) {
		this(controller);
		myCombo.setSelectedIndex(numPlayers-1);
	}
	
	@Override
	public JPanel createGutsPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		String[] numberChoices = {"1","2","3","4"};
		myCombo = new JComboBox(numberChoices);
		myCombo.setSelectedIndex(3);
		JLabel label = new JLabel("Choose number of players");
		JButton button = new JButton("OK");
		button.addActionListener(new GetDataAction());
		panel.add(myCombo);
		panel.add(label);
		panel.add(button);
		return panel;
	}

	@Override
	public void postInput() {
		// look through all fields and gather information
		int numPlayers = myCombo.getSelectedIndex()+1;
		myController.postPlayers(numPlayers);
		myController.removeTask(new PlayerTaskViewItem(myController));
		disposeDialogue();
	}
}
