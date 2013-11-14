package gae.panels;

import gae.Constants;
import gae.Controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;


public abstract class EditPanel extends JPanel implements Constants {
	
	private Controller myController;

	public EditPanel(Controller controller){
		this.setLayout(new BorderLayout());
		controller.addPanel(this);
		myController = controller;
	}
	
	public void initialize(Component component){
//		component.setPreferredSize(preferred);
//		this.setMinimumSize(minimum);
//		this.setPreferredSize(preferred);
//		component.setPreferredSize(preferred);
	}
}
	

	