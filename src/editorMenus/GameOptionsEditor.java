package editorMenus;

import java.awt.BorderLayout;
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
		this.setLayout(new BorderLayout());
		myRuleNames = new ArrayList<String>();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		generateContent();
		addContentToFrame();
		this.pack();		
	}

	private void generateContent() {
		try {
			List<String> classes = PackageClassFinder.getClassesForPackage(myRulesPackage);
			for (String classy:classes) {
				myRuleNames.add(classy);
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
		this.add(myRulesPane, BorderLayout.WEST);
		
	}
	public static void main (String arg[]) {
		GameOptionsEditor x = new GameOptionsEditor();
		new PackageClassFinder();
		
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

