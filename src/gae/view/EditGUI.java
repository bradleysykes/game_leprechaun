package gae.view;
import gae.Constants;
import gae.control.Controller;
import gae.menu_bar.EditMenuBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import data.GameElements;
import data.decoder.DataManager;


public class EditGUI extends JFrame implements Constants {
	
	private Controller myController;
	private InputStream myStream;
	
	public EditGUI(){
		this.setTitle("Game Leprechaun Creator");
		myController = new Controller();
		myController.setGUI(this);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.red);
		try{
			myStream = new FileInputStream(Constants.GAE_AUDIO_FILE_PATH);
			AudioPlayer.player.start(myStream);
		}
		catch(Exception e){
			// audio will not play. no big deal. 
		}
		this.add(new Workspace(myController),BorderLayout.CENTER);
		this.setPreferredSize(EDITGUI_INITIAL_SIZE);
		this.setJMenuBar(new EditMenuBar(myController));
		try {
			this.setIconImage(ImageIO.read(Constants.LAUNCH_BACKGROUND_IMAGE));
		} catch (IOException e) {
			// do nothing
		}
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public EditGUI(String openPath) {
		this();
		DataManager manager = new DataManager();
		GameElements openElements = manager.getGameElements(new File(openPath));
		myController.setGameFilePath(openPath);
		try{
			myController.loadData(openElements);
		}
		catch(Exception e){
			myController.closeMap();
			this.dispose();
			new EditGUI();
		}
	}
	
	public InputStream getInputStream(){
		return myStream;
	}
	

}
