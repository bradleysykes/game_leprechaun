package gae;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class EditToolbar extends JPanel {
	public EditToolbar(){
		JToolBar editToolbar = new JToolBar();
		editToolbar.add(new JButton("Task 1"));
		editToolbar.add(new JButton("Task 2"));
		editToolbar.add(new JButton("Task 3"));
		this.add(editToolbar);
	}
}
