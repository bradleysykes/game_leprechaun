package data.decoder;

import java.util.ArrayList;
import java.util.List;
import model.tile.Tile;
import model.unit.Unit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 * Decoder for unit objects
 * @author Seunghyun Lee
 *
 */
public class UnitDecoder extends Decoder {
    
    private DataManager myDataManager;
    private List<Unit> myUnits;
    
    public UnitDecoder(DataManager manager) {
        myDataManager = manager;
        myUnits = new ArrayList<Unit>();
    }
    
    private List<Unit> processUnits(Element unitRoot) {
        NodeList units = unitRoot.getElementsByTagName(UNIT);
        for(int i = 0; i < units.getLength(); i++) {
            myUnits.add(processSingleUnit((Element)units.item(i)));
        }
        return myUnits;
    }
    
    private Unit processSingleUnit(Element unit) {
        return null;
        
    }
    
    private void processAttributes() {
            
    }
    
    private Tile getUnitTile(int x, int y) {
        return myDataManager.getGameMap().getTile(x, y);
    }
    
    @Override
    public void decodeData (Element root) {
        myDataManager.setUnits(processUnits(root));
        
    }
}
