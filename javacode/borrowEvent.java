import java.io.*;
import java.util.Calendar;

/**
 * The class is borrowEvent
 * each event has a start and end time, a date, and the use time
 *
 */
public class borrowEvent implements Serializable{
	private long borrowStart ;
	private long borrowEnd;
	public double useTime;//in hour
	public Calendar date;
	
	public borrowEvent(long borrowStart) {
		this.borrowStart = borrowStart;
		this.borrowEnd = 0;
		this.useTime = 0;
		this.date = Calendar.getInstance();//get current time
	}

	public long getBorrowStart() {
		return borrowStart;
	}

	public void setBorrowStart(long borrowStart) {
		this.borrowStart = borrowStart;
	}

	public long getBorrowEnd() {
		return borrowEnd;
	}

	public void setBorrowEnd(long borrowEnd) {
		this.borrowEnd = borrowEnd;
	}
	
	public void setuseTime() {
		long elapsed = borrowEnd - borrowStart;
		 elapsed = elapsed / 1000;  
	     //second = (int) (elapsed % 60);  
	     elapsed = elapsed / 60;
	     //minute = (int) (elapsed % 60);  
	     elapsed = elapsed / 60;  
		this.useTime = elapsed % 60;
	}
}
