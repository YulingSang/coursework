import javax.swing.*; 
import java.awt.*;
/**
 * 	it is one user interface of the GUI system
 */
public class fullUI extends JFrame{
	JLabel label1= null;
	JLabel label2= null;
	JButton button1 = null;
	
	JPanel panel1=null;
	JPanel panel2=null;
	JPanel panel3=null;
	
	public fullUI() {
		label1 = new JLabel("Sorry! The station is full!");
		label2 = new JLabel("Please check other stations!");
		
		button1 = new JButton("Check");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(button1);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		this.setLayout(new GridLayout(3,1));    
     	this.setTitle("Conditions");   
	    this.setSize(300,200);   
		this.setLocation(400, 200);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(false); 
		this.setResizable(true); 
		
	}
	public static void main(String[] args) { 
		fullUI fullui =new fullUI(); 
	} 
	
}
