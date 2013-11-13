package gae.panel_lists;
import gae.listeners.EditListSelectionListener;
import gae.listeners.PopupListener;
import gae.viewitems.ViewItem;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public abstract class BoardList extends JList {
		
	private DefaultListModel myModel;
	
	public BoardList(){
		myModel = new DefaultListModel();
		this.setModel(myModel);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.addListSelectionListener(new EditListSelectionListener());
		this.setCellRenderer(new EditListRenderer());
		//this.addNewItem(new NewUnit(getListType()));
		this.addMouseListener(new PopupListener());
		//FOR DEBUG
//		BoardListItem tu = new ToyUnit();
//		this.addNewItem(tu);
	}


	public void addNewItem(ViewItem item){
		myModel.insertElementAt(item, 0);
	}
	
	public abstract String getPackageName();
	
	public abstract String getListType();
	
	public class EditListRenderer extends DefaultListCellRenderer{
		
		@Override
		public Component getListCellRendererComponent(JList list, Object item, 
				int index,boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list,item, 
					index,isSelected,cellHasFocus);
			ViewItem display = (ViewItem) item;
			label.setIcon(display.getListIcon());
			label.setText(display.getListMessage());
			return this;
		}
		
	}
	
	public class DeleteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
		
}