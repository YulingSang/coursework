import javax.swing.*; 
import java.awt.*;
/**
 * 	it is one user interface of the GUI system
 */
public class borrowUI extends JFrame{
	JLabel label1= null;
	JLabel label2= null;
	
	JButton button1 = null;
	JButton button2 = null;
	JButton button3 = null;
	JButton button4 = null;
	JButton button5 = null;
	
	JPanel panel1 =null;
	JPanel panel2 =null;
	JPanel panel3 =null;	
	JPanel panel4 =null;
	JPanel panel5 =null;
	JPanel panel6 =null;
	JPanel panel7 =null;
	
	public borrowUI() {
		label1 = new JLabel("Please choose the station!");
		label2 = new JLabel("Check the Condition of all stations!");
		button1 = new JButton("Library");
		button2 = new JButton("Laboratories");
		button3 = new JButton("Village Shop");
		button4 = new JButton("Check Condition");
		button5 = new JButton("Back");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		
		panel1.add(label1);
		panel2.add(button1);
		panel3.add(button2);
		panel4.add(button3);
		panel5.add(label2);
		panel6.add(button4);
		
		panel7.add(button5);
		
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);
		this.add(panel7);
		
		this.setLayout(new GridLayout(7,1));    
     	this.setTitle("Borrow");   
	    this.setSize(300,300);   
		this.setLocation(400, 200);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(false); 
		this.setResizable(true); 
	}
	public static void main(String[] args) { 
		borrowUI borrowui =new borrowUI(); 
	} 
}
