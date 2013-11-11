package editorMenus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;

public class GameOptionsEditor extends JFrame {
	private Dimension myPreferredSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static String myRulesPackage = "\\model\\rules";
	private List<String> myRuleNames;
	
	
	public GameOptionsEditor() {
		super();
		myRuleNames = new ArrayList<String>();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		addContentToFrame();
		this.pack();		
	}

	private void generateContent() {
		try {
			List<Class> classes = PackageClassFinder.getClassesForPackage(myRulesPackage);
			for (Class classy:classes) {
				myRuleNames.add(classy.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void addContentToFrame() {
		RulesPane myRulesPane = new RulesPane();
		for (String name:myRuleNames) {
			myRulesPane.addStringToPanel(name);
		}
		myRulesPane.addMouseListener(new MyMouser());
		
	}
	public static void main (String arg[]) {
		new PackageClassFinder();
		GameOptionsEditor x = new GameOptionsEditor();
	}
	private class MyMouser implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

