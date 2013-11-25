package gae.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
	private Component myComponent;
	public TimerListener(Component component){
		myComponent = component;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		myComponent.setVisible(false);
	}

}
