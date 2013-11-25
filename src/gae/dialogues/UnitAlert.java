package gae.dialogues;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UnitAlert extends JFrame {
	private JFrame myFrame;
	public UnitAlert(){
		super("NOTICE");
		myFrame = this;
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel label = new JLabel("Please select a unit and player to place on map.");
		JButton closeButton = new JButton("OK");
		closeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myFrame.dispose();
			}
			
		});
		this.add(closeButton, BorderLayout.PAGE_END);
		this.add(label,BorderLayout.PAGE_START);
		this.revalidate();
		this.setVisible(true);
		this.pack();
	}
}
