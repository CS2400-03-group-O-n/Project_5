package ADTPackage;
/**
   A class that implements a queue of objects by using
   a chain of linked nodes that has both head and tail references.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class LinkedQueue<T> implements QueueInterface<T>
{
   private Node firstNode; // References node at front of queue
   private Node lastNode;  // References node at back of queue
  	
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor

//  < Implementations of the queue operations go here. >
//  . . .
	public void enqueue(T newEntry)
	{

	}

	public T dequeue()
	{

	}

	
	public T getFront()
	{

	}


	public boolean isEmpty()
	{

	}

	public void clear()
	{

	}


	private class Node
	{
		private T    data; // Entry in queue
		private Node next; // Link to next node
      
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor
		
		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor
      
		private T getData()
		{
			return data;
		} // end getData
      
		private void setData(T newData)
		{
			data = newData;
		} // end setData
      
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node

	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
} // end LinkedQueue
