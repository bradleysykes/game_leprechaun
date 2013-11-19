package data.decoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Player;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlayerDecoder extends Decoder {
    
    private DataManager myDataManager;
    private List<Player> myPlayers;
    
    public PlayerDecoder(DataManager manager) {
        myDataManager = manager;
        myPlayers = new ArrayList<Player>();
    }
    
    public void addPlayer() {
        
    }
    
    /**
     * This method creates the map that represents the resources for the player
     * and fills in with the data that is specified in the xml file.
     *  
     * @param element
     * @return
     */
    public Map<String,Double> getResources(Element element) {
        Map<String,Double> resultResource = new HashMap<String,Double>();
        NodeList resources = element.getElementsByTagName(RESOURCES);
        for(int i=0; i<resources.getLength(); i++) {
            Element resource = (Element) resources.item(i);
            String name = resource.getAttribute(NAME);
            Double value = Double.parseDouble(resource.getAttribute(VALUE));
            resultResource.put(name, value);
        }
        return resultResource;
    }
    
    @Override
    public void decodeData (Element root) {
        // TODO Auto-generated method stub
        
    }

}
