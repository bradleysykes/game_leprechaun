package gae;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;


public abstract class EditPanel extends JPanel implements Constants,Observable {
	public EditPanel(Observer observer){
		this.setLayout(new BorderLayout());
		this.register(observer);
	}
	
	public void initialize(Component component){
//		component.setPreferredSize(preferred);
//		this.setMinimumSize(minimum);
//		this.setPreferredSize(preferred);
//		component.setPreferredSize(preferred);
	}
	

	@Override
	public void register(Observer observer) {
		myObservers.add(observer);
	}

	@Override
	public void unregister() {
		
	}

	@Override
	public void notifyObservers() {
		for(Observer ob:myObservers){
			
		}
	}

	@Override
	public void getUpdate() {
		// TODO Auto-generated method stub
		
	}
}
