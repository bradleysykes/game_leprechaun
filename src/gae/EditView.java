package gae;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JSplitPane;

public class EditView extends JSplitPane {
	
	public EditView(Component top, Component bottom, int orientation, double resizeWeight){
		super(orientation, top, bottom);
		this.setPreferredSize(new Dimension(600,600));
		this.setOneTouchExpandable(true);
		this.setResizeWeight(resizeWeight);
		this.setMinimumSize(new Dimension(200,200));
	}
}
