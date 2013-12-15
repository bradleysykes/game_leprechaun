package gae.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gae.control.Controller;
import gae.menu_bar.*;

public class TestEditMenuBar {
	
	private EditMenuBar myMenuBar;
	private Controller myController;

	@Before
	public void setUp() throws Exception {
		myController = new Controller();
		myMenuBar = new EditMenuBar(myController);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testActivateSaveItem() {
		myMenuBar.activateSaveItem();
		List<GUIMenu> subMenus = myMenuBar.getSubMenus();
		for(GUIMenu menu:subMenus){
			assertTrue(menu.saveActivated());
		}
	}

}
