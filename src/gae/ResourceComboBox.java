package gae;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.Resource;
import model.Resources;

public class ResourceComboBox extends JComboBox<Resource> {
	
	private List<Resource> myResources;
	private DefaultComboBoxModel<Resource> myModel;
	
	public ResourceComboBox(List<Resource> resources){
		myResources = resources;
		myModel = (DefaultComboBoxModel<Resource>)this.getModel();
		this.setRenderer(new ResourceBoxRenderer());
		setUp();
	}
	
	private void setUp(){
		 for(Resource resource:myResources){
			 myModel.addElement(resource);
		 }
	}
	
	private class ResourceBoxRenderer extends BasicComboBoxRenderer {
		 @Override
	     public Component getListCellRendererComponent(JList list, Object value,
	            int index, boolean isSelected, boolean cellHasFocus) {
			 super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			Resource selectedResource = (Resource) value;
			 setText(selectedResource.getID().split("\\|")[0]);
			 return this;
		 }
	}

}
