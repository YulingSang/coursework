import java.io.Serializable;
import java.util.ArrayList;

/**
 * the class is user
 * each user has qm number, name, email, whether is fined and borrowevents
 */
public class User implements Serializable {
	
	//constructor
	public User() {
		
	}
	public User(String QMnumber, String Name, String Email) {
		this.QMnumber=QMnumber;
		this.Name=Name;
		this.Email=Email;
		this.isFined=false;
		
		this.events = new ArrayList<borrowEvent>();
	}
	
	private String QMnumber;
	private String Name;
	private String Email;
	private boolean isFined;
	//usage
	ArrayList<borrowEvent> events = null;
	
	//default getter and setter
	public String getQMnumber() {
		return QMnumber;
	}
	public void setQMnumber(String qMnumber) {
		QMnumber = qMnumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public boolean isFined() {
		return isFined;
	}
	public void setFined(boolean isFined) {
		this.isFined = isFined;
	}
	
	
}

