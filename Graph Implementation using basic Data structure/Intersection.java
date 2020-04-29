/**
 * 
 */

/**
 * @author Mayank
 *
 */
public class Intersection implements Comparable<Intersection>{

	private int x;
	private int y;
	
	
	
	/*
	 * Default Constructor 
	 */
	public Intersection() {
		// TODO Auto-generated constructor stub
	}

	
	
	/*
	 * Parameterized Constructor : Create object with provided x and y value.
	 */
	public Intersection(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	
	}


	/*
	 * return the value of x.
	 */
	public int getX() {
		return x;
	}


	/*
	 *  set the value to x.
	 */
	public void setX(int x) {
		this.x = x;
	}


	/*
	 * return the value of y.
	 */
	public int getY() {
		return y;
	}


	/*
	 * set the value to y.
	 */
	public void setY(int y) {
		this.y = y;
	}


	

	/*
	 * Converts the Object to String 
	 */
	@Override
	public String toString() {
		return  + x + "\t" + y   ;
	}

	
	
	
	/*
	 * Override the haseCode implementation
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	
	
	
	/*
	 * Overirde the equals implementation, to compare two Intersection based on the co-ordinates.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intersection other = (Intersection) obj;
		boolean result =false;
		if (x == other.x) {
			//result = true;
			if (y == other.y) {
				result = true;
			}else
				{result = false;}
		}
		else{
			result = false;
		}
		return result;
	}


	
	 @Override public int compareTo(Intersection o) 
	 { 
		 // comparing two objects with help of equal method
		 boolean result = this.equals(o); 
		 if (result) return 0; 
		 else return 1; 
	 }
	 



	
	
	
}
