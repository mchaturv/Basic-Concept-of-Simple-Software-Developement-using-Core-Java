
public class SetofLinkedList {

	private static int counter;
	private Node head;
	private Node tail;

	// Default constructor
	public SetofLinkedList() {
		counter = 0;
	}

	// appends the specified element to the start/Head  of this list.
	public boolean add(Object data) {

		boolean result = false;
		// Initialize Node only in case of 1st element
		if (head == null) {
			head = new Node(data);
			tail = head;
			result = true;
			counter++;
		// Initialize Node only in case of list is not empty
		} else {
			Node tempNode = new Node(data);
			Node currentNode = head;
			tempNode.setNext(currentNode);
			currentNode.setPrev(tempNode);
			head = tempNode;
			result = true;
			counter++;
		}
		return result;
	}

	// Knowing the size of list. Return the counter.
	public int size() {
		return counter;
	}
	
	// returns the head of the Set of Linked List i.e topMost element in this list.
	public Node getHead() {
		return head;
	}
	
	// set the head of the Set of Linked List i.e topMost element in this list.
	public void setHead(Node head) {
		this.head = head;
	}

	// Get the tail of the Set of Linked List i.e lower Most element in this list.
	public Node getTail() {
		return tail;
	}

	// set the tail of the Set of Linked List i.e lower Most element in this list.
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	// Convert SetofLinkedList object to string.
	public String toString() {
		String output = "Elements Are :\n";
		int i = 1;
		if (head != null) {
			Node crunchifyCurrent = head;
			while (crunchifyCurrent != null) {

				output += i + ". [---" + crunchifyCurrent.getData().toString() + "---] \n";
				crunchifyCurrent = crunchifyCurrent.getNext();
				i++;
			}

		}
		return output;
	}

	
	
	
}