package gae;

import java.awt.Dimension;

public interface Constants {
	final Dimension minimum = new Dimension(100,100);
	final Dimension preferred = new Dimension(300,300);
	final Dimension EDITGUI_INITIAL_SIZE = new Dimension(1000,700);
	final String ICON_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\";
	final String NEW_ICON_RELATIVEPATH = "plus.gif";
	final String UNIT_PACKAGE_NAME = "tile";
	final String TILE_PACKAGE_NAME = "tile";
	final String CONDITION_PACKAGE_NAME = "tile";
	
	final int TILE_SIZE =80;
	final int UNIT_SIZE = 60;
	final int TILE_IMAGE_RESIZE = 79;
	final int UNIT_IMAGE_RESIZE = 59;
	
	final String BOARD_PANEL_TITLE = "Board Objects";
	final String MAP_PANEL_TITLE = "Game Map";
	final String OBJECT_PANEL_TITLE = "Object Properties";
	final String PLAYER_PANEL_TITLE = "Available Players";
	final String TASK_PANEL_TITLE = "Game To-Dos";
}
