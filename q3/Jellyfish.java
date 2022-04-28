package q3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import start.AquaFrame;
import start.AquaPanel;

/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */
/*
 * Jellyfish class and its father is swimmable
 * to describe the Jellyfish details
 * 
 */
public class Jellyfish extends Swimmable{

	final int DISTANCE_EAT=4;  
	int size; 
	int col;
	int eatCount;
	int x_front, y_front, x_dir, y_dir;
	private boolean threadSuspend=false;
	Color colorfx;
	private boolean cyclic=false;
	private CyclicBarrier food_chasing;
	private final int center_x=AquaFrame.width/2;
	private final int center_y=AquaFrame.hight/2;

	/**
	 * constructor Jellyfish to set all the object data 
	 * @param size1
	 * @param x_front1
	 * @param y_front1
	 * @param h
	 * @param v
	 * @param col1
	 */
	public Jellyfish (int size1,int x_front1,int y_front1,int h, int v, int col1) {
		super(h,v); 
		
		size=size1; 
		col=col1;
		eatCount=0;
		x_front=x_front1;
		y_front=y_front1;
		x_dir=1;
		y_dir=1;
		
	
	}
	/**
	 * to compare with other type of swimmable
	 */
	@Override
	public int compareTo( Swimmable o) {
		if(this.size>=o.getSize()) {
			return 1;
		}
		return 0;
	}
	   
	  /**
	    * get the color of the Jellyfish by it's color number
	    */
	public String getColor() {
		String result = null;
		//Color col1;
		switch(col) {
		  case 1:
			  result= "Black";
			  colorfx=Color.BLACK;
			  break;
		  case 2:
			  result= "Red";
			  colorfx=Color.RED;
			  
			  break;
		  case 3:
			  result= "Blue";
			  colorfx=Color.BLUE;
			  break;
		  case 4:
			  result= "Green";
			  colorfx=Color.GREEN;
			  break;
		  case 5:
			  result= "Cyan";
			  colorfx=Color.CYAN;
			  break;
		  case 6:
			  result= "Orange";
			  colorfx=Color.ORANGE;
			  break;
		  case 7:
			  result= "Yellow"; 
			  colorfx=Color.YELLOW;
			  break;
		  case 8:
			  result= "Magenta";
			  colorfx=Color.MAGENTA;
			  break;
		  case 9:
			  result= "Pink";
			  colorfx=Color.PINK;
			  break;
		}
		return result;		
	}

	/**
	 * to increase the eatcount by 1
	 */

	@Override
	public void eatInc() {
		eatCount+=1;
	
	}
	/**
	 * to update the Jellyfish size and to set eatcount to 0
	 */
	public void changeJellyfish() {
		if(eatCount==DISTANCE_EAT) {
			size++;
			eatCount=0;
		}
		
	}
	
