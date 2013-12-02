package engine.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class NextTurnListener implements ActionListener {
	
	Model myModel;
	
	public NextTurnListener(Model m) {
		myModel = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Next turn for model");
		//myModel.nextTurn();
	}
	
}
