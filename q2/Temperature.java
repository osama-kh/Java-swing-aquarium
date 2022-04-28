package q2;

import q1.MyDate;
/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */
/**
 * Temperature class: 
 * contain the scale of temperature and date as a variables
 * Goal: this class is made to display the temperature
 */
public class Temperature {
	private double scale;
	private MyDate scale_date;
	
	/**
	 * constructor Temperature to set all the object data 
	 * @param s
	 * @param d
	 * @param m
	 * @param y
	 */
public Temperature(double s, int d, int m, int y) {
		scale=s;
		scale_date=new MyDate(d, m, y);
		
	}
/**
 * constructor Temperature to set a scale data in the with local date object 
 * @param s

 */
public Temperature(double s) {
	scale=s;
	scale_date=new MyDate();
		
	}

/**
 * copy constructor Temperature to set a the data of the local object by other object 
 * @param s

 */
public Temperature(Temperature other) {
		scale=other.getScale();
		scale_date= new MyDate(other.getScale_date());
	}

/*
 * return a string with details of the temperature
 */
@Override
public String toString() {
	if (scale>0)
	return "+"+scale+" C\u00B0 "+scale_date.toString();
	else {
		 return ""+scale+" C\u00B0 "+scale_date.toString();
	}
			
}

/**
 *   to print the temperature data
 */
public void printTemp() {
	
	if (scale>0)
		System.out.print("+"+scale+" C\u00B0 ");
	else {
		System.out.print(scale+" C\u00B0 ");
	}
}
/**
 *   to print the temperature data with it's date
 */
public void printTempFull() {
	
	if (scale>0)
		System.out.print("+"+scale+" C\u00B0 "+scale_date.toString());
	else {
		System.out.print(""+scale+" C\u00B0 "+scale_date.toString());
	}
}
/*
 * to create a new object with highest data
 */
public Temperature compareTemp(Temperature other) {
	if(scale>other.getScale()) {
		return new Temperature(scale);
	}
	else {
		return  new Temperature(other.getScale());
	}
}

/**
 * getters and sitters
 * @return
 */
public double getScale() {
	return scale;
}
public void setScale(double scale) {
	this.scale = scale;
}
public MyDate getScale_date() {
	return scale_date;
}
public void setScale_date(MyDate scale_date) {
	this.scale_date = scale_date;
}
}
