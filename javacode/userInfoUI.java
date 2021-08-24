import javax.swing.*; 
import java.awt.*;
/**
 * 	it is one user interface of the GUI system
 */
public class userInfoUI extends JFrame{
	JButton button1;
	JButton button2;
	JLabel text1;
	
	JPanel panel1,panel2;
	
	public userInfoUI() {
		button1 = new JButton("Back");
		button2 = new JButton("Send E-mail");
		text1 = new JLabel();
		text1.setText("information");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		panel1.add(text1);
		panel2.add(button2);
		panel2.add(button1);
		
		this.add(panel1);
		this.add(panel2);
		this.setLayout(new GridLayout(2,1));   
		
		this.setSize(500,300);   
		this.setLocation(400, 200);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(false); 
		this.setResizable(true); 
	}
	public static void main(String[] args) { 
		userInfoUI ui =new userInfoUI(); 
		//String t = "<html><p>QMNumber</p><p>Name</p>";
		//System.out.print(t);
		//ui.text1.setText(t);
		
	} 
}
