package start;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import q3.Fish;
import q3.Jellyfish;
import q3.Swimmable;

public class AquaPanel extends JPanel {

	/**
	 * aqua panel is the main part of the
	 *  frame it represent the aquarium
	 */    
	 public static boolean	food =false;
	 boolean check = false;
	 boolean blue_background = false;
	 boolean animal_trig=false;
	 boolean info_locker=true;
	 public static HashSet<Swimmable> animals_in_aquarium=new HashSet<Swimmable> ();
	 
		/**
		 * Create the panel.
		 */
		public AquaPanel() {} 
		
	 
	 /**
	  * getters and setters
	  * @return
	  */
	 public HashSet<Swimmable> getAnimals_in_aquarium() {
		 
			return animals_in_aquarium;
		}

	public void add2Animals_in_aquarium(Swimmable animals) {
			
			this.animals_in_aquarium.add(animals);
			System.out.println(animals_in_aquarium);
		}

	 public boolean isInfo_locker() {
				return info_locker;
			}

	public void setInfo_locker(boolean info_locker) {
				this.info_locker = info_locker;
			}

	public boolean isFood() {
			return food;
		}



	public void setFood(boolean food) {
			this.food = food;
		}



	public boolean isBlue_background() {
		return blue_background;
	}

	public void setBlue_background(boolean blue_background) {
		this.blue_background = blue_background;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	final ImageIcon icon= new ImageIcon("background.jpg");
     Image img = icon.getImage();

	  
     private static final long serialVersionUID = 1L;
     
	public void setAnimals_in_aquarium(HashSet<Swimmable> animals_in_aquarium) {
			
			this.animals_in_aquarium = animals_in_aquarium;
		}



	public boolean isAnimal_trig() {
			return animal_trig;
		}



	public void setAnimal_trig(boolean animal_trig) {
			this.animal_trig = animal_trig;
		}

	
	
	
	
	
	
	
	/*
	 * paint Component responsible of drawing all the system 
	 */
	@Override
	 protected synchronized void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		System.out.println("--------------------------------------------------------------------");
		//draw the Image
		 if(check) {
		 g.drawImage(img,0,0, getWidth(), getHeight(), this);
		 }
		 //paint the background with blue color
		 if(blue_background) {
			 setBackground(Color.BLUE);
		 g.setColor(Color .blue);
		 g.drawRect(0, 0, getWidth(), getHeight());
		 }
		 
		 //draw the added animals
		 if(animal_trig) {
		 if(animals_in_aquarium!=null) {
	     for (Swimmable animal : animals_in_aquarium) {
	 		 animal.drawAnimal(g);
	    	  if(animal instanceof Fish) {

					((Fish) animal).drawAnimal(g);
				}
				else { 

					((Jellyfish)animal).drawAnimal(g);
				}			
	     	}
		 }
	 }
		 //show the worm
	     if(food) {
	    	 worm_food(g);
	    	 repaint();
	     }
	     //show the info table
	     if(info_locker) {
	      repaint();}
	     
			System.out.println("--------------------------------------------------------------------");

	}
		/**
		 * the worm body
		 * @param g
		 */
		 public void worm_food(Graphics g) {
			 Graphics2D g2 =(Graphics2D) g;
			 g2.setStroke(new BasicStroke(3));
			 g2.setColor(Color.MAGENTA);
			 g2.drawArc(getWidth()/2,getHeight()/2-5, 10, 10, 30, 210);
			 g2.drawArc(getWidth()/2,getHeight()/2+5, 10, 10, 180, 270);
			 g2.setStroke(new BasicStroke(1));
 
		 }




		 
	
	     
		
		  
	
	
	
	

}
