package gae.buttons;

import gae.panel_lists.BoardList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class CreateCustomButton extends JButton {
	private BoardList myList;

	public CreateCustomButton(BoardList list){
		super("Create New");
		myList = list;
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				((CreateCustomButton)e.getSource()).executeCreate();
			}
			
		});
	}

	protected void executeCreate() {
		myList.createCustomType();
	}
}
