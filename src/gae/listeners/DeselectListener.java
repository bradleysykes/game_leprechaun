package gae.listeners;

import gae.panel_lists.BoardList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeselectListener implements ActionListener {
	
	private BoardList myListSource;
	
	public DeselectListener(BoardList source){
		myListSource = source;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myListSource.clearSelection();
	}

}
