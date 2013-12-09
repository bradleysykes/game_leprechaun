package gae.viewitems;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import gae.Controller;

public class FillTaskViewItem extends TaskViewItem {

	public FillTaskViewItem(Controller controller) {
		super("Populate the map with tiles", controller);
	}

	@Override
	public void onClick(Controller c) {
		JOptionPane alertPane = new JOptionPane("Create a custom tile and fill the map!");
		JDialog dialog = alertPane.createDialog(null,"Save alert");
		dialog.setLocation(10, 10);
		dialog.setVisible(true);
	}
}
