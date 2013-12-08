package model;

import java.util.ArrayList;
import java.util.List;

import model.stats.Stat;
import model.stats.StatCollection;

public class Effects extends StatCollection{

	public Effects() {
		super("Effects");
	}
	
	public Effects(Effects e){
		this();
		for(Effect effect : e.getEffects())
			this.addEffect(effect);
	}
	
	public void addEffect(Effect effect){
		this.addStat(effect);
	}

	public void removeEffect(Effect Effect) {
		this.removeStat(Effect);
	}
	
	public List<Effect> getEffects(){
		List<Effect> toReturn = new ArrayList<Effect>();
		for(Stat s : this.getStats())
			toReturn.add((Effect) s);
		return toReturn;	
	}

}
