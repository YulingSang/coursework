
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
import java.io.*;
/**
 * 	it is one user interface of the GUI system
 */	
public class ReUI extends JFrame implements ActionListener{
	JFrame myFrame;
	JPanel myPanel;
	JPanel myPanel2;
	JPanel myPanel3;
	JPanel myPanel4;
	JPanel myPanel5;
	JTextField myText;
	JLabel myLabel;
	JLabel myLabel2;
	JLabel myLabel3;
	JLabel myLabel4;
	JButton myButton;
	JButton myButton2;
	JButton myButton3;
	JTextField myText3;
	JTextField myText2; 
	String QMnumber;
	String Name;
	String Email;
	int x = 0 ;
	int QM;
	boolean match;
	public int shu;
	public char Beiyou;
	public String shuru="";
	public ReUI(){

		myFrame= new JFrame();
		myFrame.setTitle("Scooter System");
		myPanel= new JPanel();
		myPanel2= new JPanel();
		myPanel3= new JPanel();
		myPanel4= new JPanel();
		myPanel5= new JPanel();
		myLabel= new JLabel("Register step");
		//put userinformation here!!!!!!!!!!!
		myLabel2= new JLabel("QM number:");
		myLabel3= new JLabel("Name:     ");
		myLabel4= new JLabel("E-Mail:   ");
		myButton = new JButton("CONFIRM");
		myButton2 = new JButton("RESET");
		myButton3 = new JButton("BACK");
		//myButton.addActionListener(this);
		myButton2.addActionListener(this);
		//myButton3.addActionListener(this);
		myText = new JTextField(10); 
		myText2 = new JTextField(10);
		myText3 = new JTextField(10); 
  myPanel.add(myLabel); 
 
  myPanel2.add(myLabel2);  
  myPanel2.add(myText);
  myPanel3.add(myLabel3);
  myPanel3.add(myText2);
  myPanel4.add(myLabel4);
  myPanel4.add(myText3);
  myPanel5.add(myButton);  
    myPanel5.add(myButton2); 
      myPanel5.add(myButton3); 
  myFrame.add(myPanel); 
  myFrame.add(myPanel2); 
  myFrame.add(myPanel3); 
  myFrame.add(myPanel4); 
  myFrame.add(myPanel5);   
  myFrame.setLayout(new GridLayout(5,1));    
  myFrame.setTitle("Scooter System");   
  myFrame.setSize(300,450);   
  myFrame.setLocation(400, 200);   
  myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  myFrame.setVisible(false); 
  myFrame.setResizable(true); 
		}
	public void actionPerformed(ActionEvent event){
			x=0;
			if (event.getSource()==myButton2){
				clear();
			}
			/*if (event.getSource()==myButton){
			QMnumber = myText.getText();
			Name = myText2.getText();
			Email = myText3.getText();
			String reg = "\\w+@\\w+(\\.[a-zA-Z]+)+";
			match = Email.matches(reg);
			System.out.println(QMnumber+"*");
			System.out.println(Name+"*");
			System.out.println(Email+"*");
			if (QMnumber.equals("")){
			System.out.println("Your input QMnumber is null");
			  JOptionPane.showMessageDialog(null,"Please input your QMnumber.","tip",JOptionPane.WARNING_MESSAGE); 

			}else{
			try{
   			  QM = Integer.parseInt(QMnumber);
			  }catch(NumberFormatException e)
			  {
			 System.out.println("Your input QMnumber is not number");
			  JOptionPane.showMessageDialog(null,"Your QMnumber is invalid.","tip",JOptionPane.WARNING_MESSAGE); 
				x=1;
			}
			if (x==0&&(QM>999999999||QM<100000000)) {
			  JOptionPane.showMessageDialog(null,"Your QMnumber should have 9 numbers.","tip",JOptionPane.WARNING_MESSAGE); 
			  }else if ((x == 0)&&(Name.equals(""))){
			  	JOptionPane.showMessageDialog(null,"Please input your Name.","tip",JOptionPane.WARNING_MESSAGE);
			  }
			  else if ((x == 0)&&(Email.equals(""))){
			  	JOptionPane.showMessageDialog(null,"Please input your Email.","tip",JOptionPane.WARNING_MESSAGE);
			  }else if ((x == 0)&&(!match)){
				JOptionPane.showMessageDialog(null,"Your Email format is invalid.","tip",JOptionPane.WARNING_MESSAGE); 
			}else if (x == 0){
			System.out.println("CONFIRM");
			//OI
			
			
			//jiaqitayemian
			}
			}
			}
			*/
			/*if (event.getSource()==myButton3){
			System.out.println("Back");
			//jiaqitayemian
			}*/
		}
	public void clear(){
			myText.setText(""); 
 			myText2.setText("");
			myText3.setText("");
			}
	public static void main(String[] args) { 
		ReUI borrowui =new ReUI(); 
	} 
		}
	
