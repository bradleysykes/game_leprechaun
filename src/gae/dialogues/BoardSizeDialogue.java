package gae.dialogues;

import gae.Controller;
import gae.viewitems.BoardSizeTaskViewItem;
import gae.viewitems.TaskViewItem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoardSizeDialogue extends JFrame {
	private Controller myController;
	private JTextField myWidthField;
	private JTextField myHeightField;

	public BoardSizeDialogue(Controller controller){
		myController = controller;
		JPanel panel = createGutsPanel();
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
	}
	public BoardSizeDialogue(int currentWidth, int currentHeight, Controller controller) {
		this(controller);
		this.myWidthField.setText(currentWidth+"");
		this.myHeightField.setText(currentHeight+"");
	}

	JPanel createGutsPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JLabel widthLabel = new JLabel("Enter Board Width");
		myWidthField = new JTextField();
		JLabel heightLabel = new JLabel("Enter Board Height");
		myHeightField = new JTextField();
		JButton button = new JButton("OK");
		button.addActionListener(new SetBoardAction());
		panel.add(widthLabel);
		panel.add(myWidthField);
		panel.add(heightLabel);
		panel.add(myHeightField);
		panel.add(button);
		return panel;
	}
	
	private class SetBoardAction implements ActionListener {
		private SetBoardAction() {}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// look through all fields and gather information
			try{
			int width = Integer.parseInt(myWidthField.getText());
			int height = Integer.parseInt(myHeightField.getText());
			myController.removeTask(new BoardSizeTaskViewItem(myController));
			disposeDialogue();
			}
			catch (NumberFormatException nfe) {
				System.out.println("Sucky Formatting");
			}
		}
	}

	public void disposeDialogue() {
		this.dispose();	
	}
}
