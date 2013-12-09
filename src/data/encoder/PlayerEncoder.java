package data.encoder;

import java.util.List;
import model.Player;
import model.Resource;
import model.Resources;
import model.stats.Stat;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PlayerEncoder extends Encoder {

    List<Player> myPlayerList;
    private Document myXmlDocument;
    private Element myRoot;
    
    public PlayerEncoder(Document xmlDocument, List<Player> playerList, Element root) {
        myXmlDocument = xmlDocument;
        myPlayerList = playerList; 
        myRoot = root;
    }
    
    @Override
    public void encode () {
        appendPlayers(myPlayerList);
    }

    private void appendPlayers (List<Player> myPlayerList2) {
        Element playersElement = myXmlDocument.createElement(PLAYERS);
        for(Player player : myPlayerList) {
            appendSinglePlayer(player, playersElement);
        }
        myRoot.appendChild(playersElement);
    }

    private void appendSinglePlayer (Player player, Element playersRoot) {
        Element playerElement = myXmlDocument.createElement(PLAYER);
        playerElement.setAttribute(ID, player.getID());
        playersRoot.appendChild(playerElement);
        
        appendResources((Resources) player.getStat(RESOURCES), playerElement);
    }
    
    protected void appendResources (Resources resources, Element playerElement) {
        Element resourcesElement = myXmlDocument.createElement(RESOURCES);
        for(Stat resource : resources.getStats()) {
            Resource res = (Resource) resource;
            Element resElement = myXmlDocument.createElement(RESOURCE);
            resElement.setAttribute(NAME, res.getID());
            for(Stat stat : res.getStats()) {
                resElement.setAttribute(stat.getName().toLowerCase().replaceAll("\\s+","_"), 
                                        String.valueOf(stat.getValue()).replaceAll("\\b0.0\\b", "-1.0"));
            }
            resourcesElement.appendChild(resElement);
        }
        playerElement.appendChild(resourcesElement);
    }

}
