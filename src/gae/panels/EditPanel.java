package gae.panels;

import gae.Constants;
import gae.Controller;
import gae.panel_lists.BoardList;
import gae.viewitems.BoardListViewItem;
import gae.viewitems.TaskViewItem;
import gae.viewitems.ViewItem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.GameElements;
import model.Player;
import model.stats.Stat;
import model.unit.Unit;


public abstract class EditPanel extends JPanel implements Constants {
	
	protected Controller myController;

	public EditPanel(Controller controller){
		this.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel();
		titleLabel.setText("<html><h3>"+this.getTitle()+"</h3>");
		this.add(titleLabel,BorderLayout.PAGE_START);
		controller.addPanel(this);
		myController = controller;
	}
	
	public void initialize(Component component){
//		component.setPreferredSize(preferred);
//		this.setMinimumSize(minimum);
//		this.setPreferredSize(preferred);
//		component.setPreferredSize(preferred);
	}
	
	public void removeBoardObject(BoardListViewItem item){
		// default is to do nothing
	}
	
	/*Used to display the title of each panel*/
	public abstract String getTitle();
	
	public void postProperties(List<Stat> properties){
		// do nothing
	}

	public void postPlayers(int numPlayers){
		//do nothing
	}
	
	public void addViewItem(ViewItem item){
		// do nothing
	}

	public void removeTask(TaskViewItem tvi) {
		// Default is to do nothing
	}

	public void createMap(List<String> data) {
		// do nothing
		
	}

	public GameElements giveStateObjects(GameElements currentState) {
		// TODO Auto-generated method stub
		return currentState;
	}

	public void fillBoard(ViewItem mySource) {
		// default is to do nothing
		//override where necessary
	}

	public List<Player> getPlayers() {
		// default is do nothing
		return null;
	}

	public List<Unit> getUnitTypes() {
		// default is to return null
		return null;
	}
}
	

	