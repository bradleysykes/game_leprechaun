package gae.listeners;

import gae.control.Controller;
import gae.map.GUIMap;
import gae.panels.MapPanel;
import gae.popup_menus.GAEPopupMenu;
import gae.popup_menus.MapPopupMenu;
import gae.viewitems.ViewItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapPopupListener extends MouseAdapter {
	
	private GAEPopupMenu myMenu;
	private Controller myController;
	private GUIMap myPanelSource;
	
	public MapPopupListener(Controller controller, GUIMap panelSource){
		myController = controller;
		myPanelSource = panelSource;
		myMenu = new MapPopupMenu(myController,myPanelSource);
	}

	public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
        maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            myMenu.show(e.getComponent(),e.getX(), e.getY());
            //finds the selected ViewItem
            System.out.println(e.getX()+ "  "+ e.getY());
        }
    }
}