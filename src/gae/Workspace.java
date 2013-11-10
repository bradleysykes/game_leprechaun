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
	
	public Workspace(){
		super(new BorderLayout(10,10));
		Component left = new EditView(new TaskPanel(), new BoardPanel(), JSplitPane.VERTICAL_SPLIT);
		Component right = new EditView(new ObjectPanel(), new PlayerPanel(),JSplitPane.VERTICAL_SPLIT);
		EditView leftGroup = new EditView(left,new MapPanel(),JSplitPane.HORIZONTAL_SPLIT);
		EditView everything = new EditView(leftGroup, right, JSplitPane.HORIZONTAL_SPLIT);
		this.add(everything);
//		this.setMinimumSize(new Dimension(100,100));
//		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.add(new JToolBar().add(new JButton("File")));
	}
}
