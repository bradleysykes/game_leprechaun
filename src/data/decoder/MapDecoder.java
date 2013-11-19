package data.decoder;

import model.GameMap;
import model.Resource;
import model.Resources;
import model.stats.StatCollection;
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
    
    private static final String TERRAIN_TAG= "Terrain";
    private static final String RESOURCES_TAG = "Resources";
    
    private GameMap myGameMap;
    private DataManager myDataManager;
    
    public MapDecoder (DataManager manager) {
        myDataManager = manager;
    }
    
    private GameMap processGameMap(Element root) {
        int x_dim = Integer.parseInt(getAttribute(X_DIM, root));
        int y_dim = Integer.parseInt(getAttribute(Y_DIM, root));
        myGameMap = new GameMap(x_dim, y_dim);

        NodeList tiles = root.getElementsByTagName(TILE);
        
        for(int i = 0; i < tiles.getLength(); i++) {
            processTile((Element)tiles.item(i));
        }
        return myGameMap;
    }
    
    
    private Tile processTile(Element tile) {
        int x = Integer.parseInt(getAttribute(X_COORD, tile));
        int y = Integer.parseInt(getAttribute(Y_COORD, tile));
        
        //create a new Tile with x,y informaiton
        Tile resultTile = new Tile(x, y, myGameMap);
        
        //set attributes of tile(max_pop, passability).
        setStats(tile,resultTile);
        
        //set terrain to the tile
        Element terrain = (Element) tile.getElementsByTagName(TERRAIN).item(0);
        StatCollection targetTerr = (StatCollection) resultTile.getStatCollection(TERRAIN_TAG);
        setStats(terrain, targetTerr);
        
        // set resources to the tile
        Element elementResources = (Element) tile.getElementsByTagName(RESOURCES).item(0);
        Resources targetResources = (Resources) resultTile.getStatCollection(RESOURCES_TAG);
        processResources(elementResources,targetResources);
        
        //create tile 
        myGameMap.setTile(x, y, resultTile);
        
        //test use
        return resultTile;
    }
      
    private Resources processResources(Element resources, Resources target) {
        NodeList resourceList = resources.getElementsByTagName(RESOURCE);
        for(int i = 0; i < resourceList.getLength(); i++) {
            target.addResource(processResource((Element)resourceList.item(i)));
        }
        
        //test use
        return target;
    }
    
    public Resource processResource(Element resource) {
        String name = resource.getAttribute(NAME);
        Double amount = Double.parseDouble(resource.getAttribute(AMOUNT));
        Double harvestRate = Double.parseDouble(resource.getAttribute(HARVEST_RATE));
        return new Resource(name, amount, harvestRate);
    }
    
    @Override
    public void decodeData(Element root) {
        myDataManager.setGameMap(processGameMap(root));
    }

}
