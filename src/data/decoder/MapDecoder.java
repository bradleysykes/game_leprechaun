package data_decoder;

import java.io.File;
import model.GameMap;
import org.w3c.dom.Element;
import engine.GameEngine;

/**
 * Map Decoder class that will receive the head node of Map Information
 * in xml file. This class will creates the map corresponding objects and
 * load them to the game engine.
 * 
 * @author Seunghyun Lee
 *
 */
public class MapDecoder extends Decoder {
    
    GameMap myGameMap;
    
    public MapDecoder (GameEngine engine) {
        super(engine);
    }
    
    public void initMap() {
        
    }
    public void loadMap() {

    }
    
    @Override
    public void create (Element element) {
        
    }

    
    public static void main (String[] args) {
        
        System.out.println("hi");
    }
}
