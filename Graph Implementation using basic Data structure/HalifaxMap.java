import java.util.LinkedList;

/**
 * @author Mayank
 * 
 * Provides three methods:
 * "newIntersection" : To add any new, non existing Intersection into graph.
 * "defineRoad" : To add any new, non existing Road to graph.
 * "navigate" : To navigate in the graph from source to destination and return the shortest path, if any exist.
 */
public class HalifaxMap {

	
	Graph halifaxMap;
	
	/**
	 * Default Constructor
	 */
	public HalifaxMap() {
		// TODO Auto-generated constructor stub
		this.halifaxMap = new Graph();
	}

	/**
	 * @param halifaxMap
	 */
	public HalifaxMap(Graph halifaxMap) {
		super();
		this.halifaxMap = halifaxMap;
	}
	
	
	
	
	
	/**
	 * @param x,y :  takes the x and y coordinate of the Intersection
	 * add the Intersection to the graph.
	 */
	public Boolean newIntersection(int x, int y)
	{
		boolean result;
		try {
			// create a new intersection
			Intersection newVertex = new Intersection(x, y);
			
			// add the new Intersection to the graph.
			result = halifaxMap.getIntersection().add(newVertex);
		}
		catch (Exception e) {
			result = false;
		}
		return result;	
	}
	
	
	
	
	
	/**
	 * @param Source and Destination Intersection
	 * Defines a road between source and destination, if possible.
	 */
	public Boolean defineRoad(int x1, int y1, int x2, int y2)
	{
		boolean result = false;
		try {
			Intersection source = new Intersection (x1,y1);
			Intersection destination = new Intersection (x2,y2);
			if (halifaxMap.getIntersection().contains(source) && halifaxMap.getIntersection().contains(destination) && !source.equals(destination))
			{
				// Calculating the Distance.
				int distance = (int) Math.round(Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2)));
				//Storing the Road into the Graph.
				result = halifaxMap.getRoads().add(new Road(source,destination,distance))&&halifaxMap.getRoads().add(new Road(destination,source,distance));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			result = false;
		}
		return result;
	}
	
	
	
	
	/**
	 * @param Source and Destination Intersection
	 * Navigate between source and destination and find shortest path , if any exist.
	 */
	public void navigate(int x1, int y1, int x2, int y2)
	{
		
		try {
		Intersection source = new Intersection(x1,y1);
		Intersection destination = new Intersection(x2,y2);
		LinkedList<Intersection> path;
		
		// if source and destination are known and available in map
		if (halifaxMap.getIntersection().contains(source) && halifaxMap.getIntersection().contains(destination))
		{
			// if source and destination are different
			if(!source.equals(destination)) {
				// call the "findShortestPath" method of the graph to find out shortest path.
				path = halifaxMap.findShortestPath(source, destination);
				
				// check if path return is not null i.e path exist
				if (path!=null)
				{
					// printing the path
					for(Intersection stops : path)
					{
						System.out.println(stops);
					}
					System.out.println();
				}
				// if path doesn't exist
				else
				{
					System.out.println("No Path.");
				}
			}
			// if destination is same as source.
			else {
				System.out.println(source);
				System.out.println(destination);
			}
		}
		
		// if source and destination are unknown and not available in map
		else
		{
			System.out.println("No Path.");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("No Path.");
		}
		
	}

	
}
