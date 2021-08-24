import java.util.*;
import java.io.*;

public class Station implements Serializable {
	
	private String name;
	public ArrayList<Slot> slots =null;
	
	public Station(String name) {
		this.setName(name);
		slots = new ArrayList<Slot>();
		//addSlot(slots);
		int i = 0;
		for (i=0;i<8;i++) {
			Slot slot = new Slot("Slot"+i);
			slots.add(slot);
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addSlot(ArrayList<Slot> slots) {
		int i = 0;
		for (i=0;i<8;i++) {
			Slot slot = new Slot("Slot"+i);
			slots.add(slot);
		}
	}
	
}
