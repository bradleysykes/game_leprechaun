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
		this.addItem("barry");
	}
	
	public void addItem(String item){
		myModel.addElement(item);
	}
	
	public class EditListRenderer extends DefaultListCellRenderer {
		ImageIcon[] myIcons = {new ImageIcon(Constants.ICON_PATH+"test_icon_image.png")};
		@Override
		public Component getListCellRendererComponent(JList list, Object value, 
				int index,boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, 
					isSelected, cellHasFocus);
			Icon icon = myIcons[0];
			label.setIcon(icon);
			return label;
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
