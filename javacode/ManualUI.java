
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import java.lang.Math;
import java.io.*;
/**
 * 	it is one user interface of the GUI system
 */
public class ManualUI extends JFrame{
	JFrame myFrame;
	JPanel myPanel;
	JPanel myPanel2;
	JPanel myPanel3;
	JPanel myPanel4;
	JPanel myPanel5;
	JPanel myPanel6;
	JPanel myPanel7;
	JPanel myPanel8;
	JPanel myPanel9;
	JLabel myLabel;
	JLabel myLabel2;
	JLabel myLabel3;
	JLabel myLabel4;
	JLabel myLabel5;
	JLabel myLabel6;
	JLabel myLabel7;
	JLabel myLabel8;
	JButton myButton;
	public ManualUI(){
		myFrame= new JFrame();
		myFrame.setTitle("Scooter System");
		myPanel= new JPanel();
		myPanel2= new JPanel();
		myPanel3= new JPanel();
		myPanel4= new JPanel();
		myPanel5= new JPanel();
		myPanel6= new JPanel();
		myPanel7= new JPanel();
		myPanel8= new JPanel();
		myPanel9= new JPanel();
		myLabel= new JLabel("User Manual");
		myLabel2= new JLabel("<html><p>1.Log in: Write your QM number on the Textfeild(QM number is nine).</p><p>          Press the button Login:</p><p>          (1) If you have regested,log in successfully.</p><p>          (2) If you havn't regested, show a tip.</p></html>");
		myLabel3= new JLabel("<html><p>2.Pay: If you are not fined during last using, it will show your condition.</p><p>       If you are fined, it will ask you to pay for it.</p<p>       Press the button Go on:Come into the system.</p><p>       Press the button Pay:Pay for it.</p></html>");
	
	     myLabel5= new JLabel("<html><p>3.Check: (1) There are three station.Each station has eight location.</p><p>         (2)Green represent the scooter are available.></p><p>         (3)Red represent the location are free, and you can retun your scooter.</p></html>");
		myLabel6= new JLabel("<html><p>4.Borrow: Press the button check station to check available scooters.</p><p>There are three buttons represent different station.</p><p>You can choose where to borrow scooter.</p><p>After choose,the system help you to choose scooter </p><p>you have 1 minute to take away scooter.</p></html>");

		myLabel8= new JLabel("<html><p>5.Return: (1)You can first press the button check station to check</p><p>where are free to return.</p><p>(2)There are three buttons represnt different station.You can</p><p>choose where to return scooter.</p><p>(3)If you break the time limit, you will receive a warning.</p></html>");
		myButton = new JButton("BACK");
		//myButton.addActionListener(this);
		myPanel.add(myLabel); 
		myPanel2.add(myLabel2);  
		myPanel3.add(myLabel3);  
	
		myPanel5.add(myLabel5);  
		myPanel6.add(myLabel6);    
		myPanel8.add(myLabel8);
		myPanel9.add(myButton);
		myFrame.add(myPanel); 
		myFrame.add(myPanel2); 
		myFrame.add(myPanel3); 
	
		myFrame.add(myPanel5); 		
		myFrame.add(myPanel6); 
		myFrame.add(myPanel8); 
		myFrame.add(myPanel9); 
		myFrame.setLayout(new GridLayout(8,0));    
		myFrame.setSize(500,900);   
		myFrame.setLocation(400, 100);   
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		myFrame.setVisible(false); 
		myFrame.setResizable(true); 
		}
	/*public void actionPerformed(ActionEvent event){
			if (event.getSource()==myButton){
			System.out.println("Back");
			
			}
	}*/
}
