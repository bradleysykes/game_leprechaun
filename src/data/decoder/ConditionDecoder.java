package data.decoder;

import java.util.ArrayList;
import java.util.List;
import model.Condition;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ConditionDecoder extends Decoder {

    private DataManager myDataManager;
    private List<Condition> myConditions;
    
    public ConditionDecoder(DataManager manager) {
        myDataManager = manager;
        myConditions = new ArrayList<Condition>();
    }
    
    private processConditions(Element root) {
        Element conditions = (Element)root.getElementsByTagName(CONDITIONS).item(0);
        NodeList conditionList = conditions.getElementsByTagName(CONDITION);

        

    }
    
    private Condition getCondition(Element condition) {
        
        
    }
    
    @Override
    public void decodeData (Element root) {
        
    }

}
