package data.decoder;

import java.util.ArrayList;
import java.util.List;
import model.Condition;
import model.Player;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import util.reflection.Reflection;

/**
 * Condition Decoder class is in charge of instantiating all the condition 
 * objects. It uses the reflection in order to create the corresponding 
 * condition object.
 * 
 * @author Seunghyun Lee
 *
 */
public class ConditionDecoder extends Decoder {

    private DataManager myDataManager;
    private List<Condition> myConditions;
    
    public ConditionDecoder(DataManager manager) {
        myDataManager = manager;
        myConditions = new ArrayList<Condition>();
    }
    
    private void buildConditions(Element root) {
        Element conditions = (Element)root.getElementsByTagName(CONDITIONS).item(0);
        NodeList conditionList = conditions.getElementsByTagName(CONDITION);
        for (int i = 0; i < conditionList.getLength(); i ++) {
            String className = ((Element) conditionList.item(i)).getAttribute(NAME);
            String unitID = ((Element)conditionList.item(i)).getAttribute(UNIT_ID);
            String playerID = ((Element)conditionList.item(i)).getAttribute(PLAYER_ID);
            Player player = myDataManager.getPlayer(playerID);
            
            //user reflection to create the coressponding condition
            myConditions.add((Condition)Reflection.createInstance(className, unitID, player));
        }    
    }
    
    @Override
    public void buildObject (Element root) {
        buildConditions(root);
        myDataManager.setConditions(myConditions);
    }

}
