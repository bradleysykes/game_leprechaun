package gae;

import java.awt.Dimension;

public interface Constants {
	final Dimension minimum = new Dimension(100,100);
	final Dimension preferred = new Dimension(300,300);
	final Dimension EDITGUI_INITIAL_SIZE = new Dimension(1000,700);
	final String ICON_PATH = System.getProperty("user.dir")+"\\gae\\resources\\";
	final String NEW_ICON_RELATIVEPATH = "plus.gif";
	final String UNIT_PACKAGE_NAME = "tile";
	final String TILE_PACKAGE_NAME = "tile";
	final String CONDITION_PACKAGE_NAME = "tile";
}
