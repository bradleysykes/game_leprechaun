package gae.menu_bar;

import gae.Controller;

public class FileMenu extends GUIMenu {
	
	private GUIMenuItem mySaveItem;
	private GUIMenuItem myFileViewItem;
	
	public FileMenu(Controller controller, EditMenuBar menuSource){
		super("File", controller, menuSource);
		GUIMenuItem saveAsItem = new SaveAsMenuItem(myController, myMenuSource);
		GUIMenuItem exitItem = new ExitMenuItem(myController, myMenuSource);
		mySaveItem = new SaveMenuItem(myController,myMenuSource);
		mySaveItem.setEnabled(false);
		GUIMenuItem openItem = new OpenMenuItem(myController,myMenuSource);
		GUIMenuItem newItem = new NewMenuItem(myController,myMenuSource);
		myFileViewItem = new ViewSourceMenuItem(myController,myMenuSource);
		myFileViewItem.setEnabled(false);		
		this.add(myFileViewItem);
		this.add(newItem);
		this.add(saveAsItem);
		this.add(mySaveItem);
		this.add(openItem);
		this.add(exitItem);
	}

	@Override
	public void enableAll() {
		mySaveItem.setEnabled(true);
		myFileViewItem.setEnabled(true);
	}

}
