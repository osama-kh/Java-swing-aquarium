package start;
import java.util.Random;

import java.util.ArrayList; 
import java.util.Collections;

import q1.MyDate;
import q2.Location;
import q3.Fish;
import q3.*;

/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */

/**
 * 
 *the static methods  
 *
 */
public class Utility {
	 
	/**
	 * to check if there are three days in sequence in the array
	 * and return the first day in the sequence  
	 *  
	 * @param dates
	 * @return
	 */
	public static MyDate threeDates(MyDate dates[]) {
		
		MyDate temp[]=new MyDate[dates.length];
		 ArrayList<Integer> days=new ArrayList<Integer>();
		 MyDate ans = null;
			int i,j;
		for (i=0; i<dates.length ;i++) {
			days.add(dates[i].getDay());
		}
		Collections.sort(days);
		for (i=0; i<dates.length ;i++) {
			for (j=0; j<dates.length ;j++) {
				if (days.get(i)==dates[j].getDay()) {
					temp[i]=dates[j];
				}
			}	
			
		}	
		
		for (i=0; i<dates.length-2 ;i++) {
			if(temp[i].getMonth()== temp[i+1].getMonth() &&
				temp[i].getMonth()==temp[i+2].getMonth() &&
				temp[i].getYear()== temp[i+1].getYear() &&
				temp[i].getYear()==temp[i+2].getYear() &&
				temp[i+1].getDay()==temp[i].getDay()+1 &&
				temp[i+2].getDay()==temp[i].getDay()+2 ) {
				ans=temp[i];
				
			}
			
		}
		if (ans==null) {
			ans=new MyDate();
		}	
			return ans;
		
			
		
	}
	
	/**
	 * get the max average of temperature in the array of locations 
	 * @param loc
	 * @return
	 */
	public static int getMaxTemp(Location loc[]) {
		Location max=loc[0];
		int indx=0;
		for (int i=0; i<loc.length; i++) {
			if(max.getAverage() < loc[i].getAverage()) {
				max=loc[i];
				indx=i;
			}
		}
		
		return indx;
		
	}


/**
 * to print the fishes details that are in the Aquarium  
 * @param arr3
 */
public static void printAquarium(Swimmable[] arr3) {
	int i;
	System.out.println("\nAquarium[type/color/actual size/eat count]:");
	for(i=0; i<arr3.length; i++) {
		if(arr3[i] instanceof Jellyfish ) {
			System.out.printf("%1s %12s %9s %5s \n",arr3[i].getAnimalName(),((Jellyfish)arr3[i]).getColor(),((Jellyfish)arr3[i]).getSize(),arr3[i].getEatCount());}

		
		else if(arr3[i] instanceof UnusualFish ) {
			System.out.printf("%1s %10s %9s %5s \n",arr3[i].getAnimalName(),((Fish)arr3[i]).getColor(),((Fish)arr3[i]).getSize(),arr3[i].getEatCount());}
		else if(arr3[i] instanceof MultiColorFish ) {
			System.out.printf("%1s %7s %9s %5s \n",arr3[i].getAnimalName(),((Fish)arr3[i]).getColor(),((Fish)arr3[i]).getSize(),arr3[i].getEatCount());}
		
		
		
		else {
		System.out.printf("%1s %17s %9s %5s \n",arr3[i].getAnimalName(),((Fish)arr3[i]).getColor(),((Fish)arr3[i]).getSize(),arr3[i].getEatCount());}

		
	}
	
	
	
}

/**
 * to feed the fishes in the Aquarium and calculate the changes
 * @param arr3
 * @param food
 */
public static void  feedAquaticAnimal(Swimmable[] arr3,int food) {
    Random rand = new Random();
    for (int i=0; i<food; i++) {
    	int random_indx = rand.nextInt(arr3.length);
    	arr3[random_indx].eatInc();
    	
    	if(arr3[random_indx] instanceof Jellyfish ) {
    		
    	((Jellyfish) arr3[random_indx]).changeJellyfish();

    	}
		else if(arr3[random_indx] instanceof MultiColorFish ) {
			int original=((MultiColorFish) arr3[random_indx]).getSize();    
			((MultiColorFish) arr3[random_indx]).changefish();
			if(((MultiColorFish) arr3[random_indx]).getSize()!=original) {
				((MultiColorFish) arr3[random_indx]).changeColor();
			}
			
			
}
		
		else if(arr3[random_indx] instanceof UnusualFish ) {
			
			((UnusualFish) arr3[random_indx]).changefish();
			
		}
    	
    	else {
        ((Fish) arr3[random_indx]).changefish();

    	}
    }
	
}

/**
 * the count of animals with smaller size compare to the first fish in the array
 * @param arr3
 * @return
 */
public static int  countAquaticAnimal(Swimmable[] arr3) {
	int count=0,i;
	Swimmable first=arr3[0];
	for(i=1; i<arr3.length; i++)
	{
		if(first.compareTo(arr3[i])==0) {
			count++;
		}
	}

	return count;
}

/**
 * sort the animals by size in big to small sort
 * @param arr3
 */
public static void  sortAquaticAnimal(Swimmable[] arr3) {
	
	Swimmable temp[]=new Swimmable[arr3.length];
	 ArrayList<Integer> sizes=new ArrayList<Integer>();
	 
		int i,j;
	for (i=0; i<arr3.length ;i++) {
		sizes.add(arr3[i].getSize());
	}
	Collections.sort(sizes);
	Collections.reverse(sizes);
	for (i=0; i<arr3.length ;i++) {
		for (j=0; j<arr3.length ;j++) {
			if (sizes.get(i)==arr3[j].getSize()) {
				temp[i]=arr3[j];
			}
		}	
		
	}
	for (i=0; i<arr3.length ;i++) {
		arr3[i]=temp[i];
	}
	
	
	
}





}



















