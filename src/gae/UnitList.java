package gae;

public class UnitList extends BoardList {
	
	
	public UnitList(){
		super();
		this.addNewItem(new ToyUnit());
	}
	@Override
	public String getListType() {
		// TODO Auto-generated method stub
		return "Unit";
	}

}
