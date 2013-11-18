package gae;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.things.Stat;


public class ViewItemField<T> extends JPanel {
	
	private JTextField myField;
	private T myData;

	public ViewItemField(Stat stat){
		this.setLayout(new BorderLayout());
		create(stat);
	}

	private void create(Stat stat) {
		JLabel fieldTitle = new JLabel(stat.getName());
		JLabel fieldDescription = new JLabel("Double");
		JTextField field = new JTextField(stat.getValue().toString());
		myField = field;
		this.add(fieldTitle,BorderLayout.PAGE_START);
		this.add(fieldDescription,BorderLayout.CENTER);
		this.add(field,BorderLayout.PAGE_END);
	}
	
	public String getData(){
		return myField.getText();
	}
 
}
