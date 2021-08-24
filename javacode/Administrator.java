
import java.io.Serializable;
//import java.util.ArrayList;

/**
 * The class is administrator
 *
 */
public class Administrator implements Serializable {
	
	//constructor
	public Administrator() {
		
	}
	public Administrator(String QMnumber, String Name, String Email) {
		this.QMnumber=QMnumber;
		this.Name=Name;
		this.Email=Email;
		//this.isFined=false;
		
		
	}
	
	private String QMnumber;
	private String Name;
	private String Email;
	//private boolean isFined;
	//usage
	
	
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
	/*public boolean isFined() {
		return isFined;
	}
	public void setFined(boolean isFined) {
		this.isFined = isFined;
	}*/
	
	
}
