package gae;

public class TileList extends BoardList {

	public TileList(){
		super();
		this.addNewItem(new ToyTile());
	}
	@Override
	public String getListType() {
		// TODO Auto-generated method stub
		return "Tiles";
	}

}
