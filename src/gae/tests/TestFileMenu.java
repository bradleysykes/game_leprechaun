package gae.tests;

import static org.junit.Assert.*;

import java.util.List;

import gae.control.Controller;
import gae.menu_bar.EditMenuBar;
import gae.menu_bar.FileMenu;
import gae.menu_bar.GUIMenuItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFileMenu {
	
	private FileMenu myFileMenu;
	private Controller myController;
	private EditMenuBar myMenuBar;

	@Before
	public void setUp() throws Exception {
		myController = new Controller();
		myMenuBar = new EditMenuBar(myController);
		myFileMenu = new FileMenu(myController,myMenuBar);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMenuItems() {
		List<GUIMenuItem> items = myFileMenu.getItems();
		for(GUIMenuItem item:items){
			item.doClick();
			System.out.println(item.getClass());
			assertTrue(item.hasExecuted());
		}
	}

}
