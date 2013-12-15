package gae.menu_bar;

import gae.Constants;
import gae.control.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenMenuItem extends GUIMenuItem {

	public OpenMenuItem(Controller controller,EditMenuBar menuSource) {
		super("Open", controller, menuSource);
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				myController.open();
				myExecuted = true;
				myExecuted = true;
			}
			
		};
	}


}
