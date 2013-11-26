package gae.listeners;

import gae.Constants;
import gae.buttons.FileButton;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileButtonListener implements ActionListener, Constants{
	private FileButton myParent;
	public FileButtonListener(FileButton button){
		myParent = button;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//launch a new file chooser
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		    FILE_CHOOSER.setFileFilter(filter);
		    int returnVal = FILE_CHOOSER.showOpenDialog(myParent);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		            myParent.sendFile(FILE_CHOOSER.getSelectedFile());
		    }
	}
	
}

