package gae.dialogues;

import gae.viewitems.BoardListViewItem;

import java.util.ArrayList;
import java.util.List;

import model.stats.Stat;

public class EditDialogue extends UnitCreationDialogue {

	public EditDialogue(String name, List<Stat> model,BoardListViewItem itemSource) {
		super(name, model, itemSource);
		
	}
	
	@Override
	public void postInput() {
		// look through all fields and gather information
		List<Stat> inputData = new ArrayList<Stat>();
		for(Stat stat:myFieldViews.keySet()){
			String data = myFieldViews.get(stat).getData();
			stat.setValue(Double.parseDouble(data));
			inputData.add(stat);
		}
		String name = myName.getData();
		myList.postEditInput(inputData, name, myImage);
		disposeDialogue();
	}
}
