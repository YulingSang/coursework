import javax.swing.*; 
import java.awt.*;
/**
 * 	it is one user interface of the GUI system
 */
public class resultUI extends JFrame {
	JLabel label1;
	JLabel label2;
	
	JButton button1;
	JButton button2;
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	
	public resultUI() {
		label1 = new JLabel("The use time has been over! ");
		label2 = new JLabel("Please pay the fine!");
		
		button1 = new JButton("Pay");
		button2 = new JButton("Refuse");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(button1);
		panel3.add(button2);
		
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
		resultUI statusui =new resultUI(); 
	} 
}
