package data.decoder;

import java.util.ArrayList;
import java.util.List;
import model.Player;
import model.Resources;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Player Decoder class is in charge of instantiating all the plyaer 
 * related objects.
 * 
 * @author Seunghyun Lee
 *
 */

public class PlayerDecoder extends Decoder {
    
    private DataManager myDataManager;
    private List<Player> myPlayers;
    
    public PlayerDecoder(DataManager manager) {
        myDataManager = manager;
        myPlayers = new ArrayList<Player>();
    }
    
    /**
     * 
     * @param root
     * @return
     */
    public List<Player> processPlayers(Element root) {
        Element players = (Element)root.getElementsByTagName(PLAYERS).item(0);
        NodeList playerList = players.getElementsByTagName(PLAYER);
        for(int i = 0; i < playerList.getLength(); i++) {
            myPlayers.add(getPlayer((Element) playerList.item(i)));
        }
        return myPlayers;
    }
    
    /**
     * This method instantiates a single player from the dom element.
     * @param player
     * @return
     */
    public Player getPlayer(Element player) {
        Player resultPlayer = new Player();
        //set ID of the player
        resultPlayer.setID(player.getAttribute(ID));
        
        // set resources to the tile
        Element elementResources = (Element) player.getElementsByTagName(RESOURCES).item(0);
        Resources targetResources = (Resources) resultPlayer.getStatCollection(RESOURCES);
        getResources(elementResources,targetResources);
        
        return resultPlayer;
    }
    
    @Override
    public void decodeData (Element root) {
        myDataManager.setPlayerList(processPlayers(root));
    }

}
