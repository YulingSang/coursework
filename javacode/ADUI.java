
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
/**
 * 	it is one user interface of the GUI system
 */
public class ADUI extends JFrame {
	JFrame myFrame;
	JPanel myPanel;
	JPanel myPanel2;
	JPanel myPanel3;
	JPanel myPanel4;
	
	JTextField myText;
	JLabel myLabel;
	JLabel myLabel2;
	JLabel myLabel3;
	JButton myButton;
	JButton myButton2;
	JButton myButton3;
	JButton myButton4;
	public int shu;
	public char Beiyou;
	public String shuru="";
	public ADUI(){
		myFrame= new JFrame();
		myFrame.setTitle("Scooter System");
		myPanel= new JPanel();
		myPanel2= new JPanel();
		myPanel3= new JPanel();
		myPanel4= new JPanel();
		myLabel= new JLabel("             Welcome to scooter system                ");
		myLabel2= new JLabel(" ");
		myButton = new JButton("      Check scooter station       ");
		//myButton.addActionListener(this);
		myButton2 = new JButton("                Check user              ");
		//myButton2.addActionListener(this);
		myButton3 = new JButton("BACK");
		//myButton3.addActionListener(this);
		myButton4 = new JButton("              Register User             ");

  myPanel.add(myLabel); 
 
  myPanel2.add(myButton);  

  myPanel2.add(myButton2);
  myPanel2.add(myButton4);
  myPanel3.add(myLabel2);
  myPanel3.add(myLabel2);
  myPanel3.add(myLabel2);
  myPanel3.add(myLabel2);
  myPanel3.add(myLabel2);
  myPanel3.add(myButton3);
  
  myFrame.add(myPanel); 
  myFrame.add(myPanel2); 
  myFrame.add(myPanel3); 
 
  myFrame.setLayout(new GridLayout(3,1));    
  myFrame.setTitle("Scooter System");   
  myFrame.setSize(300,450);   
  myFrame.setLocation(400, 200);   
  myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  myFrame.setVisible(false); 
  myFrame.setResizable(true); 
}
	public static void main(String[] args) { 
		ADUI borrowui =new ADUI(); 
	} 

}