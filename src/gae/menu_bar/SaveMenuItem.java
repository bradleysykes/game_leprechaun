package gae.menu_bar;

import gae.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveMenuItem extends GUIMenuItem {

	public SaveMenuItem(Controller controller,EditMenuBar menuSource) {
		super("Save", controller, menuSource);
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				myController.save();
			}
			
		};
	}

}
