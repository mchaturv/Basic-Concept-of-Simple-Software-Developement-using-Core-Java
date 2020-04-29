public class LinkedList {

	private int counter;
	private Node head;

	// Default constructor
	public LinkedList() {
		head = null;
		counter = 0;
	}

	
	// Appends the specified element after the node in parameter "nodebeforeInsert"
	public Node add(Object data, Node nodebeforeInsert) {
		Node nodeInsert = new Node(data);
		Node currentNode = nodebeforeInsert;

		// if current node is not null
		if (currentNode != null) {
			nodeInsert.setNext(nodebeforeInsert.getNext());
			nodebeforeInsert.setNext(nodeInsert);
		}

		// if current node is null , key need to be added as head of the new list.
		else {
			nodeInsert.setNext(head);
			head = nodeInsert;
		}

		counter++;
		return nodeInsert;

	}

	
	
	
	// appends the specified element to the list in sorted way if "InsertafterNode" is not provided
	public Node add(Object data) {

		boolean result = false;
		Node returnNode = null;
		// Initialize Node only incase of 1st element
		if (head == null) {
			head = new Node(data);
			result = true;
			counter++;
			returnNode = head;

		} else {

			Node currentNode = head;
			int index = 0;
			// starting at the head node, crawl to the end of the list and then add element
			// after last node
			while (currentNode != null) {
				int compare = data.toString().compareToIgnoreCase(currentNode.getData().toString());
				if (compare < 0) {
					returnNode = add(data, index);
					result = true;
					break;
				} else if (compare > 0) {
					currentNode = currentNode.getNext();
					index++;
				} else if (compare == 0) {
					result = true;
					returnNode = new Node();
					break;
				}

			}
			if (!result) {
				returnNode = add(data, index);
			}

		}
		return returnNode;
	}

	
	
	
	// Get the Head of the list i.e first Element
	public Node getHead() {
		return head;
	}

	
	
	// Set the Head of the list i.e first Element
	public void setHead(Node head) {
		this.head = head;
	}

	
	
	// returns the size i.e number of elements in this list.
	public int size() {
		return counter;
	}

	
	
	// Converts LinkedList Object to string
	public String toString() {
		String output = "";

		if (head != null) {
			Node currentNode = head;
			while (currentNode != null) {
				output += "[" + currentNode.getData().toString() + " , NextNode -> " + currentNode.getNext()
						+ " , LowerNext -> " + currentNode.getLowerNext() + "]";
				currentNode = currentNode.getNext();
			}

		}
		return output;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// inserts the specified element at the specified position in this list
	public Node add(Object data, int index) {
		Node nodeInsert = new Node(data);
		Node currentNode = head;
		Node tempNode = head;

		// System.out.println(data);
		// Let's check for NPE before iterate over crunchifyCurrent
		if (currentNode != null) {

			if (index == 0) {
				nodeInsert.setNext(head);
				head = nodeInsert;
			} else {
				// crawl to the requested index or the last element in the list, whichever comes
				// first
				for (int i = 0; i < index && currentNode != null; i++) {
					tempNode = currentNode;
					currentNode = currentNode.getNext();
				}
				if (tempNode == head) {
					nodeInsert.setNext(tempNode.getNext());
					tempNode.setNext(nodeInsert);
					nodeInsert.setPrev(tempNode);

				} else {
					tempNode.setNext(nodeInsert);
					nodeInsert.setPrev(tempNode);
					nodeInsert.setNext(currentNode);
				}
			}
		}

		counter++;
		return nodeInsert;

	}

}