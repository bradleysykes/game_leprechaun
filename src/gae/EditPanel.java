package gae;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;


public abstract class EditPanel extends JPanel implements Constants {
	
	public EditPanel(){
		this.setLayout(new BorderLayout());
	}
	
	public void initialize(Component component){
//		component.setPreferredSize(preferred);
//		this.setMinimumSize(minimum);
//		this.setPreferredSize(preferred);
//		component.setPreferredSize(preferred);
	}
}
