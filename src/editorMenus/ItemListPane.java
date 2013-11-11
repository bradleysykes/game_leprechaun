package editorMenus;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ItemListPane extends JPanel {
	DefaultListModel<String> myModel;
	public ItemListPane(String title) {
		super();
		this.setName(title);
		myModel = new DefaultListModel<String>();
		myModel.addElement("Available Rules");
		JList<String> objectList = new JList<String>(myModel);
		this.add(objectList);
	}
	public void addStringToPanel(String element) {
		myModel.addElement(element);
	}
}
