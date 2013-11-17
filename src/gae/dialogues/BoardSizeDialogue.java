package gae.dialogues;

import gae.Controller;
import gae.viewitems.BoardSizeTaskViewItem;
import gae.viewitems.TaskViewItem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoardSizeDialogue extends InputDialogue {
	private JTextField myWidthField;
	private JTextField myHeightField;

	public BoardSizeDialogue(Controller controller){
		super();
		myController = controller;
	}
	
	public BoardSizeDialogue(int currentWidth, int currentHeight, Controller controller) {
		this(controller);
		this.myWidthField.setText(currentWidth+"");
		this.myHeightField.setText(currentHeight+"");
	}

	@Override
	public JPanel createGutsPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JLabel widthLabel = new JLabel("Enter Board Width");
		myWidthField = new JTextField("000000");
		JLabel heightLabel = new JLabel("Enter Board Height");
		myHeightField = new JTextField("00000");
		JButton button = new JButton("OK");
		button.addActionListener(new GetDataAction());
		panel.add(widthLabel);
		panel.add(myWidthField);
		panel.add(heightLabel);
		panel.add(myHeightField);
		panel.add(button);
		return panel;
	}

	@Override
	public void postInput() {
		try{
			List<String> data = new ArrayList<String>();
			data.add(myWidthField.getText());
			data.add(myHeightField.getText());
			myController.createMap(data);
			myController.removeTask(new BoardSizeTaskViewItem(myController));
			disposeDialogue();
			}
			catch (NumberFormatException nfe) {
				System.out.println("Sucky Formatting");
			}
	}
}
