package gae.popup_menus;

import javax.swing.JMenuItem;

import gae.Controller;
import gae.panel_lists.BoardList;
import gae.popup_menus.GAEPopupMenu.DeleteListener;

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

	}

}
