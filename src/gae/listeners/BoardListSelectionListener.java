package gae.listeners;

import gae.BoardBuffer;
import gae.panel_lists.BoardList;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ViewItem;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.tile.Tile;

public class BoardListSelectionListener implements ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
		/**
		 *  board object selected by designer. 
		 *  Prepare object for board placement.
		 */
			try{
			BoardList listSource =(BoardList) e.getSource();
			if(listSource.getSelectedIndex()!=-1){
				ViewItem selectedItem = (ViewItem)listSource.getSelectedValue();
				BoardBuffer.push(selectedItem);
				selectedItem.onClick(listSource.getController());
				if (selectedItem instanceof BoardListViewItem) {
					BoardListViewItem castedselectedItem = (BoardListViewItem) selectedItem;
					listSource.sendData(castedselectedItem.getModel());
				}
				
				//listSource.clearSelection();
			}
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}
		/**
		 * If designer selects NewItem, show view to set initial properties. 
		 * Else, create new instance of Object and store until user clicks
		 * on canvas. 
		 */
	

}
