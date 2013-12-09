package gae.menu_bar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gae.Controller;

public class SaveAsMenuItem extends GUIMenuItem {

	public SaveAsMenuItem(Controller controller,EditMenuBar menuSource) {
		super("Save As", controller, menuSource);
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				myController.getAndSaveState("");
				myMenuSource.activateSaveItem();
			}
			
		};
	}

}
