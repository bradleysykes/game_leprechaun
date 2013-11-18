package gae;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class EditGUI extends JFrame implements Constants {
	public EditGUI(){
		Controller controller = new Controller();
		this.setLayout(new BorderLayout());
		this.add(new Workspace(controller),BorderLayout.CENTER);
		this.setPreferredSize(EDITGUI_INITIAL_SIZE);
		this.setJMenuBar(new EditMenuBar(controller));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

}
