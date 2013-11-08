package gae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
public class Workspace extends JPanel {
	
	public Workspace(){
		Component left = new EditView(new TaskPanel(), new BoardPanel(), JSplitPane.VERTICAL_SPLIT);
		Component right = new EditView(new ObjectPanel(), new PlayerPanel(),JSplitPane.VERTICAL_SPLIT);
		EditView leftGroup = new EditView(left,new MapPanel(),JSplitPane.HORIZONTAL_SPLIT);
		EditView everything = new EditView(leftGroup, right, JSplitPane.HORIZONTAL_SPLIT);
		this.add(everything);
		this.setPreferredSize(new Dimension(1000,1000));
	}
}
