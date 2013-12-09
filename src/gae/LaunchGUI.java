package gae;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class LaunchGUI extends JFrame {
	
	private JFrame myLaunchGUI = this;
	
	public LaunchGUI(){
		LaunchPanel mainPanel = new LaunchPanel(this);
		this.setContentPane(mainPanel);
		try {
			this.setIconImage(ImageIO.read(Constants.LAUNCH_BACKGROUND_IMAGE));
		} catch (IOException e) {
			
		}
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
