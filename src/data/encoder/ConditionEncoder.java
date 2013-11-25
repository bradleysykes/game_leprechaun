package data.encoder;

import java.util.List;
import model.Condition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConditionEncoder extends Encoder {

    private Document myXmlDocument;
    private List<Condition> myConditionsList;
    private Element myRoot;
    
    public ConditionEncoder (Document xmlDocument, List<Condition> conditionsList, Element root) {
        myXmlDocument = xmlDocument;
        myConditionsList = conditionsList;
        myRoot = root;
    }

    @Override
    protected void encode () {
        appendConditions(myConditionsList);
    }

    private void appendConditions (List<Condition> conditionsList) {
        Element conditionsElement = myXmlDocument.createElement(CONDITIONS);
        for(Condition condition : conditionsList) {
            appendSingleCondition(conditionsElement, condition);
        }
        myRoot.appendChild(conditionsElement);
    }

    private void appendSingleCondition (Element conditionsElement, Condition condition) {
        Element conditionElement = myXmlDocument.createElement(CONDITION);
        String className = condition.getClass().toString().replaceAll("class\\s+","");
        conditionElement.setAttribute(NAME, className);
        conditionElement.setAttribute(UNIT_ID, condition.getID());
        conditionElement.setAttribute(PLAYER_ID, condition.getPlayer().getID());        
        conditionsElement.appendChild(conditionElement);
    }
    

}
