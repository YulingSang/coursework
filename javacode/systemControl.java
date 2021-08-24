import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class is the main control class
 * all the GUI is generated here
 * and all functions are realized here
 */
public class systemControl {
	/**
	 * To record whether is a user or an administrator log in, 0 for user and 1 for administrator
	 */
	public int UorA;//0 for user and 1 for administrator
	/**To record the log in user*/
	public User userLogin;
	/**To record the log in administrator*/
	public Administrator administratorLogin;
	/**To record the qm number the user enter in the GUI*/
	public String qmID; 
	/**An arraylist to store all the users*/
	public ArrayList<User> users = null;
	/**An arraylist to store all the administrators*/
	public ArrayList<Administrator> administrators= null;
	/**An arraylist to store all the stations*/
	public ArrayList<Station> stations =null;
	//stations.get(0).slots.get(0).isBorrowed()==>statusAdminUI.station1.get(0).setForegroud(Color.red)
	/**Generate a random number to select an available scooter randomly*/
	public int randomNum;
	//GUIs
	public logUI logui;
	public fineUI fineui;
	public notFineUI notfineui;
	public BorRUI borrui;
	public borrowUI borrowui;
	public statusUI statusui;
	public libUI libui;
	public labUI labui;
	public shopUI shopui;
	public returnUI returnui;
	public resultUI resultui;
	public fullUI fullui;
	public ADUI adui;
	public statusAdminUI statusadminui;
	public ReUI reui;
	public userInfoUI userinfoui;
	public ManualUI manualui;
	
	/**To record the date of nowtime*/
	public Calendar today;
	/**To record the 00:00:00 of today*/
	public Calendar dayStart;
	/**To record the 23:59:59 of today*/
	public Calendar dayEnd;
	/**To record the 00:00:00 of Monday of today's week*/
	public Calendar weekStart;
	/**To record the 23:59:59 of Sunday of today's week*/
	public Calendar weekEnd;
	
