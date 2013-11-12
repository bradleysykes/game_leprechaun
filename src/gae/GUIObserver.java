package gae;

import java.util.ArrayList;
import java.util.List;

public class GUIObserver implements Observer{
	
	List<Observable> myObservable = new ArrayList<Observable>();
	
	@Override
	public void updatePanels() {
		
	}

	@Override
	public void setUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object o) {
		for(Observable ob:myObservable){
			ob.execute(o);
		}
	}

}
