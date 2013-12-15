package gae.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.stats.Stat;


public class ViewItemField<T> extends JPanel {
	
	private JTextField myField;
	private T myData;

	public ViewItemField(Stat stat){
		this.setLayout(new BorderLayout());
		if(stat.getValue()!=null){
			this.create(stat.getName(),"Double",stat.getValue().toString());
		}
		else{
			myField = new JTextField("0");
		}
	}
	
	public ViewItemField(String title){
		this.setLayout(new BorderLayout());
		if(title==""){
			this.create(title,"String","Enter name");
		}
		else{
			this.create(title, "String", title);
		}
	}

	private void create(String title, String type, String value) {
		JLabel fieldTitle = new JLabel(title);
		JLabel fieldDescription = new JLabel(type);
		if(value!=null){
			JTextField field = new JTextField(String.valueOf(value));
			myField = field;
			this.add(fieldTitle,BorderLayout.PAGE_START);
			this.add(fieldDescription,BorderLayout.CENTER);
			this.add(field,BorderLayout.PAGE_END);
		}
	}
	
	public String getData(){
		return myField.getText();
	}
 
}
