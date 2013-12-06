package data.encoder;

import java.util.Map;
import model.tile.Tile;
import model.unit.Unit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ImageEncoder extends Encoder {

    Document myXmlDocument;
    Map<Tile, String> myTileImagesMap;
    Map<Unit, String> myUnitImagesMap;
    Element myRoot;
    
    public ImageEncoder(Document xmlDocument, Map<Tile, String> tileImagesMap, 
                        Map<Unit, String> unitImagesMap, Element root) {
        myXmlDocument = xmlDocument;
        myTileImagesMap = tileImagesMap;
        myUnitImagesMap = unitImagesMap;
        myRoot = root;
    }
    
    @Override
    protected void encode () {
        appendImages();
    }

    private void appendImages () {
        Element imageMapElement = myXmlDocument.createElement(IMAGE_MAP);
        appendTileImages(imageMapElement);
        appendUnitImages(imageMapElement);
        myRoot.appendChild(imageMapElement);
    }
    
    private void appendUnitImages(Element imageMapElement) {
        Element unitImages = myXmlDocument.createElement(UNIT_IMAGES);
        for(Unit unit : myUnitImagesMap.keySet()) {
            appendSingleUnitImage(unit.getID(), myUnitImagesMap, unitImages);
        }
        imageMapElement.appendChild(unitImages);
    }
    
    private void appendTileImages(Element imageMapElement) {
        Element tileImages = myXmlDocument.createElement(TILE_IMAGES);
        for(Tile tile : myTileImagesMap.keySet()) {
            appendSingleTileImage(tile.getID(), myTileImagesMap, tileImages);
        }
        imageMapElement.appendChild(tileImages);
    }
    
    private void appendSingleTileImage (String id, Map<Tile, String> map, Element parent) {
        Element imageElement = myXmlDocument.createElement(IMAGE);
        imageElement.setAttribute(ID,id);
        imageElement.setAttribute(SRC,map.get(id));
        parent.appendChild(imageElement);
    }
    
    private void appendSingleUnitImage(String id, Map<Unit, String> map, Element parent) {
        Element imageElement = myXmlDocument.createElement(IMAGE);
        imageElement.setAttribute(ID,id);
        imageElement.setAttribute(SRC,map.get(id));
        parent.appendChild(imageElement);
    }
    
    
    
}
