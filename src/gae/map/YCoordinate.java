package gae.map;


public class YCoordinate extends AbstractCoordinate {

	protected YCoordinate(int coordinate, GUIMap map) {
		super(coordinate, map);
	}

	@Override
	public int getMapFactor() {
		return myMap.pfHeight();
	}

	@Override
	public int getOffset() {
		return myMap.getMouseY() * myMap.pfHeight()/ myMap.viewHeight();
	}

}
