package gae;

import gae.panels.BoardPanel;
import gae.panels.MapPanel;
import gae.panels.ObjectPanel;
import gae.panels.PlayerPanel;
import gae.panels.TaskPanel;

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
	
	private Controller myController = new Controller();
	
	public Workspace(){
		super(new BorderLayout(10,10));
		Component left = new EditView(new TaskPanel(myController), new BoardPanel(myController), JSplitPane.VERTICAL_SPLIT,0.5);
		Component right = new EditView(new ObjectPanel(myController), new PlayerPanel(myController),JSplitPane.VERTICAL_SPLIT,0.5);
		EditView leftGroup = new EditView(left,new MapPanel(myController),JSplitPane.HORIZONTAL_SPLIT,0.3);
		EditView everything = new EditView(leftGroup, right, JSplitPane.HORIZONTAL_SPLIT,0.5);
		this.add(everything);
		this.add(new EditToolbar(),BorderLayout.PAGE_START);
	}
}
