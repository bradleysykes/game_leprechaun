package gae;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.GameViewer;

public class LaunchGUI extends JFrame {
	
	private JFrame myLaunchGUI = this;
	
	public LaunchGUI(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(1000,1000));
		JLabel welcomeBanner = new JLabel("Welcome to Game Leprechaun!");
		welcomeBanner.setFont(new Font(Font.SERIF, Font.BOLD,72));
		mainPanel.setBackground(Color.black);
		mainPanel.setForeground(Color.red);
		mainPanel.add(welcomeBanner);
		JButton gaeButton = new JButton("Create a game");
		gaeButton.setFont(new Font(Font.SERIF,Font.BOLD,48));
		gaeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EditGUI();
				myLaunchGUI.dispose();
			}
			
		});
		mainPanel.add(gaeButton);
		JButton playerButton = new JButton("Play a game");
		playerButton.setFont(new Font(Font.SERIF,Font.BOLD,48));
		playerButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new GameViewer();
				myLaunchGUI.dispose();
			}
			
		});
		mainPanel.add(playerButton);
		this.setContentPane(mainPanel);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
