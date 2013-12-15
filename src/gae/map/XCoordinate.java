package gae.map;


public class XCoordinate extends AbstractCoordinate {
	
	public XCoordinate(int coordinate,GUIMap map){
		super(coordinate,map);
	}

	@Override
	public int getMapFactor() {
		return myMap.pfWidth();
	}

	@Override
	public int getOffset() {
		return myMap.getMouseX() * myMap.pfWidth() / myMap.viewWidth();
	}

}
