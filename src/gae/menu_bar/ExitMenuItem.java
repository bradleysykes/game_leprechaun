package gae.menu_bar;

import gae.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuItem extends GUIMenuItem {

	public ExitMenuItem(Controller controller,EditMenuBar menuSource) {
		super("Exit", controller, menuSource);
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				myController.exit();
			}
			
		};
	}

}
