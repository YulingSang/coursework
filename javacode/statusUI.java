import javax.swing.*; 
import java.awt.*;
import java.util.ArrayList;
/**
 * 	it is one user interface of the GUI system
 */
public class statusUI extends JFrame{
	JLabel label1 =null;
	JLabel label2 =null;
	JLabel label3 =null;
	JLabel label4 =null;
	
	ArrayList<JButton> station1=null;
	ArrayList<JButton> station2=null;
	ArrayList<JButton> station3=null;
	

	
	JButton button1 = null;
	
	
	
	JPanel panel1=null;
	JPanel panel2=null;
	JPanel panel3=null;

	
	
	public statusUI() {
		
		label1=new JLabel("The conditions of stations:");
		label2=new JLabel("LIB");
		label3=new JLabel("LAB");
		label4=new JLabel("SHP");
		
		station1 = new ArrayList<JButton>();
		station2 = new ArrayList<JButton>();
		station3 = new ArrayList<JButton>();
		
		for(int i=1;i<9;i++) {
			JButton button = new JButton(i+"");
			button.setForeground(Color.GREEN);
			station1.add(button);
		}
		for(int i=1;i<9;i++) {
			JButton button = new JButton(i+"");
			button.setForeground(Color.GREEN);
			station2.add(button);
		}
		for(int i=1;i<9;i++) {
			JButton button = new JButton(i+"");
			button.setForeground(Color.GREEN);
			station3.add(button);
		}
		

		button1 = new JButton("Back");
		
		panel1 = new JPanel();
		panel1.add(label1);
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,9));
		panel2.add(label2);
		for(int i=0;i<8;i++) {
			panel2.add(station1.get(i));
		}
		panel2.add(label3);
		for(int i=0;i<8;i++) {
			panel2.add(station2.get(i));
		}
		panel2.add(label4);
		for(int i=0;i<8;i++) {
			panel2.add(station3.get(i));
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
		statusUI statusui =new statusUI(); 
	} 
}
