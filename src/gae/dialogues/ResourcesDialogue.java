package gae.dialogues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gae.ResourceComboBox;
import gae.panel_lists.BoardList;
import gae.panel_lists.TileList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Resource;
import model.Resources;
import model.stats.StatCollection;

public class ResourcesDialogue extends JFrame {
	
	private BoardList myListSource;
	private ResourceComboBox myResourceChoices;
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
		if(myListSource instanceof TileList){
			TileList tileList = (TileList) myListSource;
			List<Resource> userResources = tileList.getUserResources();
			myResourceChoices = new ResourceComboBox(userResources);
			panel.add(myResourceChoices);
		}
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
		Resource selection = (Resource)myResourceChoices.getSelectedItem();
		Resources resources = (Resources)myStat;
		resources.addResource(selection);
		this.dispose();
	}

}
