
/* Implements the functionality of 
	1. Adding the key received to the DataStructure and 
	2. Searching the key received to the DataStructure.
*/

public class ListHierarchy {

	// "SetofLinkedList" Object that contains the Hierarchy of the List(on different level)
	public static SetofLinkedList setofList = new SetofLinkedList();
	private static Coin coin;
	private static Node insertAfterNode;
	//private static Node upperLevelReference; 
	
	//Constructor to initialize the ListHierarchy object and initialize the coin and setodLinkedList attribute.
	ListHierarchy( Coin flip ) {
		coin = flip;
		setofList = new SetofLinkedList();
	}
	
	/*
	  - We find if element is available or not, going from topmost level to lowermost.
	  - If not found Start adding the key to the lowermost level, once
	  	added we check for the availability for any level above the current level. 
	  - We Flip the Coin until the point where you reach the topmost level and key is
	    the only element available on the list.
	  - Fliping the coin generates either 0 or 1,
	  - if 1 is returned from coin flip, add the element to the upper level.
	  - Check if you are at the topmost level, with the just key as the only element in the list.Stop the flip and exit.
	  - If Not, keep flipping the coin.
	  - if 0 is returned don't add it to the upper level. Don't flip the coin further and exit.
	 */
	public static boolean add( String key ) {
		
		Node lowerListNodeReference = null;
		//check if key passed is not empty or null
		if(key!=null&&!key.isEmpty())
		{
			//check if setofList is new and no list(level) is available
			if(setofList!=null && setofList.size()!=0)
			{
				
				boolean searchresult = false;
				
				// take the LowerMostLevel through tail(attribute of setofLinkedList pointing to last element)
				Node lowerMostLevel = setofList.getTail();
			
				// Take the List from the last Node(lowerMost level)
				LinkedList temp = (LinkedList) lowerMostLevel.getData();
				
				/* Call find method to search for the key. Search will start from topmost going to lowermost key.
				 * return false if key is not found.
				 * before returning find method set variable "insertAfterNode" variable to the node,
				 * after which new key needs to be inserted
				 */
				
				searchresult=find(key);
				if(!searchresult)
				{
					lowerListNodeReference=temp.add(key, insertAfterNode);
				
				
					int flipValue = coin.flip();
					// if flip of coin returns 1
					while(flipValue==1)
					{
						Node previousnode = lowerMostLevel.getPrev();
						
						/* if any upper level is available to current.
						 * add the key to upper level(list) and point that node to node containing same element at lower level(list).
						 * flip the coin again
						 */
						if(previousnode!=null)
						{
							LinkedList previousList = (LinkedList) previousnode.getData();
							Node linkNode = lowerListNodeReference;
							lowerListNodeReference=previousList.add(key);
							lowerListNodeReference.setLowerNext(linkNode);
							lowerMostLevel=previousnode;
							flipValue = coin.flip();
						}
						
						/* if any upper level is not available to current.
						 * create a new level(list) and add the key to the level(list) and point that node to node containing same element at lower level(list).
						 * do not flip the coin and exit
						 */
						else
						{
							LinkedList newList = new LinkedList();
							Node linkNode = lowerListNodeReference;
							lowerListNodeReference= newList.add(key);
							lowerListNodeReference.setLowerNext(linkNode);
							setofList.add(newList);
							break;
						}						
					}
				}
			}
			
			/*if there are no level is hierarchy of list and first element is being added*/
			else
			{
				LinkedList newList = new LinkedList();
				newList.add(key);
				setofList.add(newList);
			}
			return true;
		}
		else return true;
	}
	
	
	
	
	
