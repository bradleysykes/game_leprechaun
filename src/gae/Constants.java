package gae;


import java.awt.Dimension;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import model.GameMap;
import model.Player;
import model.abilities.CustomAbility;
import model.stats.Stat;
import model.tile.Tile;
import model.unit.Unit;

public interface Constants {
	final Dimension minimum = new Dimension(100,100);
	final Dimension preferred = new Dimension(300,300);
	final Dimension EDITGUI_INITIAL_SIZE = new Dimension(1500,700);
	final String ICON_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\";
	final String TASK_ICON_PATH = "task.png";
	final String NEW_ICON_RELATIVEPATH = "plus.gif";
	final String PLAYER_ICON_PATH = ICON_PATH+"player_icon.gif";
	final String UNIT_PACKAGE_NAME = "unit";
	final String TILE_PACKAGE_NAME = "tile";
	final String PLAYER_NAME_PREFIX = "Player ";
	final String CONDITION_PACKAGE_NAME = "condition";
	final String ABILITY_PACKAGE_NAME = "abilities";
	final String PLAYER_AUDIO_FILE_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\Action_Music.wav";
	final String GAE_AUDIO_FILE_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\edit.wav";
	final File LAUNCH_BACKGROUND_IMAGE = new File(System.getProperty("user.dir")+"\\src\\gae\\resources\\Leprechaun.gif");
	final String LEPRECHAUN_IMAGE_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\Leprechaun.gif";
	final int TILE_SIZE = 40;
	final int UNIT_SIZE = 40;
	final int TILE_IMAGE_RESIZE = 39;
	final int UNIT_IMAGE_RESIZE = 29;
	final int CONDITION_IMAGE_RESIZE = 39;
	final int RESOURCE_IMAGE_RESIZE = 19;
	final String UNIT_MAP_PREFIX = "z";
	final String BOARD_PANEL_TITLE = "Board Objects";
	final String MAP_PANEL_TITLE = "Game Map";
	final String OBJECT_PANEL_TITLE = "Object Properties";
	final String PLAYER_PANEL_TITLE = "Available Players";
	final String TASK_PANEL_TITLE = "Game To-Dos";
	final String DEFAULT_TILE_NAME = "Default";
	
	final String DEFAULT_TILE_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\rock.jpg";
	final String DEFAULT_UNIT_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\default_unit.png";
	final String DEFAULT_CONDITION_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\plus.gif";
	final String DEFAULT_RESOURCE_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\resource.png";
	final String DEFAULT_ABILITY_IMAGE_PATH = System.getProperty("user.dir")+"\\src\\gae\\resources\\boom2.png";
	
	final List<Stat> DEFAULT_UNIT_STATS = new Unit("Unit",new Player(), new Tile(3,3,new GameMap(50,50))).getStats();
	final List<Stat> DEFAULT_TILE_STATS = new Tile(1.0,1.0, new GameMap(50,50)).getStats();
	final List<Stat> DEFAULT_ABILITY_STATS = new CustomAbility("Ability",new Unit("Unit", new Player(), 
			new Tile(3,3,new GameMap(50,50))),5.0,5.0).getStats();

	final JFileChooser FILE_CHOOSER = new JFileChooser(new File(System.getProperty("user.dir")));
}
