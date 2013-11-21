package gae.buttons;

import java.io.File;

import gae.dialogues.InputDialogue;
import gae.dialogues.UnitCreationDialogue;
import gae.listeners.FileButtonListener;


import javax.swing.JButton;


public class FileButton extends JButton {
	private File myImage;
	private UnitCreationDialogue myParent;
	public FileButton(String name, UnitCreationDialogue parent){
		super(name);
		this.addActionListener(new FileButtonListener(this));
		myParent = parent;
	}

	/**
	 * method to receive file once user confirms file chooser choice.
	 * @param selectedFile
	 */
	public void sendFile(File selectedFile) {
		// TODO Auto-generated method stub
		myImage = selectedFile;
		myParent.setImage(selectedFile);
	}
}
