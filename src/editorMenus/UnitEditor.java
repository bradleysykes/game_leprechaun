package editorMenus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JFrame;

public class UnitEditor extends JFrame {
	private Dimension myPreferredSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static String myRulesPackage = "/model.rules";


	public UnitEditor() {
		super();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(myPreferredSize);
		generateContent();
		addContentToFrame();
		this.setVisible(true);
		this.pack();		
	}

	private void generateContent() {

		ArrayList<File> directories = new ArrayList<File>();
		// Get a File object for the package
		System.out.println(directories.toString());
		String currentDir = System.getProperty("user.dir");
		String path = currentDir.replace('.', '/');
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			if (loader == null) {
				throw new ClassNotFoundException("Can't get class loader.");
			}
			String x = "x";
			Enumeration<URL> resources = loader.getResources(currentDir);
			while (resources.hasMoreElements()) {
				// we are only interested in .class files
				directories.add(new File(URLDecoder.decode(resources.nextElement().getPath(), "UTF-8")));
			}
		}
		catch (ClassNotFoundException cnfe) {
			//Do nothing for now	
		}
		catch (IOException ioe) {
			
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory:directories) {
			if (directory.exists() && directory.getName()==myRulesPackage) {
				String[] files = directory.list();
				for (String file : files) {
					try {
						classes.add(Class.forName(currentDir+"."+myRulesPackage+"."+file.substring(0, file.length()-5)));
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void addContentToFrame() {
		// TODO Auto-generated method stub

	}
	public static void main (String arg[]) {
		GameOptionsEditor x = new GameOptionsEditor();
	}
}
