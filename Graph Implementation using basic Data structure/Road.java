/**
 * @author Mayank
 *
 */
public class Road {

	private Intersection source;
	private Intersection destination;
	private int distance;
	
	/*
	 * @Default Constructor
	 */
	public Road() {
		// TODO Auto-generated constructor stub
	}
	
	

	/*
	 * @param source
	 * @param destination
	 * @param distance
	 */
	public Road(Intersection source, Intersection destination, int distance) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
	
	

	/*
	 *
	 * @param source
	 * @param destination
	 */
	public Road(Intersection source, Intersection destination) {
		super();
		this.source = source;
		this.destination = destination;
	}





	/*
	 * @return the source
	 */
	public Intersection getSource() {
		return source;
	}


	/*
	 * @param set the source
	 */
	public void setSource(Intersection source) {
		this.source = source;
	}


	
	
	/*
	 * @return the destination
	 */
	public Intersection getDestination() {
		return destination;
	}


	
	
	/*
	 * @param set the Destination
	 */
	public void setDestination(Intersection destination) {
		this.destination = destination;
	}


	
	
	/*
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}


	
	
	/*
	 * @param set the distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}




	/*
	 * Converting object to string datatype
	 */
	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + ", distance=" + distance + "]\n";
	}





	/*
	 * Override the haseCode implementation
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + distance;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}





	/*
	 * Override the equals implementation to compare two roads
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		if (destination == null && other.destination == null) {
			return false;
		}
		else if (source == null && other.source == null) {
			return false;
		}
		else
		{
			if (source.equals(other.source))
			{
				if (destination.equals(other.destination))
				{
					return true;
				}
				else
					return false;
			}
			else
				return false;
		} 
	}
		
}
