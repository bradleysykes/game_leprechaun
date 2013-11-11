package editorMenus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JFrame;

public class gameOptionsEditor extends JFrame {
	private Dimension myPreferredSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static String myRulesPackage = "\\model\\rules";
	
	
	public gameOptionsEditor() {
		super();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		
		addContentToFrame();
		this.pack();		
	}

	private void generateContent() {
		
	}
	

	private void addContentToFrame() {
		// TODO Auto-generated method stub
		
	}
	public static void main (String arg[]) {
		gameOptionsEditor x = new gameOptionsEditor();
	}
}
