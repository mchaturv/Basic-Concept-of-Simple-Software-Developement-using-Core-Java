public class Node {

	// data carried by this node. could be of any type you need.
	Object data;

	// reference to the next node in the chain, or null if there isn't one.
	Node next;
	Node prev;
	
	// reference to the lower node in the lower level, or null if there isn't one.
	Node lowerNext;
	
	// reference to the upper node in the upper level, or null if there isn't one.
	Node upperNext;
	

	//default Constructor
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Node constructor
	public Node(Object dataValue) {
		next = null;
		data = dataValue;
	}

	// another Node constructor if we want to specify the node to point to some node.
	public Node(Object dataValue, Node nextValue) {
		next = nextValue;
		data = dataValue;
	}

	
	// these method should get data of any node
	public Object getData() {
		return data;
	}
	
	
	// these method should set data of any node
	public void setData(Object dataValue) {
		data = dataValue;
	}

	
	// these method should get next element of any node
	public Node getNext() {
		return next;
	}

	
	// these method should set next element of any node
	public void setNext(Node nextValue) {
		next = nextValue;
	}

	
	// these method should get previous element of any node
	public Node getPrev() {
		return prev;
	}

	
	// these method should set previous element of any node
	public void setPrev(Node prev) {
		this.prev = prev;
	}

	
	// these methods should get reference to lower node on lower level of any node
	public Node getLowerNext() {
		return lowerNext;
	}
	
	
	// these methods should set reference to lower node on lower level of any node
	public void setLowerNext(Node lowerNext) {
		this.lowerNext = lowerNext;
	}
	
	
	// these methods should get reference to upper node on upper level of any node
	public Node getUpperNext() {
		return upperNext;
	}

	
	// these methods should set reference to upper node on upper level of any node
	public void setUpperNext(Node upperNext) {
		this.upperNext = upperNext;
	}
	
	
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	



	
	

}
