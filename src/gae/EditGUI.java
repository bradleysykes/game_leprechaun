package gae;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class EditGUI extends JFrame {
	
	public EditGUI(){
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(new Workspace());
		this.add(new JToolBar().add(new JButton("File")));
		this.setContentPane(mainPanel);
		this.setSize(new Dimension(1000,1000));
		this.pack();
		this.setVisible(true);
	}
}
