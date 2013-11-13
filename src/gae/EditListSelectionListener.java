package gae;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.tile.Tile;

public class EditListSelectionListener implements ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
		/**
		 *  board object selected by designer. 
		 *  Prepare object for board placement.
		 */
			try{
			BoardList listSource =(BoardList) e.getSource();
			if(listSource.getSelectedIndex()!=-1){
				BoardListItem selectedItem = (BoardListItem)listSource.getSelectedValue();
				BoardBuffer.push(selectedItem);
				if(selectedItem instanceof NewUnit){
					new UnitCreationDialogue(listSource.getListType());
				}
				listSource.clearSelection();
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
