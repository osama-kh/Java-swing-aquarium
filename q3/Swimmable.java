package q3;

import java.awt.Graphics;
import java.util.concurrent.CyclicBarrier;

/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */

/**
 * Swimmable class that implements the comparable interface 
 * to describe the swimmable creatures
 * and it have 2 variables horspeed,verspeed
 *
 */
public abstract class Swimmable extends Thread implements Comparable<Swimmable>  {

	protected int horspeed;
	protected int verspeed;
	private boolean winner_food=false;

	
	/*
	 * default constructor to set the variables to zero
	 */
	public Swimmable() {
		horspeed=0;
		verspeed=0;
	}
	/*
	 * constructor to set the variables by user
	 */
	public Swimmable(int h, int v) {
		horspeed=h;
		verspeed=v; 
		
	}
	/*
	 * abstract function that will be implemented in the sons classes
	 */
	public abstract String getAnimalName();
	public abstract int  getEatCount();
	public abstract String getColor();
	public abstract int  getSize();
	public abstract void  eatInc();
	abstract public void drawAnimal(Graphics g);
	abstract public void setSuspend();
	abstract public void setResume();
	abstract public void setBarrier(CyclicBarrier b);



	/**
	 * getters and sitters
	 * @return
	 */
	
	public int getHorspeed() {
		return horspeed;
	}
	public void setHorspeed(int horspeed) {
		this.horspeed = horspeed;
	}
	public int getVerspeed() {
		return verspeed;
	}
	public void setVerspeed(int verspeed) {
		this.verspeed = verspeed;
	}
	
protected int aquarium_cord_x,aquarium_cord_y;
	
	
	public int getAquarium_cord_x() {
		return aquarium_cord_x;
	}

	public void setAquarium_cord_x(int aquarium_cord_x) {
		this.aquarium_cord_x = aquarium_cord_x;
	}

	public int getAquarium_cord_y() {
		return aquarium_cord_y;
	}

	public void setAquarium_cord_y(int aquarium_cord_y) {
		this.aquarium_cord_y = aquarium_cord_y;
	}
	public boolean isWinner_food() {
		return winner_food;
	}
	public void setWinner_food(boolean winner_food) { 
		this.winner_food = winner_food;
	}



	

}
