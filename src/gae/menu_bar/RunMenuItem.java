package gae.menu_bar;

import engine.GameViewer;
import gae.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunMenuItem extends GUIMenuItem {

	public RunMenuItem(Controller controller, EditMenuBar menuSource) {
		super("Run", controller, menuSource);
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				myController.save();
				myController.closeMap();
				myController.launchGame();
			}
			
		};
	}

}
