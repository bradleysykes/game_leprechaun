package gae.listeners;

import gae.buttons.FileButton;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileButtonListener implements ActionListener {
	private Component myParent;
	public FileButtonListener(Component component){
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//launch a new file chooser
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(myParent);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		            ((FileButton)myParent).sendFile(chooser.getSelectedFile());
		    }
	}
	
}

