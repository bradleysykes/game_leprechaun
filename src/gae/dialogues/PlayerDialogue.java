
package gae.dialogues;

import gae.Controller;
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
import model.things.Thing;

public class PlayerDialogue extends JFrame {
	private JComboBox myCombo;
	private Controller myController; 
	
	public PlayerDialogue(Controller controller){
		myController = controller;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
	}
	public PlayerDialogue(int numPlayers, Controller controller) {
		this(controller);
		myCombo.setSelectedIndex(numPlayers-1);
	}

	JPanel createGutsPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		String[] numberChoices = {"1","2","3","4"};
		myCombo = new JComboBox(numberChoices);
		myCombo.setSelectedIndex(3);
		JLabel label = new JLabel("Choose number of players");
		JButton button = new JButton("OK");
		button.addActionListener(new SetPlayersAction());
		panel.add(myCombo);
		panel.add(label);
		panel.add(button);
		return panel;
	}
	
	private class SetPlayersAction implements ActionListener {
		private SetPlayersAction() {}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// look through all fields and gather information
			int numPlayers = myCombo.getSelectedIndex()+1;
			myController.postPlayers(numPlayers);
			myController.removeTask(new TaskViewItem("Remover", myController));
			disposeDialogue();
		}
	}

	public void disposeDialogue() {
		this.dispose();	
	}
}
