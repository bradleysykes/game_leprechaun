package gae.dialogues;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerDialogue extends JFrame {
	
	public PlayerDialogue(){
		JPanel panel = new JPanel(new FlowLayout());
		String[] numberChoices = {"1","2","3","4"};
		JComboBox combo = new JComboBox(numberChoices);
		combo.setSelectedIndex(3);
		JLabel label = new JLabel("Choose number of players");
		panel.add(combo);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
	}
}
