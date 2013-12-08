package gae.dialogues;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gae.ResourceComboBox;
import gae.panel_lists.BoardList;
import gae.panel_lists.TileList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Resource;
import model.Resources;
import model.stats.StatCollection;

public class ResourcesDialogue extends JFrame {
	
	private BoardList myListSource;
	private JList myResourceChoices;
	private StatCollection myStat;
	
	public ResourcesDialogue(BoardList listSource, StatCollection stat){
		myListSource = listSource;
		myStat = stat;
		JPanel main = createGutsPanel();
		this.add(main);
		this.pack();
		this.setVisible(true);
	}


	public JPanel createGutsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		// find all of the user-created resources in ResourceList
		List<Resource> userResources = myListSource.getUserResources();
		myResourceChoices = new JList();
		myResourceChoices.setCellRenderer(new DefaultListCellRenderer(){

			@Override
			public Component getListCellRendererComponent(JList list,
					Object item, int index, boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(list, item, index, isSelected, cellHasFocus);
				Resource selectedResource = (Resource)item;
				setText(selectedResource.getID().split("\\|")[0]);
				return this;
			}
			
		});
		DefaultListModel resourceModel = new DefaultListModel();
		for(Resource r:userResources){
			resourceModel.addElement(r);
		}
		myResourceChoices.setModel(resourceModel);
		myResourceChoices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(myResourceChoices);
		JButton confirm = new JButton("Ok");
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				postInput();
			}
			
		});
		panel.add(confirm);
		return panel;
	}
	
	public void postInput() {
		Resource selection = (Resource)myResourceChoices.getSelectedValue();
		Resources resources = (Resources)myStat;
		resources.addResource(selection);
		this.dispose();
	}

}
