package q2;
/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */
/**
 * Location class: 
 * contain name of Location and temperature array as a variables
 * Goal: this class is made to display the Location and its temperature
 */

public class Location {
	private String name;
	private Temperature temp[]=new Temperature[0];
	
	/**
	 * constructor Location to set name of Location
	 * @param n
	 */
	public Location(String n) {
		name=n;
	}
	
	/**
	 *   printLocation
	 *   to print the location array
	 */
	public void printLocation() {
		System.out.print("\n"+name);
		if (temp.length<=0) {
		
			System.out.println(" no temperature measurements available.");
		}
		else { 
			System.out.print(" temperature measurements:");

			for(int i=0; i<temp.length;i++) {
				System.out.print(temp[i].toString()+"|");
			}
		}
		
	}
	
	/**
	 * getAverage
	 * @return the average of the temperature
	 */
	public double getAverage() {
		double sum=0;
		for(int i=0; i<temp.length;i++) {
			sum+=temp[i].getScale();
		}
		return sum/temp.length;
		
	}
	/**
	 * 
	 * @param t
	 * @param d
	 * @param m
	 * @param y
	 * to add  a temperature to the array of temperatures
	 */
	public void addTemp(double t,int d,int m,int y) {
		
		Temperature help;
		help=new Temperature(t, d, m, y);
		
		Temperature temp2[]=new Temperature[temp.length+1];
		
		for(int i=0; i<temp.length;i++) {
			temp2[i]=temp[i];
		}
		temp2[temp.length]=help;
		temp=temp2;
	

	}
	/**
	 * 
	 * @param t
	 * to add  a temperature to the array of temperatures with the local date 
	 */
	public void addTemp(double t) {
		
		Temperature help;
		help=new Temperature(t);
		
		Temperature temp2[]=new Temperature[temp.length+1];
		
		for(int i=0; i<temp.length;i++) {
			temp2[i]=temp[i];
		}
		temp2[temp.length]=help;
		temp=temp2;
	

	}
	
	/**
	 * to get the highest temperature in the array
	 * @return
	 */
	public Temperature getMax() {
		Temperature max= temp[0];
		if (temp.length<=0){
			return null;
		}
		else {
			for(int i=0; i<temp.length; i++) {
				if(max.getScale()<temp[i].getScale()) {
					max=temp[i];
				}
				
			}
			return max;
		}
	}
	
	
/**
 * getters and sitters
 * @return
 */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Temperature[] getTemp() {
		return temp;
	}


	public void setTemp(Temperature[] temp) {
		this.temp = temp;
	}
	
	
	
}