	/*
	 * This method is for searching the element provided by performing the below algorithm 
	  - To search any element say it start searching for the element availability in the topmost list 
	  - If found- don't proceed further. Return true.
	  - If not found, it takes the range of elements in topmost level within which the element 
	    could have been there(alphabetically). 
	  - It follow the link of range of element found to the next lower level. This Narrows down our search range.
	  - It continue the search until the element is found or it reach the Lowermost level.
	  - if the search is completed at the lowermost level also and the key couldn't be found. Return False.
	 */	
	
	
	public static boolean find( String key ) {
		
		SetofLinkedList setToBeSearched = setofList;
		boolean foundFlag = false;
	
		// check key to be searched is not null and not empty
			if(key!=null && !key.isEmpty())
			{
				// Take the top most level of hierarchy through "head" attribute
				Node head = setToBeSearched.getHead();
				Node currentNode = head;
	
				Node startOffset =null, endOffset = null;
				Node current = null;
				
				//Iterate through hierarchy until the lower most level
				while(currentNode!=null)
				{
					// get the list available at the current level
					LinkedList currentList = (LinkedList)currentNode.getData();
					
					// if it is the topmost level find the first node of the list , assign it to current.
					if(currentNode == head)
					{
						current = currentList.getHead(); 
					}
					
					// iterate through the list at current level from Current to offset
					while(current != endOffset)
					{
						// Compare the String to find whether the key is available.
						int result=(key.compareToIgnoreCase(current.getData().toString()));
						
						//if key is found, set the flag to true and exit
						if (result == 0) {
							foundFlag = true;
							break;
							} 
						
						/* if key is greater than current element in the list.
						 * make "startOffset" variable  to current 
						 */
						else if ( result > 0) {
							startOffset  = current;
							current= current.getNext();
							} 
						
						/* if key is smaller then current element.
						 * make the "endoffset" variable  to current*/
						else {
							endOffset=current;
							foundFlag=false;
							break;
							}
						//System.out.println("PreviousIndex =" +startOffset.getData() + "////// nextIndex = " + endOffset.getData().toString() +" .");
					}
					
					// If foundFlag is true, break the iteration and return true.
			        if(foundFlag) {
			        	//System.out.println("found");
			        	break;
			        }
			        // after search on one level is completed and foundFlag is still false
			        else {
			        	
			        	//System.out.println("PreviousIndex =" +startOffset + "//"+startOffset.getData()+"//"+startOffset.getNext()+"//"+startOffset.getPrev()+"//"+startOffset.getLowerNext()+"//--//endOffset =" +endOffset + "//"+endOffset.getData()+"//"+endOffset.getNext()+"//"+endOffset.getPrev()+"//"+endOffset.getLowerNext());
			        	// if there are still level below current level.
			        	if(currentNode.getNext()!=null) {
			        		
			        		// if element to be searched should fall after first element of current list
				        	if(startOffset!=null) 
				        	{	
				        		// set the current to node pointed to startoffset lower node reference. same Current would be used as starting point for search in next lower level
				        		current = startOffset.getLowerNext();
				        		
				        		// set upperlevelReference to backtrack while adding
				        		//upperLevelReference = current;
				        	}
				        	// if element to be searched should fall before first element of current list
							else {
								
								LinkedList templist = (LinkedList) currentNode.getNext().getData();	
								
								// set the current to head. same Current would be used as starting point for search in next lower level
								current = templist.getHead();
								
								// set upperlevelReference to backtrack while adding
								//upperLevelReference = current;
							}
				        	
				        	if(endOffset!=null)	
				        	{endOffset = endOffset.getLowerNext();
				        	
				        	}
			        	}
			        	else 
			        		{current=startOffset;
			        		}
						
			        	//System.out.println("PreviousIndex =" +current + "//"+current.getData()+"//"+current.getNext()+"//"+current.getPrev()+"//"+current.getLowerNext()+"//--//endOffset =" +endOffset + "//"+endOffset.getData()+"//"+endOffset.getNext()+"//"+endOffset.getPrev()+"//"+endOffset.getLowerNext());
				        // Go to Next lower level
			        	currentNode = currentNode.getNext();
			        }
			        
				}
				//System.out.println("Start :" +current+ " , End :" +endOffset);
				insertAfterNode = startOffset;
			}
	
			return foundFlag;
	}
	
	
	// Printing the Hierarchy of list
	public void print()
	{
		System.out.println(setofList);
	}
}
