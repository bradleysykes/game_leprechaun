package gae.listeners;

import java.util.List;

import gae.map.BoardBuffer;
import gae.panel_lists.BoardList;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.ViewItem;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.stats.Stat;

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
				if(!selectedItem.dialogueActive()){
					selectedItem.onClick(listSource.getController());
				}
				if (selectedItem instanceof BoardListViewItem) {
					BoardListViewItem castedselectedItem = (BoardListViewItem) selectedItem;
					List<Stat> x = castedselectedItem.getModel();
					listSource.sendData(castedselectedItem.getModel());
				}
				
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
