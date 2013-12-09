package gae.popup_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.abilities.CustomAbility;

import gae.Controller;
import gae.dialogues.AbilityAssignDialogue;
import gae.panel_lists.AbilityList;
import gae.panel_lists.BoardList;
import gae.popup_menus.GAEPopupMenu.DeleteListener;
import gae.viewitems.AbilityViewItem;

public class AbilityPopupMenu extends GAEPopupMenu {
	
	private BoardList myListSource;

	public AbilityPopupMenu(Controller controller, BoardList source){
		super(controller);
		myListSource = source;
		initialize();
	}

	@Override
	public void subInitialize() {
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(new DeleteListener(myListSource));
		this.add(delete);
		myListSource.getModel();
		JMenuItem add = new JMenuItem("Add Ability to Unit");
		add.addActionListener(new AbilityListener());
		this.add(add);
	}
	
	public class AbilityListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new AbilityAssignDialogue(myController, ((AbilityViewItem) mySource).getModelObject());
		}
		
	}

}
