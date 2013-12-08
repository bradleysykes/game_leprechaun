package gae.buttons;

import gae.dialogues.EffectsDialogue;
import gae.dialogues.ResourcesDialogue;
import gae.dialogues.SubUnitDialogue;
import gae.dialogues.UnitCreationDialogue;
import gae.panel_lists.BoardList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.stats.Stat;
import model.stats.StatCollection;

public class SaveInputButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	private StatCollection myStat;
	private BoardList myList;
	
	public SaveInputButton(Stat stat, BoardList list){
		super("Create "+stat.getName());
		myStat = (StatCollection)stat;
		myList = list;
		this.addActionListener(new ResourceListener(this));
		
	}
	
	public class ResourceListener implements ActionListener {
		
		private JButton mySource;
		
		public ResourceListener(JButton buttonSource){
			mySource = buttonSource;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// find resources
			if(myStat.getName().equals("Resources")){
				ResourcesDialogue resourceDialogue = new ResourcesDialogue(myList, myStat);
			}
			else if (myStat.getName().equals("Effects")){
				EffectsDialogue effectsDialogue = new EffectsDialogue(myList,myStat);
			}
			else{
				SubUnitDialogue d = new SubUnitDialogue(myStat,myStat.getName(),
						myStat.getStats(),myList);
			}
		}
		
	}
}
