package gae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import model.MyAnnotation;

public class TileEditor extends JPanel {
	private Dimension myPreferredSize=new Dimension(600, 300);
	private PackageClassFinder myFinder = new PackageClassFinder();
	private ItemListPane myProperties;
	private ArrayList<JTextPane> myEditorAreas;
	private ArrayList<JButton> myExtraMenuButtons;
	public TileEditor() {
		super();
		myEditorAreas = new ArrayList<JTextPane>();
		myExtraMenuButtons = new ArrayList<JButton>();
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(myPreferredSize);
		this.setVisible(true);
		defineProperties();
		
	}
	private int[] defineProperties() {
		int[] propertyCounter = new int[2];
		myProperties=new ItemListPane("Tile Properties");
		myProperties.setBackground(Color.GRAY);
		this.add(myProperties, BorderLayout.WEST);
		List<Class> classes;
		try {
			classes = myFinder.getClassesForPackage("model.tile");	
			Constructor[] construct = classes.get(0).getConstructors();
			for (Constructor c:construct) {
				Annotation[][] annotations = c.getParameterAnnotations();
				if (!annotations.equals(null)) {
					for (Annotation[] alpha:annotations) {
						for (Annotation a:alpha) {
//							if (a instanceof MyAnnotation) {
								MyAnnotation annoted = (MyAnnotation) a;
								myProperties.addStringToPanel(annoted.name()+"   "+annoted.specs());
//							}
						}	
					}
					int counter = 0;
					JPanel rightPanel = new JPanel();
					rightPanel.setPreferredSize(new Dimension(200, 300));
					JTextPane f = new JTextPane();
					f.setBackground(Color.GRAY);
					f.setEditable(false);
					f.setPreferredSize(new Dimension(150, 20));
					rightPanel.add(f);
					for(Class clazz:c.getParameterTypes()) {
						if (clazz.isPrimitive() || clazz.equals(String.class)) {
							JTextPane tp = new JTextPane();
							tp.setPreferredSize(new Dimension(150, 20));
							tp.setVisible(true);
							myEditorAreas.add(tp);
							rightPanel.add(tp);
						}
						else {
							JButton b = new JButton("Edit");
							this.add(b, BorderLayout.EAST);
						}
						counter++;
					}
					this.add(rightPanel, BorderLayout.EAST);
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return propertyCounter;
	}
	
	public List<String> getEditorAreaContents() {
		List<String> args = new ArrayList<String>();
		for (JTextPane each:myEditorAreas) {
			args.add((String) each.getText());
		}
		return args;
	}
}
