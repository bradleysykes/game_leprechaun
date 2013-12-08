package gae.dialogues;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import gae.ViewItemField;
import gae.buttons.SaveInputButton;
import gae.dialogues.InputDialogue.GetDataAction;
import gae.panel_lists.BoardList;
import gae.panel_lists.NullBoardList;
import gae.viewitems.PlayerViewItem;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;
import model.stats.Stat;
import model.stats.StatCollection;

public class EditPlayerDialogue extends InputDialogue {
	private ViewItemField myName;
	private JButton myEnterButton;
	private PlayerViewItem myViewItem;

	public EditPlayerDialogue(Player p, PlayerViewItem pvi, BoardList list) {
		super(p.getStats(), list);
		myViewItem = pvi;
		
	}

	@Override
	public JPanel createGutsPanel() {
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
			for(Stat t:myProperties){
				if(t.getValue()!=null){
					ViewItemField fieldView = new ViewItemField(t);
					mainPanel.add(fieldView);
					myFieldViews.put(t,fieldView);
				}
				else{
					StatCollection test = (StatCollection) t;
					myFieldViews.put(test,new ViewItemField(t));
					SaveInputButton button = new SaveInputButton(test,myList);
					mainPanel.add(button);
				}
			}
			myName = new ViewItemField("Custom name");
			mainPanel.add(myName);
			myEnterButton = new JButton("Create");
			myEnterButton.addActionListener(new GetDataAction());
			mainPanel.add(myEnterButton);
			return mainPanel;
	}

	@Override
	public void postInput() {
		List<Stat> inputData = new ArrayList<Stat>();
		for(Stat stat:myFieldViews.keySet()){
			String data = myFieldViews.get(stat).getData();
			stat.setValue(Double.parseDouble(data));
			inputData.add(stat);
		}
		String name = myName.getData();
		myViewItem.setName(name);
		myList.postEditInput(inputData, name, null);
		disposeDialogue();
	}

}
