package gae;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapMouseListener implements MouseListener {
	private MapView myMap;
	public MapMouseListener(MapView map){
		myMap = map;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouse clicked");
		//myMap.placeOnBoard(BoardBuffer.retrieve());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("mouse clicked");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
