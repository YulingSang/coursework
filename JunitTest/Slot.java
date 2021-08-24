import java.io.Serializable;

public class Slot implements Serializable{
	
	public Slot(String name) {
		this.setName(name);
		this.setBorrowed(false);
	}
	
	private String name;
	
	private boolean isBorrowed ;
	
	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
