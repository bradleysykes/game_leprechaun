package gae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
public class Workspace extends JPanel {
	
	public Workspace(GUIObserver observer){
		super(new BorderLayout(10,10));
		Component left = new EditView(new TaskPanel(observer), new BoardPanel(observer), JSplitPane.VERTICAL_SPLIT,0.5);
		Component right = new EditView(new ObjectPanel(observer), new PlayerPanel(observer),JSplitPane.VERTICAL_SPLIT,0.5);
		EditView leftGroup = new EditView(left,new MapPanel(observer),JSplitPane.HORIZONTAL_SPLIT,0.3);
		EditView everything = new EditView(leftGroup, right, JSplitPane.HORIZONTAL_SPLIT,0.5);
		this.add(everything);
		this.add(new EditToolbar(),BorderLayout.PAGE_START);
	}
}
