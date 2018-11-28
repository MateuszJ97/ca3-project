package Package;
// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface {
  // reference to linked list of items
  private Node head; 
  private int numItems; // number of items in list

  public ListReferenceBased() {
	  numItems = 0;  // declares numItems is 0
	  head = null;   // declares head is null
  }  // end default constructor

  public boolean isEmpty() {
	  return numItems == 0;  // returns boolean to allow the checking of an empty list
  }  // end isEmpty

  public int size() {
	  return numItems;
  }  // end size

  private Node find(int index) {
	  Node curr = head;
	  for (int i = 1; i < index; i++) {
		  curr = curr.getNext();
	  }
	  return curr;
	  }
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 1 <= index <= numItems+1 
  // Postcondition: Returns a reference to the desired 
  // node.
  // --------------------------------------------------
   // end find

  public Object get(int index) 
                throws ListIndexOutOfBoundsException {
					if (index >= 0 && index <= numItems) { // If statement to catch out of bounds exception
						  Node curr = head;                // states curr is at head posistion
						  for (int i = 1; i < index; i++) { // for loop to get to the current posistion that is equivelnt to i
							  curr = curr.getNext();
						  }
						  return curr.getItem(); // returns item in current node
						  }
					else {
						  throw new ListIndexOutOfBoundsException ("List index out of bounds"); // else throws an index out of bounds exception
					}
  }
  // end get

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException {
	  if (index >= 0 && index <= numItems) { 			// if statement to catch out of bounds exception
		  if (index ==0) { 									// If index is 0, this means there is no head, so a head must be referenced 
			  Node newNode = new Node( item, head); 		// creates a new node
			  head = newNode; 								// declares new node as the head of a list
		  } 
		  
		  else { 
			  
			  Node prev = find(index -1);					// else loop for adding to any other node that is not the head
			  Node newNode = new Node(item, prev.getNext());//declares new node
			  prev.setNext(newNode); 						// sets next reference for previous node to the new node that has been created
		  }
		  numItems++;										// add one to numItems
	  } else {
		  throw new ListIndexOutOfBoundsException ("List index out of bounds"); // else throws an index out of bounds exception
	  }
  }  // end add


  public void remove(int index) 
                   throws ListIndexOutOfBoundsException {
	  if (index >= 0 &&  index <= numItems) { 				// if statement to catch out of bounds exception
		  if (index == 0) {									// if statement to find if the node to be removed is the head
			  head = head.getNext();						// declares head is now the next node in the list.
		  } 
		  
		  else {											// else statement for any other node that is not head
			  Node prev = find(index- 1 );                 	// finds the previous node at index - 1
			  Node curr = prev.getNext();					// states curr node is the node following prev
			  prev.setNext(curr.getNext());					// sets reference of previous node to the next node after curr
		  }
		  numItems --;										// removes 1 from numItems
	  } else {
		  throw new ListIndexOutOfBoundsException ("List index out of bounds");
	  }
  }   // end remove

  public void removeAll() {
	  numItems=0;
	  head = null;
    // setting head to null causes list to be
    // unreachable and thus marked for garbage 
    // collection
  } // end removeAll

public void display() {
		
	for(Node curr = head; curr!= null; curr= curr.getNext()) {
		System.out.println(curr.getItem());
	}
	}
}
	// TODO Auto-generated method stub
	// end ListReferenceBased