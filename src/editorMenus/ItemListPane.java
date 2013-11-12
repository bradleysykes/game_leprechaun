package editorMenus;

import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ItemListPane extends JPanel {
	private DefaultListModel<String> myModel;
	private Dimension myPreferredSize = new Dimension(150, 300);
	private JList<String> myStringList;
	public ItemListPane(String title) {
		super();
		this.setName(title);
		myModel = new DefaultListModel<String>();
		myModel.addElement(title);
		myStringList = new JList<String>(myModel);
		this.add(myStringList);
		this.setPreferredSize(myPreferredSize);
	}
	public void addStringToPanel(String element) {
		myModel.addElement(element);
	}
	
	public JList<String> getStringList() {
		return myStringList;
	}
	public DefaultListModel<String> getModel() {
		return myModel;
	}
}