	/**
	 * constructor
	 * generate all the GUI and add relative actionlisteners
	 * initialize all the local variables
	 */
	public systemControl() {
		UorA = 0;
		
		logui = new logUI();
		fineui = new fineUI();
		notfineui = new notFineUI();
		borrui = new BorRUI();
		borrowui = new borrowUI();
		statusui = new statusUI();
		libui = new libUI();
		labui = new labUI();
		shopui = new shopUI();
		returnui= new returnUI();
		resultui = new resultUI();
		fullui = new fullUI();
		adui = new ADUI();
		statusadminui = new statusAdminUI();
		reui = new ReUI();
		userinfoui= new userInfoUI();
		manualui= new ManualUI(); 
		
		
		logui.jb1.addActionListener(new loginListener());
		logui.jb2.addActionListener(new resetLoginListener());
		logui.jb3.addActionListener(new helpListener());
		
		fineui.button1.addActionListener(new payFineListener());
		
		notfineui.button1.addActionListener(new goonListener());
		
		borrui.button1.addActionListener(new borrowListener());
		borrui.button2.addActionListener(new returnListener());
		
		borrowui.button1.addActionListener(new libListener());
		borrowui.button2.addActionListener(new labListener());
		borrowui.button3.addActionListener(new shopListener());
		borrowui.button4.addActionListener(new checkConditionListener());
		borrowui.button5.addActionListener(new borrowBackListener());
		
		returnui.button1.addActionListener(new libReturnListener());
		returnui.button2.addActionListener(new labReturnListener());
		returnui.button3.addActionListener(new shopReturnListener());
		returnui.button4.addActionListener(new checkConditionListener());
		returnui.button5.addActionListener(new returnBackListener());
		
		
		libui.button1.addActionListener(new libBackListener());
		for(int i=0;i<8;i++) {
			libui.station1.get(i).addActionListener(new libConfirmListener());
		}
		labui.button1.addActionListener(new labBackListener());
		for(int i=0;i<8;i++) {
			labui.station1.get(i).addActionListener(new labConfirmListener());
		}
		shopui.button1.addActionListener(new shopBackListener());
		for(int i=0;i<8;i++) {
			shopui.station1.get(i).addActionListener(new shopConfirmListener());
		}
		
		statusui.button1.addActionListener(new statusBackListener());
		
		adui.myButton.addActionListener(new adminCheckConditionListener());
		adui.myButton2.addActionListener(new adminCheckUserListener());
		adui.myButton3.addActionListener(new aduiBackListener());
		adui.myButton4.addActionListener(new registerUserListener());
		
		statusadminui.button1.addActionListener(new statusadminiBackListener());
		
		reui.myButton.addActionListener(new registerUserConfirmListener());
		reui.myButton3.addActionListener(new registerUserBackListener());
		
		userinfoui.button1.addActionListener(new checkUserInfoBackListener());
		userinfoui.button2.addActionListener(new sendEmailListener());
		
		manualui.myButton.addActionListener(new helpBackListener());
		
		today=Calendar.getInstance();//today's date
		
		dayStart=Calendar.getInstance();
		dayStart.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE), 0, 0, 0);
		
		dayEnd=Calendar.getInstance();
		dayEnd.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE), 23, 59, 59);
		
		weekStart=Calendar.getInstance();//Monday
		int day_of_week = weekStart.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		weekStart.add(Calendar.DATE, -day_of_week + 1);
		weekStart.set(Calendar.HOUR_OF_DAY,0);
		weekStart.set(Calendar.MINUTE,0);
		weekStart.set(Calendar.SECOND,0);
		
		weekEnd=Calendar.getInstance();//Sunday
		day_of_week = weekEnd.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		weekEnd.add(Calendar.DATE, -day_of_week + 7);
		weekEnd.set(Calendar.HOUR_OF_DAY,23);
		weekEnd.set(Calendar.MINUTE,59);
		weekEnd.set(Calendar.SECOND,59);
	}
	
	
	
	/**Create a new user and add this one to the arraylist*/
	public void addUser(String QMnumber, String Name, String Email) {
		User newUser = new User(QMnumber, Name, Email);
		users.add(newUser);
	}
	/**Create a new administrator and add this one to the arraylist*/
	public void addAdministrator(String QMnumber, String Name, String Email) {
		Administrator newAdministrator = new Administrator(QMnumber, Name, Email);
		administrators.add(newAdministrator);
	}
	
	/**get the arraylist users from user.txt*/
	public ArrayList<User> getUserFromFile() {
		ArrayList<User> temp=null;
	    File file =new File("user.txt");
	    FileInputStream in;
	    try {
	        in = new FileInputStream(file);
	        ObjectInputStream objIn=new ObjectInputStream(in);
	        temp=(ArrayList<User>)objIn.readObject();
	        objIn.close();
	        System.out.println("read object success!");
	    } catch (IOException e) {
	        System.out.println("read object failed");
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return temp;	
	}
	
	/**write the arraylist users to user.txt*/
	public void writeUserToFile(ArrayList<User> users) {
		 File file =new File("user.txt");
	     FileOutputStream out;
	        try {
	            out = new FileOutputStream(file);
	            ObjectOutputStream objOut=new ObjectOutputStream(out);
	            objOut.writeObject(users);
	            objOut.flush();
	            objOut.close();
	            System.out.println("write object success!");
	        } catch (IOException e) {
	            System.out.println("write object failed");
	            e.printStackTrace();
	        }
	}
	
	/**get the arraylist administrators from administrator.txt*/
	public ArrayList<Administrator> getAdministratorFromFile() {
		ArrayList<Administrator> temp=null;
	    File file =new File("administrator.txt");
	    FileInputStream in;
	    try {
	        in = new FileInputStream(file);
	        ObjectInputStream objIn=new ObjectInputStream(in);
	        temp=(ArrayList<Administrator>)objIn.readObject();
	        objIn.close();
	        System.out.println("read object success!");
	    } catch (IOException e) {
	        System.out.println("read object failed");
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return temp;	
	}
	
	/**write the arraylist administrators to administrator.txt*/
	public void writeAdministratorToFile(ArrayList<Administrator> administrators) {
		 File file =new File("Administrator.txt");
	     FileOutputStream out;
	        try {
	            out = new FileOutputStream(file);
	            ObjectOutputStream objOut=new ObjectOutputStream(out);
	            objOut.writeObject(administrators);
	            objOut.flush();
	            objOut.close();
	            System.out.println("write object success!");
	        } catch (IOException e) {
	            System.out.println("write object failed");
	            e.printStackTrace();
	        }
	}
	
	/**clear the user.txt file*/
	public void clearUserFile() {
		File file =new File("user.txt");
		try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("clear success");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**judge whether a user exceeds the 2-hour daily usage limit*/
	public void dayLimit(User user) {
		double sum = 0.0;
		for(int i=0;i<user.events.size();i++) {
			if (user.events.get(i).date.after(dayStart) && user.events.get(i).date.after(dayEnd)) {
				sum = sum + user.events.get(i).useTime;
			}
		}
		System.out.println(sum);
		if(sum<2) {
			System.out.println("The user doesn't exceed the limit");
		}else {
			user.setFined(true);
		}
	}
	
	//log in as a user
	//actionlistener in logui
	/**
	 *This is an inner class, an actionlistener in logUI
	 *Record the entered qm number and log in to user UI or administrator ui
	 */
	class loginListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			users = getUserFromFile();
			administrators = getAdministratorFromFile();
			
			qmID = logui.jtf.getText();
			//user login
			if(logui.jrb2.isSelected()) {
				UorA = 0;
				
				int i = 0;
				int j = 0;
				while(i<users.size()) {
					if(qmID.equals(users.get(i).getQMnumber())) {
						userLogin = users.get(i);
						j = 1;
					}
					//else
						//System.out.println("");
					i++;
				}
				if (j==1) {
					JOptionPane.showMessageDialog(null,"User Login Success","tip",JOptionPane.WARNING_MESSAGE);
					if(userLogin.isFined()==false) {
					logui.setVisible(false);
					notfineui.setVisible(true);
					}else {
						logui.setVisible(false);
						fineui.setVisible(true);
					}
				}else
					JOptionPane.showMessageDialog(null,"You have not been registed","tip",JOptionPane.WARNING_MESSAGE);
				//the user login do not have fine
				//userLogin.setFined(true);
				
				
			}else if(logui.jrb1.isSelected()){   
					UorA = 1;
 					int m = 0;
 					int k = 0;
 					while(m<administrators.size()) {
 						if(qmID.equals(administrators.get(m).getQMnumber())) {
 							userLogin = users.get(m);
 							k = 1;
 						}
 						else
 							System.out.println("You have not been registed");
 						m++;
 					}
 					if (k==1) {
 						JOptionPane.showMessageDialog(null,"Administrator Login Success","tip",JOptionPane.WARNING_MESSAGE);
				
 						logui.setVisible(false);
 						adui.myFrame.setVisible(true);

 					}else
 						JOptionPane.showMessageDialog(null,"You have not been registed","tip",JOptionPane.WARNING_MESSAGE);
			}
			
		}	
		
	}
	/**
	 * This is an inner class, an actionlistener in logUI
	 * clear the entered numbers in QM number text
	 */
	class resetLoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			logui.jtf.setText("");
		}
	}
	/**
	 * This is an inner class, an actionlistener in logUI
	 * Show the users a manual how to use this system
	 */
	class helpListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//System.exit(0);
			logui.setVisible(false);
			manualui.myFrame.setVisible(true);
		}
	}
	//actionlistener in manualui
	/**
	 * This is an inner class, an actionlistener in manualUI
	 * Back to the login UI, the main UI
	 */
	class helpBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			logui.setVisible(true);
			manualui.myFrame.setVisible(false);
		}
		
	}
	
	//actionlistener in fineui
	/**
	 * This is an inner class, an actionlistener in fineUI
	 * if the user is fined, then he or she has to pay the fine to go on use
	 */
	class payFineListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			fineui.setVisible(false);
			userLogin.setFined(false);
			
			for(int i =0;i<users.size();i++) {
				if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
					users.get(i).events=userLogin.events;
					clearUserFile();
					writeUserToFile(users);
				}
			}
			
			notfineui.setVisible(true);
		}
		
	}
	
	//actionlistener in notfineui
	/**
	 * This is an inner class, an actionlistener in goonUI
	 * if the user is not fined, he or she can just go on borrowing or returning
	 */
	class goonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			notfineui.setVisible(false);
			borrui.setVisible(true);
			
			if(userLogin.events.isEmpty()==true) {
				borrui.button1.setEnabled(true);
				borrui.button2.setEnabled(false);
			}else if(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd()>0) {
				borrui.button1.setEnabled(true);
				borrui.button2.setEnabled(false);
			}else {
				borrui.button1.setEnabled(false);
				borrui.button2.setEnabled(true);
			}
		}	
	}
	
	//actionlistener in BorRui
	/**
	 * This is an inner class, an actionlistener in BorRUI
	 * let the user choose to borrow
	 * but they can only choose one of function according to the status of them
	 */	
	class borrowListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			borrui.setVisible(false);
			borrowui.setVisible(true);
		}
	}
	/**
	 * This is an inner class, an actionlistener in BorRUI
	 * let the user choose to return
	 * but they can only choose one of function according to the status of them
	 */	
	class returnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			borrui.setVisible(false);
			returnui.setVisible(true);
		}
	}
	
	//actionlistener in borrowui
	//start the 15s timer
	/**
	 * This is an inner class, an actionlistener in borrowUI
	 * let the user borrow or return in library station
	 */	
	class libListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int a;
			int b = 8;
			for(a=0; a<8; a++) {
				if(stations.get(0).slots.get(a).isBorrowed()==true)
					b--;
			}
			if(b!=0) {
				for(int i=0;i<8;i++) {
					libui.station1.get(i).setEnabled(true);
				}
				borrowui.setVisible(false);
				libui.setVisible(true);
				libtimer timer1 = new libtimer();
				timer1.start();
			}else {
				JOptionPane.showMessageDialog(null,"This station is empty","tip",JOptionPane.WARNING_MESSAGE);
			}
			
		}	
	}
	/**
	 * This is an inner class, an actionlistener in borrowUI
	 * let the user borrow or return in laboratory station
	 */	
	class labListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int a;
			int b = 8;
			for(a=0; a<8; a++) {
				if(stations.get(1).slots.get(a).isBorrowed()==true)
					b--;
			}
			if(b!=0) {
				for(int i=0;i<8;i++) {
					labui.station1.get(i).setEnabled(true);
				}
				borrowui.setVisible(false);
				labui.setVisible(true);
				labtimer timer1 = new labtimer();
				timer1.start();
			}else {
				JOptionPane.showMessageDialog(null,"This station is empty","tip",JOptionPane.WARNING_MESSAGE);
			}
		}	
	}
	/**
	 * This is an inner class, an actionlistener in borrowUI
	 * let the user borrow or return in shop station
	 */	
	class shopListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int a;
			int b = 8;
			for(a=0; a<8; a++) {
				if(stations.get(2).slots.get(a).isBorrowed()==true)
					b--;
			}
			if(b!=0) {
				for(int i=0;i<8;i++) {
					shopui.station1.get(i).setEnabled(true);
				}
				borrowui.setVisible(false);
				shopui.setVisible(true);
				shoptimer timer1 = new shoptimer();
				timer1.start();
			}else {
				JOptionPane.showMessageDialog(null,"This station is empty","tip",JOptionPane.WARNING_MESSAGE);
			}
			
		}	
	}
	/**
	 * This is an inner class, an actionlistener in borrowUI
	 * let the user check the conditions of all stations
	 */	
	class checkConditionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			borrowui.setVisible(false);
			returnui.setVisible(false);
			statusui.setVisible(true);
		}
		
	}
	/**
	 * This is an inner class, an actionlistener in borrowUI
	 * let the user return to the main login UI
	 */	
	class borrowBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			borrowui.setVisible(false);
			logui.setVisible(true);
		}
	}
	
	//actionlistener in libui
	/**
	 * This is an inner class, an actionlistener in libUI
	 * let the user return to the borrowUI
	 */	
	class libBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			libui.setVisible(false);
			borrowui.setVisible(true);
		}
	}
	/**
	 * This is an inner class, an actionlistener in libUI
	 * judge the condition of the user, determine the function is borrow or return
	 * show the available borrow or return slot, shining by 60 second
	 */	
	class libConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(userLogin.events.isEmpty()==true) {
				libui.station1.get(randomNum).setEnabled(false);
				stations.get(0).slots.get(randomNum).setBorrowed(true);
				statusui.station1.get(randomNum).setForeground(Color.RED);
			
				borrowEvent event = new borrowEvent(System.currentTimeMillis());
				userLogin.events.add(event);
				//System.out.println(userLogin.events.get(0).date.get(Calendar.YEAR));
				
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						clearUserFile();
						writeUserToFile(users);
					}
				}
				libui.setVisible(false);
				logui.setVisible(true);
				JOptionPane.showMessageDialog(null,"Borrow Success","tip",JOptionPane.WARNING_MESSAGE);
			}else if(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd()>0) {
				libui.station1.get(randomNum).setEnabled(false);
				stations.get(0).slots.get(randomNum).setBorrowed(true);
				statusui.station1.get(randomNum).setForeground(Color.RED);
			
				borrowEvent event = new borrowEvent(System.currentTimeMillis());
				userLogin.events.add(event);
				
				
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						clearUserFile();
						writeUserToFile(users);
					}
				}
			
				libui.setVisible(false);
				logui.setVisible(true);
				JOptionPane.showMessageDialog(null,"Borrow Success","tip",JOptionPane.WARNING_MESSAGE);
			}else {
				libui.station1.get(randomNum).setEnabled(false);
				stations.get(0).slots.get(randomNum).setBorrowed(false);
				statusui.station1.get(randomNum).setForeground(Color.GREEN);
				userLogin.events.get(userLogin.events.size()-1).setBorrowEnd(System.currentTimeMillis());
				userLogin.events.get(userLogin.events.size()-1).setuseTime();
				System.out.println(userLogin.events.get(userLogin.events.size()-1).getBorrowStart());
				System.out.println(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd());
				System.out.println(userLogin.events.get(userLogin.events.size()-1).useTime);
				if(userLogin.events.get(userLogin.events.size()-1).useTime<0.5) {
					JOptionPane.showMessageDialog(null,"Return Success","tip",JOptionPane.WARNING_MESSAGE);		
				}else {
					JOptionPane.showMessageDialog(null,"Return Success, but over time!","tip",JOptionPane.WARNING_MESSAGE);
					userLogin.setFined(true);
				}
				
				dayLimit(userLogin);
				
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						users.get(i).setFined(userLogin.isFined());
						clearUserFile();
						writeUserToFile(users);
					}
				}
				libui.setVisible(false);
				logui.setVisible(true);
				
				
				
			}
		}
	}
	/**
	 * This is an inner class, a thread in libUI
	 * let the available slot shining for 60s
	 * if the second is over 60, the slot will be locked again
	 */	
	class libtimer extends Thread{
		private long programStart = System.currentTimeMillis();  
		public int hour, minute, second;
		
		public void run() { 
			//randomly get an available slot
			randomNum = (int)(0+Math.random()*(8));
			System.out.println(randomNum); 
			while(stations.get(0).slots.get(randomNum).isBorrowed()==true) {
				randomNum = (int)(0+Math.random()*(8));
			}
			for(int j=0; j<8; j++) {
				if(j!=randomNum) {
					libui.station1.get(j).setEnabled(false);
				}
			}
			
			//60 seconds timer
	        while (second<59) {  
	               long elapsed = System.currentTimeMillis() - programStart;
	               System.out.println(format(elapsed));
	               if(second!=58) {
	            	   if(libui.station1.get(randomNum).getForeground()==Color.GREEN) {
		            	   libui.station1.get(randomNum).setForeground(Color.RED);
		               }else
		            	   libui.station1.get(randomNum).setForeground(Color.GREEN);
	               }else {
	            	   libui.station1.get(randomNum).setEnabled(false);
	            	   //JOptionPane.showMessageDialog(null,"Time out! Please borrow again!","tip",JOptionPane.WARNING_MESSAGE);
	            	   
	               }
	               //shining the selected slot
	               
	               
	            try {  
	                sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	                System.exit(1);  
	            }  
	        }
	    }  
	    
	    private String format(long elapsed) { 
	        //milli = (int) (elapsed % 1000);  
	        elapsed = elapsed / 1000;
	        second = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        minute = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        hour = (int) (elapsed % 60);  
	        return String.format("%02d:%02d:%02d", hour, minute, second);  
	    } 
	}
	
	//actionlistener in labui
	/**
	 * This is an inner class, an actionlistener in labUI
	 * let the user return to the borrowUI
	 */	
	class labBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			labui.setVisible(false);
			borrowui.setVisible(true);
		}
	}
	/**
	 * This is an inner class, an actionlistener in labUI
	 * judge the condition of the user, determine the function is borrow or return
	 * show the available borrow or return slot, shining by 60 second
	 */	
	class labConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(userLogin.events.isEmpty()==true) {
				labui.station1.get(randomNum).setEnabled(false);
				stations.get(1).slots.get(randomNum).setBorrowed(true);
				statusui.station2.get(randomNum).setForeground(Color.RED);
			
				borrowEvent event = new borrowEvent(System.currentTimeMillis());
				userLogin.events.add(event);
				
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						clearUserFile();
						writeUserToFile(users);
					}
				}
				labui.setVisible(false);
				logui.setVisible(true);
				JOptionPane.showMessageDialog(null,"Borrow Success","tip",JOptionPane.WARNING_MESSAGE);
			}else if(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd()>0) {
				labui.station1.get(randomNum).setEnabled(false);
				stations.get(1).slots.get(randomNum).setBorrowed(true);
				statusui.station2.get(randomNum).setForeground(Color.RED);
			
				borrowEvent event = new borrowEvent(System.currentTimeMillis());
				userLogin.events.add(event);
				
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						clearUserFile();
						writeUserToFile(users);
					}
				}
				labui.setVisible(false);
				logui.setVisible(true);
				JOptionPane.showMessageDialog(null,"Borrow Success","tip",JOptionPane.WARNING_MESSAGE);
			}else {
				labui.station1.get(randomNum).setEnabled(false);
				stations.get(1).slots.get(randomNum).setBorrowed(false);
				statusui.station2.get(randomNum).setForeground(Color.GREEN);
				userLogin.events.get(userLogin.events.size()-1).setBorrowEnd(System.currentTimeMillis());
				userLogin.events.get(userLogin.events.size()-1).setuseTime();
				System.out.println(userLogin.events.get(userLogin.events.size()-1).getBorrowStart());
				System.out.println(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd());
				System.out.println(userLogin.events.get(userLogin.events.size()-1).useTime);
				if(userLogin.events.get(userLogin.events.size()-1).useTime<0.5) {
					JOptionPane.showMessageDialog(null,"Return Success","tip",JOptionPane.WARNING_MESSAGE);		
				}else {
					JOptionPane.showMessageDialog(null,"Return Success, but over time!","tip",JOptionPane.WARNING_MESSAGE);
					userLogin.setFined(true);
				}
				
				dayLimit(userLogin);
				
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						users.get(i).setFined(userLogin.isFined());
						clearUserFile();
						writeUserToFile(users);
					}
				}
				labui.setVisible(false);
				logui.setVisible(true);
			}
			
		}
	}
	/**
	 * This is an inner class, a thread in labUI
	 * let the available slot shining for 60s
	 * if the second is over 60, the slot will be locked again
	 */	
	class labtimer extends Thread{
		private long programStart = System.currentTimeMillis();  
		public int hour, minute, second;
		
		public void run() { 
			//randomly get an available slot
			randomNum = (int)(0+Math.random()*(8));
			System.out.println(randomNum); 
			while(stations.get(1).slots.get(randomNum).isBorrowed()==true) {
				randomNum = (int)(0+Math.random()*(8));
			}
			for(int j=0; j<8; j++) {
				if(j!=randomNum) {
					labui.station1.get(j).setEnabled(false);
				}
			}
			
			//60 seconds timer
	        while (second<59) {  
	               long elapsed = System.currentTimeMillis() - programStart;
	               System.out.println(format(elapsed));
	  
	               //shining the selected slot
	               if(second!=58) {
	            	   if(labui.station1.get(randomNum).getForeground()==Color.GREEN) {
		            	   labui.station1.get(randomNum).setForeground(Color.RED);
		               }else
		            	   labui.station1.get(randomNum).setForeground(Color.GREEN);
	               }else {
	            	   labui.station1.get(randomNum).setEnabled(false);
	            	   //JOptionPane.showMessageDialog(null,"Time out! Please borrow again!","tip",JOptionPane.WARNING_MESSAGE);
	               }
	               
	               
	            try {  
	                sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	                System.exit(1);  
	            }  
	        }
	    }  
	      
	    private String format(long elapsed) { 
	        //milli = (int) (elapsed % 1000);  
	        elapsed = elapsed / 1000;
	        second = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        minute = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        hour = (int) (elapsed % 60);  
	        return String.format("%02d:%02d:%02d", hour, minute, second);  
	    } 
	}
	
	//actionlistener in shopui
	/**
	 * This is an inner class, an actionlistener in shopUI
	 * let the user return to the borrowUI
	 */	
	class shopBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			shopui.setVisible(false);
			borrowui.setVisible(true);
		}
	}
	/**
	 * This is an inner class, an actionlistener in shopUI
	 * judge the condition of the user, determine the function is borrow or return
	 * show the available borrow or return slot, shining by 60 second
	 */	
	class shopConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(userLogin.events.isEmpty()==true) {
				shopui.station1.get(randomNum).setEnabled(false);
				stations.get(2).slots.get(randomNum).setBorrowed(true);
				statusui.station3.get(randomNum).setForeground(Color.RED);
			
				borrowEvent event = new borrowEvent(System.currentTimeMillis());
				userLogin.events.add(event);
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						clearUserFile();
						writeUserToFile(users);
					}
				}
				shopui.setVisible(false);
				logui.setVisible(true);
				JOptionPane.showMessageDialog(null,"Borrow Success","tip",JOptionPane.WARNING_MESSAGE);
			}else if(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd()>0) {
				shopui.station1.get(randomNum).setEnabled(false);
				stations.get(2).slots.get(randomNum).setBorrowed(true);
				statusui.station3.get(randomNum).setForeground(Color.RED);
			
				borrowEvent event = new borrowEvent(System.currentTimeMillis());
				userLogin.events.add(event);
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						clearUserFile();
						writeUserToFile(users);
					}
				}
				shopui.setVisible(false);
				logui.setVisible(true);
				JOptionPane.showMessageDialog(null,"Borrow Success","tip",JOptionPane.WARNING_MESSAGE);
			}else {
				shopui.station1.get(randomNum).setEnabled(false);
				stations.get(2).slots.get(randomNum).setBorrowed(false);
				statusui.station3.get(randomNum).setForeground(Color.GREEN);
				userLogin.events.get(userLogin.events.size()-1).setBorrowEnd(System.currentTimeMillis());
				userLogin.events.get(userLogin.events.size()-1).setuseTime();
				System.out.println(userLogin.events.get(userLogin.events.size()-1).getBorrowStart());
				System.out.println(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd());
				System.out.println(userLogin.events.get(userLogin.events.size()-1).useTime);
				if(userLogin.events.get(userLogin.events.size()-1).useTime<0.5) {
					JOptionPane.showMessageDialog(null,"Return Success","tip",JOptionPane.WARNING_MESSAGE);		
				}else {
					JOptionPane.showMessageDialog(null,"Return Success, but over time!","tip",JOptionPane.WARNING_MESSAGE);
					userLogin.setFined(true);
				}
				
				dayLimit(userLogin);
				
				for(int i =0;i<users.size();i++) {
					if(users.get(i).getQMnumber()==userLogin.getQMnumber()) {
						users.get(i).events=userLogin.events;
						users.get(i).setFined(userLogin.isFined());
						clearUserFile();
						writeUserToFile(users);
					}
				}
				shopui.setVisible(false);
				logui.setVisible(true);
			}

		}
	}
	/**
	 * This is an inner class, a thread in shopUI
	 * let the available slot shining for 60s
	 * if the second is over 60, the slot will be locked again
	 */	
	class shoptimer extends Thread{
		private long programStart = System.currentTimeMillis();  
		public int hour, minute, second;
		
		public void run() { 
			//randomly get an available slot
			randomNum = (int)(0+Math.random()*(8));
			System.out.println(randomNum); 
			while(stations.get(2).slots.get(randomNum).isBorrowed()==true) {
				randomNum = (int)(0+Math.random()*(8));
			}
			for(int j=0; j<8; j++) {
				if(j!=randomNum) {
					shopui.station1.get(j).setEnabled(false);
				}
			}
			
			//60 seconds timer
	        while (second<59) {  
	               long elapsed = System.currentTimeMillis() - programStart;
	               System.out.println(format(elapsed));
	  
	               //shining the selected slot
	               if(second!=58) {
	            	   if(shopui.station1.get(randomNum).getForeground()==Color.GREEN) {
	            	   shopui.station1.get(randomNum).setForeground(Color.RED);
	               }else
	            	   shopui.station1.get(randomNum).setForeground(Color.GREEN);
	               }else {
	            	   shopui.station1.get(randomNum).setEnabled(false);
	            	   //JOptionPane.showMessageDialog(null,"Time out! Please borrow again!","tip",JOptionPane.WARNING_MESSAGE);
	               }
	               
	               
	            try {  
	                sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	                System.exit(1);  
	            }  
	        }
	    }  
	    
	    private String format(long elapsed) { 
	        //milli = (int) (elapsed % 1000);  
	        elapsed = elapsed / 1000;
	        second = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        minute = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        hour = (int) (elapsed % 60);  
	        return String.format("%02d:%02d:%02d", hour, minute, second);  
	    } 
	}
	
	//actionlistener in statusui
	/**
	 * This is an inner class, an actionlistener in statusUI
	 * repeatedly use the statesUI
	 * it will judge which former GUI it has to return to
	 */	
	class statusBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(UorA==0) {
				if(userLogin.events.isEmpty()==true) {
					statusui.setVisible(false);
					borrowui.setVisible(true);
				}else if(userLogin.events.get(userLogin.events.size()-1).getBorrowEnd()>0) {
					statusui.setVisible(false);
					borrowui.setVisible(true);
				}else {
					statusui.setVisible(false);
					returnui.setVisible(true);
				}
			}else {
				statusui.setVisible(false);
				adui.myFrame.setVisible(true);
			}
		}
	}
	
	//actionlistener in returnui
	/**
	 * This is an inner class, an actionlistener in returnUI
	 * let the user return to the login UI
	 */	
	class returnBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			returnui.setVisible(false);
			logui.setVisible(true);
		}	
	}
	/**
	 * This is an inner class, an actionlistener in returnUI
	 * let the user return scooter in library station
	 */	
	class libReturnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int a;
			int b = 8;
			for(a=0; a<8; a++) {
				if(stations.get(0).slots.get(a).isBorrowed()==false)
					b--;
			}
			if(b!=0) {
				for(int i=0;i<8;i++) {
					libui.station1.get(i).setEnabled(true);
				}
				returnui.setVisible(false);
				libui.setVisible(true);
				libReturnTimer timer1 = new libReturnTimer();
				timer1.start();
			}else {
				JOptionPane.showMessageDialog(null,"This station is full","tip",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	/**
	 * This is an inner class, an thread in returnUI
	 * shining the available slot for 60 seconds
	 * if second is over 60, the slot will be locked again
	 */	
	class libReturnTimer extends Thread{
		private long programStart = System.currentTimeMillis();  
		public int hour, minute, second;
		
		public void run() { 
			//randomly get an available slot
			randomNum = (int)(0+Math.random()*(8));
			System.out.println(randomNum); 
			while(stations.get(0).slots.get(randomNum).isBorrowed()!=true) {
				randomNum = (int)(0+Math.random()*(8));
			}
			for(int j=0; j<8; j++) {
				if(j!=randomNum) {
					libui.station1.get(j).setEnabled(false);
				}
			}
			
			//60 seconds timer
	        while (second<59) {  
	               long elapsed = System.currentTimeMillis() - programStart;
	               System.out.println(format(elapsed));
	  
	               //shining the selected slot
	               if(second!=58) {
	            	   if(libui.station1.get(randomNum).getForeground()==Color.RED) {
	            		   libui.station1.get(randomNum).setForeground(Color.GREEN);
	            	   }else
	            		   libui.station1.get(randomNum).setForeground(Color.RED);
	               }else {
	            	   libui.station1.get(randomNum).setEnabled(false);
	            	   //JOptionPane.showMessageDialog(null,"Time out! Please return again!","tip",JOptionPane.WARNING_MESSAGE);
	               }
	               
	               
	            try {  
	                sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	                System.exit(1);  
	            }  
	        }
	    }  
	    
	    private String format(long elapsed) { 
	        //milli = (int) (elapsed % 1000);  
	        elapsed = elapsed / 1000;
	        second = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        minute = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        hour = (int) (elapsed % 60);  
	        return String.format("%02d:%02d:%02d", hour, minute, second);  
	    } 
	}
	/**
	 * This is an inner class, an actionlistener in returnUI
	 * let the user return scooter in laboratory station
	 */	
	class labReturnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int a;
			int b = 8;
			for(a=0; a<8; a++) {
				if(stations.get(1).slots.get(a).isBorrowed()==false)
					b--;
			}
			if(b!=0) {
				for(int i=0;i<8;i++) {
					labui.station1.get(i).setEnabled(true);
				}
				returnui.setVisible(false);
				labui.setVisible(true);
				labReturnTimer timer1 = new labReturnTimer();
				timer1.start();
			}else {
				JOptionPane.showMessageDialog(null,"This station is full","tip",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	/**
	 * This is an inner class, an thread in returnUI
	 * shining the available slot for 60 seconds
	 * if second is over 60, the slot will be locked again
	 */	
	class labReturnTimer extends Thread{
		private long programStart = System.currentTimeMillis();  
		public int hour, minute, second;
		
		public void run() { 
			//randomly get an available slot
			randomNum = (int)(0+Math.random()*(8));
			System.out.println(randomNum); 
			while(stations.get(1).slots.get(randomNum).isBorrowed()!=true) {
				randomNum = (int)(0+Math.random()*(8));
			}
			for(int j=0; j<8; j++) {
				if(j!=randomNum) {
					labui.station1.get(j).setEnabled(false);
				}
			}
			
			//60 seconds timer
	        while (second<59) {  
	               long elapsed = System.currentTimeMillis() - programStart;
	               System.out.println(format(elapsed));
	  
	               //shining the selected slot
	               if(second!=58) {
	            	   if(labui.station1.get(randomNum).getForeground()==Color.RED) {
	            	   labui.station1.get(randomNum).setForeground(Color.GREEN);
	            	 }else
	            	   labui.station1.get(randomNum).setForeground(Color.RED);
	               }else {
	            	   labui.station1.get(randomNum).setEnabled((false));
	               }
	              
	               
	            try {  
	                sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	                System.exit(1);  
	            }  
	        }
	    }  
	    
	    private String format(long elapsed) { 
	        //milli = (int) (elapsed % 1000);  
	        elapsed = elapsed / 1000;
	        second = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        minute = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        hour = (int) (elapsed % 60);  
	        return String.format("%02d:%02d:%02d", hour, minute, second);  
	    } 
	}
	/**
	 * This is an inner class, an actionlistener in returnUI
	 * let the user return scooter in shop station
	 */	
	class shopReturnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int a;
			int b = 8;
			for(a=0; a<8; a++) {
				if(stations.get(2).slots.get(a).isBorrowed()==false)
					b--;
			}
			if(b!=0) {
				for(int i=0;i<8;i++) {
					shopui.station1.get(i).setEnabled(true);
				}
				returnui.setVisible(false);
				shopui.setVisible(true);
				shopReturnTimer timer1 = new shopReturnTimer();
				timer1.start();
			}else {
				JOptionPane.showMessageDialog(null,"This station is full","tip",JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
	/**
	 * This is an inner class, an thread in returnUI
	 * shining the available slot for 60 seconds
	 * if second is over 60, the slot will be locked again
	 */	
	class shopReturnTimer extends Thread{
		private long programStart = System.currentTimeMillis();  
		public int hour, minute, second;
		
		public void run() { 
			//randomly get an available slot
			randomNum = (int)(0+Math.random()*(8));
			System.out.println(randomNum); 
			while(stations.get(2).slots.get(randomNum).isBorrowed()!=true) {
				randomNum = (int)(0+Math.random()*(8));
			}
			for(int j=0; j<8; j++) {
				if(j!=randomNum) {
					shopui.station1.get(j).setEnabled(false);
				}
			}
			
			//60 seconds timer
	        while (second<59) {  
	               long elapsed = System.currentTimeMillis() - programStart;
	               System.out.println(format(elapsed));
	  
	               //shining the selected slot
	               if(second!=58) {
	            	   if(shopui.station1.get(randomNum).getForeground()==Color.RED) {
	            		   shopui.station1.get(randomNum).setForeground(Color.GREEN);
	            	   }else
	            		   shopui.station1.get(randomNum).setForeground(Color.RED);
	               }else {
	            	   shopui.station1.get(randomNum).setEnabled(false);
	               }
	               
	               
	            try {  
	                sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	                System.exit(1);  
	            }  
	        }
	    }  
	    
	    private String format(long elapsed) { 
	        //milli = (int) (elapsed % 1000);  
	        elapsed = elapsed / 1000;
	        second = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        minute = (int) (elapsed % 60);  
	        elapsed = elapsed / 60;
	        hour = (int) (elapsed % 60);  
	        return String.format("%02d:%02d:%02d", hour, minute, second);  
	    } 
	}
	
	//actionlistener in adui
	/**
	 * This is an inner class, an actionlistener in adUI
	 * let the administrator check the stations conditions
	 */	
	class adminCheckConditionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			adui.myFrame.setVisible(false);
			statusui.setVisible(true);
		}
	}
	/**
	 * This is an inner class, an actionlistener in adUI
	 * let the administrator check the users conditions
	 */	
	class adminCheckUserListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			users = getUserFromFile();
			
			adui.myFrame.setVisible(false);
			userinfoui.setVisible(true);
			String s = "";
			
			String s1 = "<html>";
			String s2 ="";
			String s3 = "</html>";
			String s4 = "<p>";
			String s5 = "</p>";
			String s6 ="";
			
			for(int i=0; i<users.size();i++) {
				s6 = "QMNumber: "+users.get(i).getQMnumber()+" Name: "+users.get(i).getName()+" isfined? "+ users.get(i).isFined();
				s2 = s2+s4+s6+s5;
			}
			s = s1+s2+s3;
			userinfoui.text1.setText(s);
			
		}
	}
	/**
	 * This is an inner class, an actionlistener in adUI
	 * let the administrator back to the login UI
	 */	
	class aduiBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			adui.myFrame.setVisible(false);
			logui.setVisible(true);
		}
	}
	/**
	 * This is an inner class, an actionlistener in adUI
	 * let the administrator register a new user
	 */	
	class registerUserListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			adui.myFrame.setVisible(false);
			reui.myFrame.setVisible(true);
		}
	}
	
	//actionlistener in statusadminui
	/**
	 * This is an inner class, an actionlistener in statusadminUI
	 * back to the adUI
	 */	
	class statusadminiBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			adui.myFrame.setVisible(true);
			statusadminui.setVisible(false);	
		}
	}
	
	//actionlistener in ReUI
	/**
	 * This is an inner class, an actionlistener in ReUI
	 * Details needed to register a new user
	 */	
	class registerUserConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int x = 0;
			reui.QMnumber = reui.myText.getText();
			reui.Name = reui.myText2.getText();
			reui.Email = reui.myText3.getText();
			String reg = "\\w+@\\w+(\\.[a-zA-Z]+)+";
			reui.match = reui.Email.matches(reg);
			System.out.println(reui.QMnumber+"*");
			System.out.println(reui.Name+"*");
			System.out.println(reui.Email+"*");
			if (reui.QMnumber.equals("")){
			System.out.println("Your input QMnumber is null");
			  JOptionPane.showMessageDialog(null,"Please input your QMnumber.","tip",JOptionPane.WARNING_MESSAGE); 

			}else{
			try{
   			  reui.QM = Integer.parseInt(reui.QMnumber);
			  }catch(NumberFormatException e2)
			  {
			 System.out.println("Your input QMnumber is not number");
			  JOptionPane.showMessageDialog(null,"Your QMnumber is invalid.","tip",JOptionPane.WARNING_MESSAGE); 
				x=1;
			}
			if (x==0&&(reui.QM>999999999||reui.QM<100000000)) {
			  JOptionPane.showMessageDialog(null,"Your QMnumber should have 9 numbers.","tip",JOptionPane.WARNING_MESSAGE); 
			  }else if ((x == 0)&&(reui.Name.equals(""))){
			  	JOptionPane.showMessageDialog(null,"Please input your Name.","tip",JOptionPane.WARNING_MESSAGE);
			  }
			  else if ((x == 0)&&(reui.Email.equals(""))){
			  	JOptionPane.showMessageDialog(null,"Please input your Email.","tip",JOptionPane.WARNING_MESSAGE);
			  }else if ((x == 0)&&(!reui.match)){
				JOptionPane.showMessageDialog(null,"Your Email format is invalid.","tip",JOptionPane.WARNING_MESSAGE); 
			}else if (x == 0){
				addUser(reui.QM+"", reui.Name, reui.Email);
				clearUserFile();
				writeUserToFile(users);
				JOptionPane.showMessageDialog(null,"Register success.","tip",JOptionPane.WARNING_MESSAGE); 
				reui.myFrame.setVisible(false);
				adui.myFrame.setVisible(true);
			}
		   }
		}
	}
	/**
	 * This is an inner class, an actionlistener in ReUI
	 * return to the adUI
	 */	
	class registerUserBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			reui.myFrame.setVisible(false);
			adui.myFrame.setVisible(true);
			
		}
	}
	/**
	 * This is an inner class, an actionlistener in userinfoUI
	 * return to the adUI
	 */	
	class checkUserInfoBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			userinfoui.setVisible(false);
			adui.myFrame.setVisible(true);
		}
	}
	/**
	 * This is an inner class, an actionlistener in userinfoUI
	 * send weekly usage to users
	 */	
	class sendEmailListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int i;
			for(i=0;i<users.size();i++) {
				System.out.println("name: "+users.get(i).getName());
				System.out.println("weekly usage: ");
				for (int j=0;j<users.get(i).events.size();j++) {
					if(users.get(i).events.get(j).date.after(weekStart) && users.get(i).events.get(j).date.before(weekEnd)) {
						System.out.println("date: "+ users.get(i).events.get(j).date.getTime());
					}
				}
			}
			JOptionPane.showMessageDialog(null,"Send email Success","tip",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	public static void main(String args[]) {
		systemControl sys1 = new systemControl();
		sys1.users = new ArrayList<User>();
		sys1.administrators = new ArrayList<Administrator>();
		sys1.userLogin = new User();
		sys1.administratorLogin = new Administrator();
		sys1.stations = new ArrayList<Station>();
		
		/**
		 * pre-register a user, has qm number 161193557 and name Sang, email 123@123.com
		 */
		File file =new File("user.txt");
		if(!file.exists()) {
			sys1.addUser("161193557", "Sang", "123@123.com");
			sys1.writeUserToFile(sys1.users);
		}
		
		File file1 = new File("administrator.txt");
		/**
		 * pre-register an administrator, has qm number 161193558 and name Sang, email 123@123.com
		 */
		if(!file1.exists()) {
			sys1.addAdministrator("161193558", "Sang", "123@123.com");
			sys1.writeAdministratorToFile(sys1.administrators);
		}
		
		Station lib = new Station("library");
		Station lab = new Station("laboratory");
		Station shop = new Station("shop");
		
		sys1.stations.add(lib);
		sys1.stations.add(lab);
		sys1.stations.add(shop);
		
		//sys1.users = sys1.getUserFromFile();
		
		//SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		
		System.out.print("today: ");
		System.out.println(sys1.today.getTime());
		System.out.print("todayStart: ");
		System.out.println(sys1.dayStart.getTime());
		System.out.print("todayEnd: ");
		System.out.println(sys1.dayEnd.getTime());
		System.out.print("weekStart: ");
		System.out.println(sys1.weekStart.getTime());
		System.out.print("weekEnd: ");
		System.out.println(sys1.weekEnd.getTime());
	}

}

