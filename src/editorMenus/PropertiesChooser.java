package editorMenus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PropertiesChooser extends JPanel {
	private Dimension myPreferredSize = new Dimension(200, 200);
	private String myTitle;
	private List<Class> myClasses;
	private String myContentPackage;
	private ItemListPane myLeftPane;
	private JButton myLTRMover;
	private JButton myRTLMover;
	private ItemListPane myRightPane;
	public PropertiesChooser(String title, String sourcePackage) {
		super();
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		this.setName(title);
		myContentPackage= sourcePackage;
		myTitle = title;
		this.createAndAddGuts();
		this.generateContent();
	}
	private void createAndAddGuts() {
		myLeftPane = new ItemListPane("Available Options");
		myLTRMover = new JButton(">");
		myRTLMover = new JButton("<");
		myRightPane = new ItemListPane("Implemented Options");
		this.add(myLeftPane, BorderLayout.WEST);
		this.add(myLTRMover, BorderLayout.CENTER);
		this.add(myRTLMover, BorderLayout.CENTER);
		this.add(myRightPane, BorderLayout.EAST);
	}
	private void generateContent() {
		try {
			List<Class> myClasses = PackageClassFinder.getClassesForPackage(myContentPackage);
			for (Class classy:myClasses) {
				myLeftPane.addStringToPanel(classy.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
