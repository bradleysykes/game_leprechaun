package data.encoder;

import java.util.List;
import model.Player;
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
        
        appendResources();
        appendUnits();
    }
    
    private void appendResources () {
        
    }

    private void appendUnits () {
        
    }



}
