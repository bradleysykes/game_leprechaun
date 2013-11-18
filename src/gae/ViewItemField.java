package gae;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ViewItemField<T> extends JPanel {
	
	private JTextField myField;
	private T myData;

	public ViewItemField(String title, String description){
		this.setLayout(new BorderLayout());
		create(title, description);
	}

	private void create(String title, String description) {
		JLabel fieldTitle = new JLabel(title);
		JLabel fieldDescription = new JLabel(description);
		JTextField field = new JTextField();
		myField = field;
		this.add(fieldTitle,BorderLayout.PAGE_START);
		this.add(fieldDescription,BorderLayout.CENTER);
		this.add(field,BorderLayout.PAGE_END);
	}
	
	public String getData(){
		return myField.getText();
	}
 
}
