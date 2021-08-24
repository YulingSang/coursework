import javax.swing.*; 
import java.awt.*;
/**
 * 	it is one user interface of the GUI system
 */
public class fineUI extends JFrame {
	
	JLabel label1 = null;
	JLabel label2 = null;
	JLabel label3 = null;
	JButton button1 = null;
	JButton button2 =null;
	
	JPanel panel1 =null;
	JPanel panel2 =null;
	JPanel panel3 =null;
	JPanel panel4 =null;
	
	public fineUI() {
		label1 = new JLabel("You have fine that has not been paid off!");
		label2 = new JLabel("If you want to go on borrowing,");
		label3 = new JLabel("please click the button below!");
		button1 = new JButton("Pay the Fine");
		button2 = new JButton("Exit");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		panel4.add(button1);
		panel4.add(button2);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.setLayout(new GridLayout(4,1));    
     	this.setTitle("Have been Fined");   
	    this.setSize(300,200);   
		this.setLocation(400, 200);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(false); 
		this.setResizable(true); 
		
	}
}
