package gae;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UnitList extends JList {
		
	private DefaultListModel myModel;
	private String[] myUnits = {"Soldier", "Assassin", "Medic"};
	
	public UnitList(){
		myModel = new DefaultListModel();
		this.setModel(myModel);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.addListSelectionListener(new EditListSelectionListener());
		this.setCellRenderer(new EditListRenderer());
		BoardListItem tu = new ToyUnit();
		this.addNewItem(tu);
	}
	
	public void addNewItem(BoardListItem item){
		myModel.addElement(item);
	}
	
	public class EditListRenderer extends DefaultListCellRenderer{
		//ImageIcon[] myIcons = {new ImageIcon(Constants.ICON_PATH+"test_icon_image.png")};
		@SuppressWarnings("unchecked")
		@Override
		public Component getListCellRendererComponent(JList list, Object item, 
				int index,boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list,item, 
					index,isSelected,cellHasFocus);
			BoardListItem display = (BoardListItem) item;
			label.setIcon(display.getIcon());
			label.setText(display.getName());
			return this;
		}
	}
	
	public class EditListSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			/**
			 *  board object selected by designer. 
			 *  Prepare object for board placement.
			 */
			
		}
		
	}
		
}
