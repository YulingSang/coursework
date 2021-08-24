import javax.swing.*; 
import java.awt.*;
/**
 * 	it is one user interface of the GUI system
 */
public class BorRUI extends JFrame {
	JLabel label1 = null;
	JButton button1 = null;
	JButton button2 = null;
	
	JPanel panel1 =null;
	JPanel panel2 =null;
	JPanel panel3 =null;
	
	public BorRUI() {
		label1 = new JLabel("Please Choose to Borrow or Return");
		button1 = new JButton("Borrow");
		button2 = new JButton("Return");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		panel1.add(label1);
		panel2.add(button1);
		panel3.add(button2);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		this.setLayout(new GridLayout(3,1));    
     	this.setTitle("Have no Fine");   
	    this.setSize(300,200);   
		this.setLocation(400, 200);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(false); 
		this.setResizable(true); 
	}
	
	public static void main(String[] args) { 
		BorRUI borrui =new BorRUI(); 
	} 
	
}
