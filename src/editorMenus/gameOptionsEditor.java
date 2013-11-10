package editorMenus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JFrame;

public class gameOptionsEditor extends JFrame {
	private Dimension myPreferredSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static String myRulesPackage = "/model.rules";
	
	
	public gameOptionsEditor() {
		super();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		generateContent();
		addContentToFrame();
		this.pack();		
	}

	private void generateContent() {

		ArrayList<Class> classes = new ArrayList<Class>();
		// Get a File object for the package
		String currentDir = System.getProperty("user.dir");
		try {
			ClassLoader cld = Thread.currentThread().getContextClassLoader();
			if (cld == null) {
				throw new ClassNotFoundException("Can't get class loader.");
			}
			String path = currentDir.replace('.', '/')+myRulesPackage;
			File directory = new File(path);
			String[] files = directory.list();
			for (String file : files) {
				// we are only interested in .class files
				if (file.endsWith(".class")) {
					// removes the .class extension
					classes.add(Class.forName(path + '.' + file.substring(0, file.length() - 6)));                      
				}
			}
		}
		catch (ClassNotFoundException cnfe) {
			//Do nothing for now	
		}
	}

	private void addContentToFrame() {
		// TODO Auto-generated method stub
		
	}
	public static void main (String arg[]) {
		gameOptionsEditor x = new gameOptionsEditor();
	}
}
