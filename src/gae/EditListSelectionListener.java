package gae;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EditListSelectionListener implements ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
		/**
		 *  board object selected by designer. 
		 *  Prepare object for board placement.
		 */
			UnitList listSource =(UnitList) e.getSource();
			if (listSource.getSelectedIndex() != -1){
				System.out.println("woohoo");
				BoardListItem selectedItem = (BoardListItem)listSource.getSelectedValue();
				Class selectedClass = selectedItem.getObjectClass();
				selectedItem.onSelected(listSource);
				listSource.clearSelection();
		}
		/**
		 * If designer selects NewItem, show view to set initial properties. 
		 * Else, create new instance of Object and store until user clicks
		 * on canvas. 
		 */
	}

}
