package q1;
import java.time.*;
/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */
/**
 * my date class: 
 * contain day/month/year as a variables
 * Goal: this class is made to display the time 
 */
public class MyDate {
private int day;
private int month;
private int year;
private LocalDate s=LocalDate.now();

public MyDate() {
	
	day=s.getDayOfMonth();
	month=s.getMonthValue();
	year=s.getYear();
}
/**
 * 
 * @param d
 * @param m
 * @param y
 * constructor to generate objects that the user setting the time 
 * in case that the time is'nt correct it will set the local time 
 */
public MyDate(int d, int m, int y) {
	if ((m==1 || m==3 || m==5 ||m==7 ||m==8 ||m==10 ||m==12 ) &&(d>31 || d<1)) {
		day=s.getDayOfMonth();
		month=s.getMonthValue();
		year=s.getYear();
	}
	else if ((m==4 || m==6 || m==9 ||m==11 ) &&(d>30 || d<1)) {
		day=s.getDayOfMonth();
		month=s.getMonthValue();
		year=s.getYear();
	}	
	else if (m==2  &&(d>28 || d<1)) {
		day=s.getDayOfMonth();
		month=s.getMonthValue();
		year=s.getYear();
	}
	else if (m==2  && isLeapYear()  &&(d>29 || d<1)) {
		
		day=s.getDayOfMonth();
		month=s.getMonthValue();
		year=s.getYear();
		
	}
	
	else if(m>12 || m<1) {
		
		day=s.getDayOfMonth();
		month=s.getMonthValue();
		year=s.getYear();
	}
	else {
		
		day=d;
		month=m;
		year=y;
	}
}

/**
 * @param other
 * copy constructor to copy other object data to the local object
 */
public MyDate(MyDate other) {
	day=other.getDay();
	month=other.getMonth();
	year=other.getYear();	
}

/**
 * printing the time in format that display the month name
 */
public void printMonthName() {
	if(month==1) {
	System.out.print(day + " Jan " +year);	
	}
	else if(month==2) {
	System.out.print(day + " Feb " +year);
	}
	else if(month==3) {
	System.out.print(day + " Mar " +year);
	}
	else if(month==4) {
	System.out.print(day + " Apr " +year);
	}
	else if(month==5) {
	System.out.print(day + " May " +year);
	}
	else if(month==6) {
	System.out.print(day + " Jun " +year);
	}
	else if(month==7) {
	System.out.print(day + " Jul " +year);
	}
	else if(month==8) {
	System.out.print(day + " Aug " +year);
	}
	else if(month==9) {
	System.out.print(day + " Sep " +year);
	}
	else if(month==10) {
	System.out.print(day + " Oct " +year);
	}
	else if(month==11) {
	System.out.print(day + " Nov" +year);
	}
	else if(month==12) {
	System.out.print(day + " Dec " +year);
	}
	
}
/**
 * printing the date with restriction
 */
public void printDate() {
	if (day<10 && month<10) {System.out.print("0"+day +"/0"+ month +"/"+ year );}
	else if (day<10 && month>10) {System.out.print("0"+day +"/"+ month +"/"+ year );}
	else if (day>10 && month<10) {System.out.print(day +"/0"+month +"/"+ year );}
	else { System.out.print( day +"/"+month +"/"+ year );}
}


@Override
/**
 * to string function return the date in string format
 */
public String toString() {
	String p;
	if (day<10 && month<10) {
		//System.out.print("help");
		 p="0"+day +"/0"+month +'/'+ year ;}
	else if (day<10 && month>10) {
		p="0"+ day +"/"+ month +'/'+ year; }
	else if (day>10 && month<10) {p= day +"/0"+month +'/'+ year ;}
	else {  p=day +"/"+month +"/"+ year ;}
	return p;
}
/**
 * getMonthDay
 * @return the number of days in specific month
 */
public int getMonthDay() {
	if(month==1) {
		return 31;	
		}
		else if(month==2) {
			return 28;	
			}
		else if(month==3) {
			return 31;	
			}
		else if(month==4) {
			return 30;	
		}
		else if(month==5) {
			return 31;	
		}
		else if(month==6) {
			return 30;	
		}
		else if(month==7) {
			return 31;	
		}
		else if(month==8) {
			return 31;	
		}
		else if(month==9) {
			return 30;	
		}
		else if(month==10) {
			return 31;	
		}
		else if(month==11) {
			return 30;	
		}
		else if(month==12) {
			return 31;	
		}
		else {return 0;}
}

/**
 * isLeapYear
 * @return true if the year is a leap year
 */
public Boolean isLeapYear() {
	return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
}

/**
 * nextDate
 * @return object with next day 
 */
public MyDate nextDate() {
	MyDate temp =new MyDate();
	if ((month==1 || month==3 || month==5 ||month==7 ||month==8 ||month==10 ) && day==31) {
		temp.setDay(1);
		temp.setMonth(month+1);
		temp.setYear(year);
	}
	else if(month==12 && day==31){
		temp.setDay(1);
		temp.setMonth(1);
		temp.setYear(year+1);
	}
	else if ((month==4 || month==6 || month==9 ||month==11 ) && day==30) {
		temp.setDay(1);
		temp.setMonth(month+1);
		temp.setYear(year);
	}
	else if(month==2 && day==28) {
		temp.setDay(1);
		temp.setMonth(month+1);
		temp.setYear(year);

	}
	else if(month==2 && isLeapYear() && day==29) {
		temp.setDay(1);
		temp.setMonth(month+1);
		temp.setYear(year);

	}
	else {
		temp.setDay(day+1);
		temp.setMonth(month);
		temp.setYear(year);

	}
	return temp;
}

/**
 * printFormatDate
 * @param format
 * print the date in different format
 */
public void printFormatDate(String format) {
	if (format=="ddmmyy") {
		if (day<10 && month<10) {System.out.print("0"+day +"/0"+ month +"/"+ year%100 );}
		else if (day<10 && month>10) {System.out.print("0"+day +"/"+ month +"/"+ year%100 );}
		else if (day>10 && month<10) {System.out.print(day +"/0"+month +"/"+ year%100 );}
		else { System.out.print( day +"/"+month +"/"+ year%100 );}
	}
	else if (format=="ddmmyyyy") {
		if (day<10 && month<10) {System.out.print("0"+day +"/0"+ month +"/"+ year );}
		else if (day<10 && month>10) {System.out.print("0"+day +"/"+ month +"/"+ year );}
		else if (day>10 && month<10) {System.out.print(day +"/0"+month +"/"+ year );}
		else { System.out.print( day +"/"+month +"/"+ year );}
	}
	else if (format=="mmddyyyy") {
		if (day<10 && month<10) {System.out.print("0"+day +"/0"+ month +"/"+ year );}
		else if (day<10 && month>10) {System.out.print("0"+day +"/"+ month +"/"+ year );}
		else if (day>10 && month<10) {System.out.print(day +"/0"+month +"/"+ year );}
		else { System.out.print( day +"/"+month +"/"+ year );}
	}
	else if (format=="yyyymmdd") {
		if (day<10 && month<10) {System.out.print( year +"/0"+ month +"/"+ "0"+day);}
		else if (day<10 && month>10) {System.out.print( year+"/"+ month +"/"+ "0"+day );}
		else if (day>10 && month<10) {System.out.print( year+"/0"+month +"/"+ day );}
		else { System.out.print( year+"/"+month +"/"+ day);}
	}
	else if (format=="ddMMyyyy") {
		printMonthName();
	}
}
/**
 * compareDate
 * @param obj
 * @return 1/0 to check if the object date is bigger or smaller than the local date
 */

public int compareDate (MyDate obj) {
	if (obj.getDay()==day && obj.getMonth()==month && obj.getYear()==year) {
		return 0;
	}
	else if ((obj.getDay()>day && obj.getMonth()>=month && obj.getYear()>=year)||
			(obj.getDay()>=day && obj.getMonth()>month && obj.getYear()>=year)||
			( obj.getYear()>year)) {
		return -1;
	}
	else {return 1;}
	
	
}
/**
 * getters and sitters of the variables 
 * @return
 */
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}



}
