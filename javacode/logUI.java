

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
/**
 * 	it is one user interface of the GUI system
 */
public class logUI extends JFrame implements ActionListener { 
 

 JButton jb1,jb2,jb3=null; 
 JRadioButton jrb1,jrb2=null; 
 JPanel jp1,jp2,jp3,jp4=null; 
 JTextField jtf=null; 
 JLabel jlb1,jlb2,jlb3=null; 
 JPasswordField jpf=null; 
 ButtonGroup bg=null; 
 
 String user_num=""; 
 String adm_num=""; 
 

 
 public logUI() 
 { 

  jb1=new JButton("Login"); 
  jb2=new JButton("Reset"); 
  jb3=new JButton("Help");
 

  /*jb1.addActionListener(this); 
  jb2.addActionListener(this); 
  jb3.addActionListener(this); */
 
  jrb1=new JRadioButton("Administrator"); 
  jrb2=new JRadioButton("User"); 
  bg=new ButtonGroup(); 
  bg.add(jrb1); 
  bg.add(jrb2); 
  jrb2.setSelected(true); 
 
  jp1=new JPanel(); 
  jp2=new JPanel(); 
  jp3=new JPanel(); 
  jp4=new JPanel();     
 
  jlb1=new JLabel("QM number"); 
  //jlb2=new JLabel("Password"); 
  jlb3=new JLabel("Type"); 
 
  jtf=new JTextField(10); 
  //jpf=new JPasswordField(10); 

  jp1.add(jlb1); 
  jp1.add(jtf); 
 
  //jp2.add(jlb2); 
  //jp2.add(jpf); 
 
  jp3.add(jlb3);  
  jp3.add(jrb1); 
  jp3.add(jrb2); 
 
  jp4.add(jb1);  
  jp4.add(jb2); 
  jp4.add(jb3);
 

  this.add(jp1); 
  //this.add(jp2); 
  this.add(jp3); 
  this.add(jp4); 
 
  this.setLayout(new GridLayout(3,1));    
  this.setTitle("Scooter System");   
  this.setSize(300,200);   
  this.setLocation(400, 200);   
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  this.setVisible(true); 
  this.setResizable(true); 
 
 } 
 
/* public void actionPerformed(ActionEvent e) {   
 
  if(e.getActionCommand()=="Login") 
  { 
   
   if(jrb1.isSelected()) 
   { 
     tealogin();        
   }else if(jrb2.isSelected()) 
   { 
     stulogin();        
   } 
 
  }else if(e.getActionCommand()=="Reset") 
  { 
     clear(); 
  }else if(e.getActionCommand()=="Exit") 
  { 
      System.exit(0);  
  }     
 
 } */
 /*

 public void stulogin() 
 { 
  if(stu_name.equals(jtf.getText())&&stu_pwd.equals(jpf.getText())) 
  {   
   JOptionPane.showMessageDialog(null,"Login success","tip",JOptionPane.WARNING_MESSAGE);   
   dispose();  
   clear();   
   US ui=new US();
  }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty()) 
  { 
   JOptionPane.showMessageDialog(null,"Please input your number and password","tip",JOptionPane.WARNING_MESSAGE); 
  }else if(jtf.getText().isEmpty()) 
  { 
   JOptionPane.showMessageDialog(null,"Please input your number","tip",JOptionPane.WARNING_MESSAGE); 
  }else if(jpf.getText().isEmpty()) 
  { 
   JOptionPane.showMessageDialog(null,"Please input your Password","tip",JOptionPane.WARNING_MESSAGE); 
  }else
  { 
   JOptionPane.showMessageDialog(null,"Wrong","tip",JOptionPane.ERROR_MESSAGE); 
   
   clear(); 
  } 
 } 

 public void tealogin() 
 { 
  if(tea_name.equals(jtf.getText())&&tea_pwd.equals(jpf.getText())) 
  { 
 
    JOptionPane.showMessageDialog(null,"Login success","tip",JOptionPane.WARNING_MESSAGE); 
    clear();   
    dispose();    
    AD ui=new AD(); 
  }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty()) 
  { 
   JOptionPane.showMessageDialog(null,"Please input your number and password","tip",JOptionPane.WARNING_MESSAGE); 
  }else if(jtf.getText().isEmpty()) 
  { 
   JOptionPane.showMessageDialog(null,"Please input your number","tip",JOptionPane.WARNING_MESSAGE); 
  }else if(jpf.getText().isEmpty()) 
  { 
   JOptionPane.showMessageDialog(null,"Please input your Password","tip",JOptionPane.WARNING_MESSAGE); 
  }else
  { 
   JOptionPane.showMessageDialog(null,"Wrong","tip",JOptionPane.ERROR_MESSAGE); 
   clear(); 
  } 
 } */
 public void clear() 
 { 
  jtf.setText(""); 
  jpf.setText(""); 
 }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
} 
 
}