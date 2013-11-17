package gae.buttons;

import gae.dialogues.UnitCreationDialogue;
import gae.panel_lists.BoardList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.things.Stat;
import model.things.StatCollection;

public class SaveInputButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	private StatCollection myStat;
	private BoardList myList;
	
	public SaveInputButton(Stat stat, BoardList list){
		super("Create "+stat.getName());
		myStat = (StatCollection)stat;
		myList = list;
		this.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UnitCreationDialogue d = new UnitCreationDialogue(myStat.getName(),
						myStat.getStats(),myList);
			}
			
		});
	}
}