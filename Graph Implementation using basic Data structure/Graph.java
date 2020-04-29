import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author Mayank
 *
 */
public class Graph {

	// Set of all the intersection available in graph.
	private HashSet <Intersection> intersections;
	
	// Set of all Roads available in graph.
	private HashSet <Road> roads;
	
	// Set to store all the visited node while navigating from source to destination
	private Set<Intersection> visitedIntersections;
	
	// Set to store all the UnVisited node while navigating from source to destination
    private Set<Intersection> unvisitedIntersections;
    
    // Map to store the path.
    private Map<Intersection, Intersection> predecessors;
    
    // Map to store the next possible intersection with calculated distance.
    private Map<Intersection, Integer> distance;
	
    
    
	/*
	 * Default Constructor, initializes set of Intersection and Road when Called(object) is created.
	 */
	public Graph() {
		// TODO Auto-generated constructor stub
		this.intersections = new HashSet <Intersection>();
		this.roads = new HashSet<Road>();
	}
	
	
	
	/*
	 * Method : to find the shortest path between @param1 : source and @param2 : Destination
	 * @return : LinkedList<Intersection> i.e. PATH
	 */
	public LinkedList<Intersection> findShortestPath(Intersection source, Intersection target)
	{
		visitedIntersections = new HashSet<Intersection>();
		unvisitedIntersections = new HashSet<Intersection>();
        distance = new HashMap<Intersection, Integer>();
        predecessors = new HashMap<Intersection, Intersection>();
        Intersection closestNode = null;
        
        // adding source to distance map
        distance.put(source, 0);
        // adding source to Unvisited set
        unvisitedIntersections.add(source);
        
        while (unvisitedIntersections.size() > 0  ) {
        	// finding the intersection available in Unvisited Set with minimal possible distance from source.
        	closestNode = getClosest(unvisitedIntersections);
        	
        	// adding the current minimal distance node to visited.
        	visitedIntersections.add(closestNode);
        	
        	// removing the current minimal distance node from unvisited.
        	unvisitedIntersections.remove(closestNode);
        	
        	// call find shortest distance method to find next possible closest intersection to current intersection.
            findShortestDistance(closestNode);
        }
        
        LinkedList<Intersection> path = new LinkedList<Intersection>();
        Intersection oneStop = target;
        // check if a path exists
        if (predecessors.get(oneStop) == null) {
            return null;
        }
        // adding target to path
        path.add(oneStop);
        
        // Iterate while Source is added in the list
        while (predecessors.get(oneStop) != null) {
        	oneStop = predecessors.get(oneStop);
            path.add(oneStop);
        }
        // Put it into the correct order - starting from source to destination
        Collections.reverse(path);
        
        // return the path
        return path;
	}
	
	
	
	/*
	 * Find the Node out of the set of intersection, which would be next closest(at a minimal) distance from the source, if traveled.
	 */
	private Intersection getClosest(Set<Intersection> Intersections) {
		Intersection minimum = null;
		for (Intersection Intersection : Intersections) {
			if (minimum == null) {
				minimum = Intersection;
			} else {
				
				// comparing each other distance to find out the minimal distance and corresponding intersection
				if (getMinimalDistance(Intersection) < getMinimalDistance(minimum)) {
					minimum = Intersection;
				}
			}
		}
		return minimum;
	}
	
	
	
	
	/*
	 * @param : Intersection(destination)
	 * To find out the shortest distance to destination
	 */
	private int getMinimalDistance(Intersection destination) {
        Integer length = distance.get(destination);
        if (length == null) {
            return Integer.MAX_VALUE;
        } else {
            return length;
        }
    }
	
	
	
	/*
	 * @param : Intersection(node)
	 * To find out the next possible neighbor at shortest distance, and traversing through that neighbour node
	 */
	private void findShortestDistance(Intersection node) {
		List<Intersection> neighbors = new ArrayList<Intersection>();
		
		// finding the neighbors of provided intersection and creating list of those neighbor.
        for (Road road : roads) {
            if (road.getSource().equals(node)
                    && !(visitedIntersections.contains(road.getDestination()))) {
                neighbors.add(road.getDestination());
            }
        }
        
        // Iterating through neighbor list to find out the closest neighbor.
		for (Intersection target : neighbors) {
			if (getMinimalDistance(target) > getMinimalDistance(node) + getDistance(node, target)) {
				
				//make entry of closest neighbor to the Distance map
				distance.put(target, getMinimalDistance(node) + getDistance(node, target));
				
				//make entry of closest neighbor to the path(predecessors) map
				predecessors.put(target, node);
				
				// adding the closest neighbor to unvisited Intersection.
				unvisitedIntersections.add(target);
			}
		}

	}
	
	
	/*
	 * @return the distance between source and destination intersection.
	 */
	private int getDistance(Intersection source, Intersection target) {
		int distance = 0;
		for (Road road : roads) {
			if (road.getSource().equals(source) && road.getDestination().equals(target)) {
				distance = road.getDistance();
			}
		}
		return distance;
	}
	
	
	
	
	/**
	 * @return set of all the Intersections
	 */
	public Set<Intersection> getIntersection() {
		return intersections;
	}
	
	
	/**
	 * @param set all the Intersection
	 */
	public void setIntersection(HashSet<Intersection> vertices) {
		this.intersections = vertices;
	}
	
	
	/**
	 * @return the set of roads
	 */
	public Set<Road> getRoads() {
		return roads;
	}
	
	
	/**
	 * @param set the, set of roads.
	 */
	public void setRoads(HashSet<Road> edges) {
		this.roads = edges;
	}
	
	
	
	
	/*
	 * Implement toString to get the Object in form of String
	 */
	@Override
	public String toString() {
		return "Graph [Intersection=" + intersections + ", Roads=" + roads + "]";
	}
	
	
	
	
	/*
	 * Override the haseCode implementation
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roads == null) ? 0 : roads.hashCode());
		result = prime * result + ((intersections == null) ? 0 : intersections.hashCode());
		return result;
	}
	
	
	
	/*
	 * Override the equals to compare two graphs
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (roads == null) {
			if (other.roads != null)
				return false;
		} else if (!roads.equals(other.roads))
			return false;
		if (intersections == null) {
			if (other.intersections != null)
				return false;
		} else if (!intersections.equals(other.intersections))
			return false;
		return true;
	}
	
	
	

}
