package q3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import start.AquaFrame;
import start.AquaPanel;



/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */
/*
 * fish class and its father is swimmable
 * to describe the fish details
 * 
 */
public class Fish extends Swimmable{

	private final int DISTANCE_EAT=4;   
	protected int size; 
	private int col;
	private Color colorfx;
	private int eatCount;
	private int x_front, y_front, x_dir, y_dir;
	private boolean threadSuspend=false;
	private boolean threadresume=false;
	private boolean cyclic=false;
	private CyclicBarrier food_chasing;
	private int x_front_final,y_front_final;
	private final int center_x=AquaFrame.width/2;
	private final int center_y=AquaFrame.hight/2;
	private boolean loser=false;
	private boolean winner=false;





	/**
	 * 
	 * constructor Fish to set all the object data 
	 * @param size1
	 * @param x_front1
	 * @param y_front1
	 * @param h
	 * @param v
	 * @param col1
	 */
	public Fish (int size1,int x_front1,int y_front1,int h, int v, int col1) {
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
	    * get the color of the fish by it's color number
	    */
	@Override
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
	 * to update the fish size and to set eatcount to 0
	 */
	public void changefish() {
		if(eatCount==DISTANCE_EAT) {
			size+=1;
			eatCount=0;
		}
		
	}
	/**
	 * to change the fish color
	 */
	public void changeColor() {
		if(this.col<9)
		this.col+=1;
	}
	
	/**
	 * getters and sitters
	 * @return
	 */
	
	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	@Override
	public String getAnimalName() {
		return this.getClass().getSimpleName();
	}

	public boolean isLoser() {
		return loser;
	}

	public void setLoser(boolean loser) {
		this.loser = loser;
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
	
	public int getX_front_final() {
		return x_front_final;
	}

	public void setX_front_final(int x_front_final) {
		this.x_front_final = x_front_final;
	}

	public int getY_front_final() {
		return y_front_final;
	}

	public void setY_front_final(int y_front_final) {
		this.y_front_final = y_front_final;
	}

	/**
	 * to activate the sleep mode
	 */
	@Override
	public void setSuspend() {
		
		System.out.println("Fish.setSuspend()");
		threadSuspend=true;
}

	/**
	 * to deactivate the sleep mode
	 */
	@Override
	public void setResume() {
		System.out.println("Fish.setResume");
		threadSuspend=false;
		synchronized(this) {
		notify();}
	}
/**
 * set the CyclicBarrier
 */
	@Override
	public void setBarrier(CyclicBarrier b) {
			food_chasing=b; 
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
	


/**
 * the run method to control the fish movment 
 */
	@Override
	public void run() {

		while(true) {
			try {
				Thread.sleep(100);
				
  				y_front_final=y_front;
				x_front_final=x_front;
				
				if(x_dir==1) {
				x_front+=horspeed;
				
				if(x_front >= AquaFrame.width){
					x_dir=0;

				    }
				}
				
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
				e.printStackTrace();
			}

			
		   synchronized(this) {
			   //the sleep mode
                while (threadSuspend) {
					try {
						System.out.println("stop");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}}
                
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
		 * the draw method to draw the animal in every move
		 */
		@Override
		public  void drawAnimal(Graphics g) {
	
				getColor();

			   g.setColor(colorfx);
				System.out.println("fish"+" " +size+" " + x_front+" " + y_front+" " + horspeed+" " + verspeed+" " + col);
			   if(x_dir==1) // fish swims to right side
			   {
				// Body of fish
				g.fillOval(x_front - size, y_front - size/4, size, size/2);

				// Tail of fish
				int[] x_t={x_front-size-size/4,x_front-size-size/4,x_front-size};
				int [] y_t = {y_front - size/4, y_front + size/4, y_front};
				Polygon t = new Polygon(x_t,y_t,3);		
				g.fillPolygon(t);

				// Eye of fish
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(new Color(255- colorfx.getRed( ),255-colorfx.getGreen(),255- colorfx.getBlue()));
				g2.fillOval(x_front-size/5, y_front-size/10, size/10, size/10);
						
				// Mouth of fish
				if(size>70)
					g2.setStroke(new BasicStroke(3));
				else if(size>30)
					g2.setStroke(new BasicStroke(2));
				else
					g2.setStroke(new BasicStroke(1));
			      g2.drawLine(x_front, y_front, x_front-size/10, y_front+size/10);
			      g2.setStroke(new BasicStroke(1));
			   }
			   else // fish swims to left side
			   {
				// Body of fish
				g.fillOval(x_front, y_front - size/4, size, size/2);

				// Tail of fish
				int[] x_t={x_front+size+size/4,x_front+size+size/4,x_front+size};
				int [] y_t = {y_front - size/4, y_front + size/4, y_front};
				Polygon t = new Polygon(x_t,y_t,3);		
				g.fillPolygon(t);

				// Eye of fish
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(new Color(255-colorfx.getRed(),255-colorfx.getGreen(),255-colorfx.getBlue()));
				g2.fillOval(x_front+size/10, y_front-size/10, size/10, size/10);
						
				// Mouth of fish
				if(size>70)
					g2.setStroke(new BasicStroke(3));
				else if(size>30)
					g2.setStroke(new BasicStroke(2));
				else
					g2.setStroke(new BasicStroke(1));
			      g2.drawLine(x_front, y_front, x_front+size/10, y_front+size/10);
			      g2.setStroke(new BasicStroke(1));
			      
			      
			   }
	}
		

		
		public void starter() {
			synchronized(this) {run();}
		}

		
		/**
		 * activate when the cyclic barrier activate and it's goal
		 *  to make the fish eat the warm in the center of the panel
		 * @throws InterruptedException
		 */
		public void centermove() throws InterruptedException {
	
		 if(x_front == center_x && y_front == center_y) {
			AquaPanel.food=false;
			setCyclic(false);
			eatInc();
			starter();
}

		 else {	 
			 if(x_front <=center_x && y_front <= center_y) {//I
				 	
				 x_dir=1;
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
				 x_dir=0;
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
				 x_dir=1;
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
				 x_dir=0;
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
					        }
					
					   }
			      }
			 }
		 }
		
		
	
		
		
		


	



}
