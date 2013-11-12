package gae;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PlayerPanel extends EditPanel {
	public PlayerPanel(Observer observer){
		super(observer);
		JTextArea textArea = new JTextArea("Players");
		this.setBackground(Color.GREEN);
		this.add(textArea);
		initialize(textArea);
	}

	@Override
	public void execute(Object o) {
		// TODO Auto-generated method stub
		
	}
}
