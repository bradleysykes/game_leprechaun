package gae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PropertiesChooser extends JPanel {
	private Dimension myPreferredSize = new Dimension(400, 200);
	private String myTitle;
	private List<Class> myClasses;
	private String myContentPackage;
	private ItemListPane myLeftPane;
	private JButton myLTRMover;
	private JButton myRTLMover;
	private ItemListPane myRightPane;
	private PackageClassFinder myFinder;
	public PropertiesChooser(String title, String sourcePackage) {
		super();
		myFinder = new PackageClassFinder();
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		this.setName(title);
		myContentPackage= sourcePackage;
		myTitle = title;
		this.createAndAddGuts();
		this.generateContent();
		this.addActionListeners();
	}
	private void createAndAddGuts() {
		myLeftPane = new ItemListPane("Available Options");
		JPanel buttonPanel = new JPanel();
		myLTRMover = new JButton(">");
		myLTRMover.setPreferredSize(new Dimension(60, 30));
		myRTLMover = new JButton("<");
		myRTLMover.setPreferredSize(new Dimension(60, 30));
		myRightPane = new ItemListPane("Implemented Options");
		this.add(myLeftPane, BorderLayout.WEST);
		buttonPanel.add(myLTRMover);
		buttonPanel.add(myRTLMover);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(myRightPane, BorderLayout.EAST);
	}
	private void generateContent() {
		try {
			List<Class> myClasses = myFinder.getClassesForPackage(myContentPackage);
			for (Class classy:myClasses) {
				myLeftPane.addStringToPanel(classy.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void addActionListeners() {
		myLTRMover.addActionListener(new MoveItemsAction(myLeftPane, myRightPane));
		myRTLMover.addActionListener(new MoveItemsAction(myRightPane, myLeftPane));
	}
	private class MoveItemsAction implements ActionListener {
		private ItemListPane myOriginPane;
		private ItemListPane myDestinationPane;
		MoveItemsAction(ItemListPane originPane, ItemListPane destinationPane) {
			myOriginPane = originPane;
			myDestinationPane = destinationPane;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = myOriginPane.getModel().remove(myOriginPane.getStringList().getSelectedIndex());
			myDestinationPane.getModel().addElement(s);
		}
	}
}
