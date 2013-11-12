package data.decoder;

import java.util.ArrayList;
import java.util.Collection;
import model.GameMap;
import model.Resource;
import model.Resources;
import model.Terrain;
import model.tile.Tile;
import model.unit.Unit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
    Element myRoot;
    
    public MapDecoder (Element root) {
        super(root);
    }
    
    public void initMap() {
        int x_dim = Integer.parseInt(getAttribute(X_DIM, myRoot));
        int y_dim = Integer.parseInt(getAttribute(Y_DIM, myRoot));
        myGameMap = new GameMap(x_dim, y_dim);
    }
    
    public void processMap() {
        NodeList tiles = myRoot.getElementsByTagName(TILE);
        
        for(int i = 0; i < tiles.getLength(); i++) {
            Element tempTile = (Element)tiles.item(i);
            setTile(tempTile);
        }
        
    }
    
    public void setTile(Element tile) {
        String image = getAttribute(IMAGE, tile);
        int maxPop = Integer.parseInt(getAttribute(MAX_POP, tile));
        double passability = Double.parseDouble(getAttribute(PASSABILITY, tile));       
        int x = Integer.parseInt(getAttribute(X_COORD, tile));
        int y = Integer.parseInt(getAttribute(Y_COORD, tile));
        Element terrElement = (Element) tile.getElementsByTagName(TERRAIN).item(0);
        Terrain terrain = getTerrain(terrElement); 
        Element resourceList = (Element) tile.getElementsByTagName(RESOURCES).item(0);
        Resources resources = getResources(resourceList);

        //create tile with constructor.
        Tile resultTile = new Tile(resources, passability, terrain, image, new ArrayList<Unit>(), maxPop, x, y);
        myGameMap.setTile(x, y, resultTile);
    }
    
    public Terrain getTerrain(Element terrain) {
        return new Terrain(getAttribute(NAME, terrain));
    }
    
    public Resources getResources(Element resources) {
        Resources result = new Resources();
        NodeList resourceList = resources.getElementsByTagName(RESOURCE);
        for(int i = 0; i < resourceList.getLength(); i++) {
            Element resource = (Element) resourceList.item(i);
            
            double amount = Double.parseDouble(getAttribute(AMOUNT, resource));
            double harvestRate = Double.parseDouble(getAttribute(HARVEST_RATE, resource));
            String name = getAttribute(NAME, resource);
            
            result.addResource(new Resource(name, amount, harvestRate));
        }
        return result;
    }
    
    public void load(GameEngine engine) {
        engine.loadMap(myGameMap);
    }

}
