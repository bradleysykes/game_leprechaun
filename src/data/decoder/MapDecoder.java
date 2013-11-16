package data.decoder;

import model.GameMap;
import model.Resource;
import model.Resources;
import model.things.ThingsThing;
import model.tile.Tile;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Map Decoder class that will receive the head node of Map Information
 * in xml file. This class will creates the map corresponding objects and
 * load them to the data manager.
 * 
 * @author Seunghyun Lee
 *
 */
public class MapDecoder extends Decoder {
    
    private static final String TERRAIN_THING = "Terrain";
    private static final String RESOURCES_THING = "Resources";
    
    private GameMap myGameMap;
    private DataManager myDataManager;
    
    public MapDecoder (DataManager manager) {
        myDataManager = manager;
    }
    
    private void processMap(Element root) {
        int x_dim = Integer.parseInt(getAttribute(X_DIM, root));
        int y_dim = Integer.parseInt(getAttribute(Y_DIM, root));
        myGameMap = new GameMap(x_dim, y_dim);

        NodeList tiles = root.getElementsByTagName(TILE);
        
        for(int i = 0; i < tiles.getLength(); i++) {
            Element tempTile = (Element)tiles.item(i);
            setTile(tempTile);
        }
    }
    
    
    private void setTile(Element tile) {
        int x = Integer.parseInt(getAttribute(X_COORD, tile));
        int y = Integer.parseInt(getAttribute(Y_COORD, tile));
        
        //create a new Tile with x,y informaiton
        Tile resultTile = new Tile(x, y);
        
        //set attributes of tile(image name, max_pop, passability).
        setThings(tile,resultTile);
        
        //set terrain to the tile
        Element terrain = (Element) tile.getElementsByTagName(TERRAIN).item(0);
        ThingsThing targetTerr = (ThingsThing) resultTile.getThing(TERRAIN_THING);
        setTerrain(terrain, targetTerr);
        
        // set resources to the tile
        Element resources = (Element) tile.getElementsByTagName(RESOURCES).item(0);
        ThingsThing targetRes = (ThingsThing) resultTile.getThing(RESOURCES_THING);
        setResources(resources,targetRes);
        
        //create tile 
        myGameMap.setTile(x, y, resultTile);
    }
    
    private void setTerrain(Element terrain, ThingsThing target) {
        setThings(terrain, target);
    }
    
    private void setResources(Element resources, ThingsThing target) {
        Resources result = (Resources) target;
        NodeList resourceList = resources.getElementsByTagName(RESOURCE);
        for(int i = 0; i < resourceList.getLength(); i++) {
            Element resource = (Element) resourceList.item(i);
            Resource res = new Resource();
            setThings(resource, res);
            result.addResource(res);
        }
    }
    
    @Override
    public void load(Element root) {
        processMap(root);
        myDataManager.setGameMap(myGameMap);
    }

}
