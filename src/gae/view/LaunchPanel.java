package gae.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;

import engine.GameViewer;
import gae.Constants;

public class LaunchPanel extends JPanel {
	
	private Image myBackgroundImage;
	private JPanel myParent;
	private LaunchGUI myLaunch;
	
	public LaunchPanel(LaunchGUI launch){
		myParent = this;
		myLaunch = launch;
		setLayout(new BoxLayout(myParent,BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(1000,1000));
		JLabel welcomeBanner = new JLabel("Welcome to Game Leprechaun!");
		welcomeBanner.setFont(new Font(Font.SERIF, Font.BOLD,72));
		//setBackground(Color.black);
		setForeground(Color.red);
		add(welcomeBanner);
		JButton gaeButton = new JButton("Create a game");
		gaeButton.setFont(new Font(Font.SERIF,Font.BOLD,48));
		gaeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EditGUI();
				myLaunch.dispose();
				stopAudio();
			}
			
		});
		add(gaeButton);
		JButton playerButton = new JButton("Play a game");
		playerButton.setFont(new Font(Font.SERIF,Font.BOLD,48));
		playerButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new GameViewer();
				myLaunch.dispose();
				stopAudio();
			}
			
		});
		add(playerButton);
		try {
			myBackgroundImage = ImageIO.read(Constants.LAUNCH_BACKGROUND_IMAGE);
		} catch (IOException e1) {
			this.setBackground(Color.black);
		}
	}
	
	public void stopAudio(){
		try{
			InputStream test = myLaunch.getInputStream();
			AudioPlayer.player.stop(test);
		}
		catch(Exception exception){
			// audio will not play. no big deal. 
		}
	}
	
	
	@Override public void paintComponent(Graphics g) {
        g.drawImage(myBackgroundImage, 0, 0, null);
    }
}
