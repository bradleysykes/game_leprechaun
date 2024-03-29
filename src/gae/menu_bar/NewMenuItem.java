package gae.menu_bar;

import gae.control.Controller;
import gae.view.EditGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMenuItem extends GUIMenuItem {

	public NewMenuItem(Controller controller,EditMenuBar menuSource) {
		super("New", controller, menuSource);
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				myController.exit();
				new EditGUI();
				myExecuted = true;
			}
			
		};
	}


}
