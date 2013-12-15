package gae.menu_bar;

import gae.control.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSourceMenuItem extends GUIMenuItem {

	public ViewSourceMenuItem(Controller controller,EditMenuBar menuSource) {
		super("View XML Source", controller, menuSource);
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				myController.displayFile();
				myExecuted = true;
			}
			
		};
	}


}
