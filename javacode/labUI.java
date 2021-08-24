import javax.swing.*; 
import java.awt.*;
import java.util.ArrayList;
/**
 * 	it is one user interface of the GUI system
 */
public class labUI extends JFrame{
	JLabel label1 =null;
	JLabel label2 =null;
	ArrayList<JButton> station1=null;
	JButton button1 = null;
	
	JPanel panel1=null;
	JPanel panel2=null;
	JPanel panel3=null;
	
	public labUI() {
		label1=new JLabel("The available scooter is shining:");
		label2=new JLabel("LAB");
		station1 = new ArrayList<JButton>();
		
		for(int i=1;i<9;i++) {
			JButton button = new JButton(i+"");
			button.setForeground(Color.GREEN);
			station1.add(button);
		}
		button1 = new JButton("Back");
		
		panel1 = new JPanel();
		panel1.add(label1);
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,9));
		panel2.add(label2);
		for(int i=0;i<8;i++) {
			panel2.add(station1.get(i));
		}
		
		panel3 = new JPanel();
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
		labUI labui =new labUI(); 
	} 
	
}