	/**
	 * getters and sitters
	 * @return
	 */
	@Override
	public String getAnimalName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}

	public int getDISTANCE_EAT() {
		return DISTANCE_EAT;
	}


	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getX_front() {
		return x_front;
	}

	public void setX_front(int x_front) {
		this.x_front = x_front;
	}

	public int getY_front() {
		return y_front;
	}

	public void setY_front(int y_front) {
		this.y_front = y_front;
	}

	public int getX_dir() {
		return x_dir;
	}

	public void setX_dir(int x_dir) {
		this.x_dir = x_dir;
	}

	public int getY_dir() {
		return y_dir;
	}

	public void setY_dir(int y_dir) {
		this.y_dir = y_dir;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}

	@Override
	public int getEatCount() {
		return eatCount;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public void setSuspend() {
		threadSuspend=true;
	}

	@Override
	public void setResume() {
		threadSuspend=false;
		synchronized (this) {
			notify();
		}
		
	}
	public boolean isCyclic() {
		return cyclic;
	}
	public void setCyclic(boolean cyclic) {
		this.cyclic = cyclic;
	}
	public CyclicBarrier getFood_chasing() {
		return food_chasing;
	}

	public void setFood_chasing(CyclicBarrier food_chasing) {
		this.food_chasing = food_chasing;
	}

	@Override
	public void setBarrier(CyclicBarrier b) {
		food_chasing=b;
	}
	
	
	/**
	 * the draw method to draw the animal in every move
	 */
	@Override
	public void drawAnimal(Graphics g) {
		getColor();
		System.out.println("jellyfish"+" " +size+" " + x_front+" " + y_front+" " + horspeed+" " + verspeed+" " + col);
		   int numLegs;
		   if(size<40)
		    	numLegs = 5;
		   else if(size<80)
		    	numLegs = 9;
		   else
		    	numLegs = 12;
		   
		   g.setColor(colorfx);
		   g.fillArc(x_front - size/2, y_front - size/4, size, size/2, 0, 180);
				
		   for(int i=0; i<numLegs; i++)
			g.drawLine(x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front, x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front+size/3);
	}
	

	/**
	 * the run method to control the fish movment 
	 */
	@Override
	public void run() {

		while(true) {
			try {
				Thread.sleep(100);

				if(x_dir==1) {
					x_front+=horspeed;
					
					if(x_front >= AquaFrame.width){
						x_dir=0;

					}}
					else {
					    x_front-=horspeed;
						if(x_front <= 0){
							x_dir=1;

						}
					}
					if(y_dir==1) {
						y_front+=verspeed;
						if(y_front >= AquaFrame.hight){
							y_dir=0;
							

						}
					}
					else {
						y_front-=verspeed;
						if(y_front <= 0){
							y_dir=1;

						}

					}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			   synchronized(this) {
				   //the sleep mode
	                while (threadSuspend) {
						try {
							System.out.println("stop");
							this.wait();

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						  }
						}
	                
	                
	                //the cyclic mode
	                while(cyclic){
	                try {
	  
						food_chasing.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	                  }
			    }
	      }
	}
	
	
	
	/**
	 * activate when the cyclic barrier activate and it's goal
	 *  to make the fish eat the warm in the center of the panel
	 * @throws InterruptedException
	 */
	public void centermove() throws InterruptedException {
		
	 if(x_front == center_x && y_front == center_y) {
			System.out.println("ended thread");
		AquaPanel.food=false;
		setWinner_food(true);
		setCyclic(false);
		eatInc();
		synchronized(this) {
			run();} 
		}
	 else {
	
		 if(x_front <=center_x && y_front <= center_y) {//I
			 	
			 
				if(x_front==center_x ) {
					if(y_front<center_y && y_front>center_y-10 )
						y_front+=1;
					else
					y_front+=verspeed;
					}
				/////////////////////////////////
				else if(y_front==center_y) {
					if(x_front<center_x && x_front>center_x-10 )
						x_front+=1;
					else
					x_front+=horspeed;
					}
				/////////////////////////////////
				else {
			 
				if(x_front<center_x && x_front>center_x-10 ) {
					x_front+=1;
				}
				else {	
			x_front+=horspeed;
				}
				if(y_front<center_y && y_front>center_y-10 ) {
					y_front+=1;
				}
				else {	
		
			y_front+=verspeed;
				}
				}

		 }//END I
		 
		 
		 else if(x_front > center_x && y_front < center_y) {//II
			 
				if(x_front==center_x ) {
					if(y_front<center_y && y_front>=center_y-10 ) 
						y_front+=1;
					else
					y_front+=verspeed;
					}
				//////////////////////////////////
				else if(y_front==center_y) {
					if(x_front<center_x && x_front>=center_x-10 ) 
						x_front-=1;
					
					else 
					x_front-=horspeed;
					}
				////////////////////////////////////
				else {
				if(x_front<center_x && x_front>=center_x-10 ) {
					x_front-=1;
				}
				else {	
			x_front-=horspeed;
				}
				if(y_front<center_y && y_front>=center_y-10 ) {
					y_front+=1;
				}
				else {	
		
			y_front+=verspeed;
				}}
			 ////////////////////////////////
				
				
			 
		 }//II END
		 
		 
		 
		 else if(x_front < center_x && y_front > center_y) {//III
			 
			 if(x_front==center_x ) {
				 if(y_front<center_y && y_front>=center_y-10 ) 
						y_front+=1;
					else
				 y_front+=verspeed;
				 }
			 ////////////////////////////////
				else if(y_front==center_y) {
					if(x_front<center_x && x_front>=center_x-10 )
						x_front-=1;
					
					else 
					x_front-=horspeed;
					}				
			 ////////////////////////////////
				else {
				if(x_front<center_x && x_front>=center_x-10 ) {
					x_front+=1;
				}
				else {	
			x_front+=horspeed;
				}
				/////////////////////////////
				if(y_front<center_y && y_front>=center_y-10 ) {
					y_front-=1;
				}
				else {	
		
			y_front-=verspeed;
				}}
			 
			 
		 }//end III
		 
		 else if(x_front >= center_x && y_front >= center_y) {//IV
			 if(x_front==center_x ) {
				 if(y_front<center_y && y_front>=center_y-10 ) 
						y_front-=1;
					
					else 
				 y_front-=verspeed;
				 }
				else if(y_front==center_y) {
					if(x_front<center_x && x_front>=center_x-10 ) 
						x_front-=1;
					
					else 
					x_front-=horspeed;
					}
				else {
				if(x_front<center_x && x_front>=center_x-10 ) {
					x_front-=1;
				}
				else {	
			x_front-=horspeed;
				}
				if(y_front<center_y && y_front>=center_y-10 ) {
					y_front-=1;
				}
				else {	
		
			y_front-=verspeed;
				}}
			 
		 }
	 
	

	 }
	 }
}

