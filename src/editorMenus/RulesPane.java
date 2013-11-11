package editorMenus;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class RulesPane extends JPanel {
	DefaultListModel<String> myModel;
	public RulesPane() {
		super();
		myModel = new DefaultListModel<String>();
		myModel.addElement("Available Rules");
		JList<String> objectList = new JList<String>(model);
		this.add(objectList);
	}
	public void addStringToPanel(String element) {
		myModel.addElement(element);
	}
}
