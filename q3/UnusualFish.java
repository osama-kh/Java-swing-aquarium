package q3;
/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */
/*
 * UnusualFish class and its father is Fish
 * to describe the UnusualFish details
 * and there is a new variable and it is factor  
 * 
 */
public class UnusualFish extends Fish{

	private int factor;
	/**
	 * constructor UnusualFish to set all the object data 
	 * @param size1
	 * @param x_front1
	 * @param y_front1
	 * @param h
	 * @param v
	 * @param col1
	 * @param f
	 */
	public UnusualFish(int size1,int x_front1,int y_front1,int h, int v, int col1,int f) {
		super( size1, x_front1, y_front1, h, v, col1);
		this.factor=f;
}
	/**
	 * getters and sitters
	 * @return
	 */
	public int getSize() {
		return factor*this.size;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

}
