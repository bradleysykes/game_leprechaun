package data.decoder;

import model.GameMap;
import model.Resources;
import model.stats.StatCollection;
import model.tile.Tile;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Map Decoder class is in charge of instantiating all the game map 
 * related objects. It will load the objects back to the data manager
 * after it finishes to create the objects.
 * 
 * @author Seunghyun Lee
 *
 */
public class MapDecoder extends Decoder {
    
    private GameMap myGameMap;
    
    public MapDecoder (DataManager manager) {
        super(manager);
    }
    
    /**
     * This method instantiates the 'GameMap' Objects that
     * is filled with 'Tile' objects.
     * 
     * @param root
     * @return
     */
    private GameMap createGameMap(Element root) {
        Element map = (Element)root.getElementsByTagName(MAP).item(0);
      
        int x_dim = Integer.parseInt(getAttribute(X_DIM, map));
        int y_dim = Integer.parseInt(getAttribute(Y_DIM, map));
        myGameMap = new GameMap(x_dim, y_dim);

        NodeList tiles = root.getElementsByTagName(TILE);
        
        for(int i = 0; i < tiles.getLength(); i++) {
            createTile((Element)tiles.item(i), false);
        }
        return myGameMap;
    }
    
    /**
     * This method parses and instantiates Tile and other related objects.
     * 
     * @param tile
     * @return
     */
    public Tile createTile(Element tile, boolean isTypeElement) {
        String id = getAttribute(ID, tile);
        int x = Integer.parseInt(getAttribute(X_COORD, tile));
        int y = Integer.parseInt(getAttribute(Y_COORD, tile));
        
        //create a new Tile with x,y informaiton
        Tile resultTile = new Tile(x, y, myGameMap);
        resultTile.setID(id);
        
        //set attributes of tile(max_pop, passability).
        setStats(tile,resultTile);
        
        //set terrain to the tile
        Element terrain = (Element) tile.getElementsByTagName(TERRAIN).item(0);
        StatCollection targetTerr = (StatCollection) resultTile.getStatCollection(TERRAIN);
        targetTerr.setID(terrain.getAttribute(ID));
        setStats(terrain, targetTerr);
        
        // set resources to the tile
        Element elementResources = (Element) tile.getElementsByTagName(RESOURCES).item(0);
        Resources targetResources = (Resources) resultTile.getStatCollection(RESOURCES);
        createResources(elementResources,targetResources);
        
        //create tile
        if(!isTypeElement) {
            myGameMap.setTile(x, y, resultTile);
        }

        //test use
        return resultTile;
    }
          
    @Override
    public void buildObject(Element root) {
        myDataManager.setGameMap(createGameMap(root));
    }

}
