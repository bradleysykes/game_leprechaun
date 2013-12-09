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
    
    private void appendTileImages(Element imageMapElement) {
        Element tileImages = myXmlDocument.createElement(TILE_IMAGES);
        for(Tile tile : myTileImagesMap.keySet()) {
            appendSingleTileImage(tile, myTileImagesMap, tileImages);
        }
        imageMapElement.appendChild(tileImages);
    }
    
    private void appendSingleTileImage (Tile tile, Map<Tile, String> map, Element parent) {
        Element imageElement = myXmlDocument.createElement(IMAGE);
        imageElement.setAttribute(SRC,map.get(tile));
        tile.setStat(X_COORD, -1.0);
        tile.setStat(Y_COORD, -1.0);
        MapEncoder me = new MapEncoder(myXmlDocument, null, null);
        me.appendTile(tile, imageElement, true);
        parent.appendChild(imageElement);
    }
    
    private void appendUnitImages(Element imageMapElement) {
        Element unitImages = myXmlDocument.createElement(UNIT_IMAGES);
        for(Unit unit : myUnitImagesMap.keySet()) {
            appendSingleUnitImage(unit, myUnitImagesMap, unitImages);
        }
        imageMapElement.appendChild(unitImages);
    }

    private void appendSingleUnitImage(Unit unit, Map<Unit, String> map, Element parent) {
        Element imageElement = myXmlDocument.createElement(IMAGE);
        imageElement.setAttribute(SRC,map.get(unit));
        unit.getCurrentTile().setStat(X_COORD, -1.0);
        unit.getCurrentTile().setStat(Y_COORD, -1.0);
        UnitEncoder ue = new UnitEncoder(myXmlDocument, null, null);
        ue.appendSingleUnit(unit, imageElement, true);
        parent.appendChild(imageElement);
    }
    
    
    
}
