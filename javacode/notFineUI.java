import javax.swing.*; 
import java.awt.*;
/**
 * 	it is one user interface of the GUI system
 */
public class notFineUI extends JFrame{
	
	JLabel label1 = null;
	JLabel label2 = null;
	JButton button1 = null;
	
	JPanel panel1 =null;
	JPanel panel2 =null;
	JPanel panel3 =null;
	
	public notFineUI() {
		label1 = new JLabel("You do not have fine!");
		label2 = new JLabel("Just go on borrowing!");
		button1 = new JButton("GO ON");
		
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
     	this.setTitle("Have no Fine");   
	    this.setSize(300,200);   
		this.setLocation(400, 200);   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(false); 
		this.setResizable(true); 
	}

}
