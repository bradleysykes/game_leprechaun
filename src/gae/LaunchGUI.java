package gae;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import sun.audio.AudioPlayer;

public class LaunchGUI extends JFrame {
	
	private InputStream myStream;
	private JFrame myLaunchGUI = this;
	
	public LaunchGUI(){
		LaunchPanel mainPanel = new LaunchPanel(this);
		this.setContentPane(mainPanel);
		try {
			this.setIconImage(ImageIO.read(Constants.LAUNCH_BACKGROUND_IMAGE));
		} catch (IOException e) {
			
		}
		try{
			myStream = new FileInputStream(Constants.GAE_AUDIO_FILE_PATH);
			AudioPlayer.player.start(myStream);
		}
		catch(Exception e){
			
		}
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public InputStream getInputStream() {
		return myStream;
	}

}
