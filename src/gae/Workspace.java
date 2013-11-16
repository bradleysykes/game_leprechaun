package gae;

import gae.panels.BoardPanel;
import gae.panels.EditPanel;
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
	
	private Controller myController;
	
	public Workspace(){
		super(new BorderLayout(10,10));
		myController = new Controller();
		EditPanel tasks = new TaskPanel(myController);
		EditPanel board = new BoardPanel(myController);
		EditPanel map = new MapPanel(myController);
		EditPanel objects = new ObjectPanel(myController);
		EditPanel players = new PlayerPanel(myController);
		myController.init();
		Component left = new EditView(tasks, board, JSplitPane.VERTICAL_SPLIT,0.5);
		Component right = new EditView(objects, players,JSplitPane.VERTICAL_SPLIT,0.5);
		EditView leftGroup = new EditView(left,map,JSplitPane.HORIZONTAL_SPLIT,0.3);
		EditView everything = new EditView(leftGroup, right, JSplitPane.HORIZONTAL_SPLIT,0.5);
		this.add(everything);
		this.add(new EditToolbar(),BorderLayout.PAGE_START);
	}
}
