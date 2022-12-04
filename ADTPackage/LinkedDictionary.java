package ADTPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a chain of linked nodes.
   The dictionary is sorted and has distinct search keys.
   Search keys and associated values are not null.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedDictionary <K , V> 
             implements DictionaryInterface<K, V>
{
	private Node firstNode; // Reference to first node of chain
	private int  numberOfEntries; 
	
	public LinkedDictionary()
	{     
      initializeDataFields();
	} // end default constructor
	
   private void initializeDataFields() {
      firstNode = null;
      numberOfEntries=0;
   }

/** 
 * @param key
 * @param value
 * @return V
 */
/* Implementations of other methods in DictionaryInterface.
   . . . */

 public V add(K key, V value)
	{
		V result = null;
      if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to a dictionary.");
      else
      {
         // Search chain until you either find a node containing key
         // or locate where it should be
         Node currentNode = firstNode;
         Node nodeBefore = null;
         
         while ( (currentNode != null) && (key.equals(currentNode.getKey())) )
         {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
         } // end while
         
         if ( (currentNode != null) && key.equals(currentNode.getKey()) )
         {
            // Key in dictionary; replace corresponding value
            result = currentNode.getValue(); // Get old value
            currentNode.setValue(value);     // Replace value
         }
         else // Key not in dictionary; add new node in proper order
         {
            // Assertion: key and value are not null
            Node newNode = new Node(key, value); // Create new node
            
            if (nodeBefore == null)
            {                                    // Add at beginning (includes empty chain)
               newNode.setNextNode(firstNode);
               firstNode = newNode;
            }
            else                                 // Add elsewhere in non-empty chain
            {
               newNode.setNextNode(currentNode); // currentNode is after new node
               nodeBefore.setNextNode(newNode);  // nodeBefore is before new node
            } // end if

            numberOfEntries++;                   // Increase length for both cases
         } // end if
      } // end if

		return result;
	} // end add
   
   
   /** 
    * @param key
    * @return V
    */
   public V remove(K key) {
      V result = null;

      // Search chain until you either find a node containing key
      // or locate where it should be
      Node currentNode = firstNode;
      Node nodeBefore = null;

      while ( (currentNode != null) && (key.equals(currentNode.getKey())) )
         {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
         } // end while
         
      if ( (currentNode != null) && key.equals(currentNode.getKey()) )
         {
            // Key in dictionary; remove corresponding value
            result = currentNode.getValue(); // Get old value
            currentNode= currentNode.getNextNode();     // Replace value w/ next
         }
      
            // Assertion: key and value are not null
            Node newNode = currentNode.getNextNode();  // Create new node
            
            if (nodeBefore == null)
            {                                    
               firstNode = newNode;
            }
            else                                 
            {
               nodeBefore.setNextNode(newNode); // currentNode is after new node
            } // end if
            numberOfEntries--;               // decrease length for both cases

        return result;
   }  // end remove

   /** 
    * @param key
    * @return V
      Algorithm getValue(key)
      index = getHashIndex(key)
      Search the chain that begins at hashTable[index] for a node that contains key
      if (key is found)
      return value in found node
      else
      return null
    */
   public V getValue(K key) {
      V result = null;
      Node currNode= firstNode;
      while ( (currNode != null) && (key.equals(currNode.getKey())) )
      {
         currNode = currNode.getNextNode();
      } // end while
      
   if ( (currNode != null) && key.equals(currNode.getKey()) )
      {
         // Key in dictionary
         result = currNode.getValue(); // Get old value
      }
   return result;
   }
   
   /** 
    * @param key
    * @return boolean
    */
   public boolean contains(K key) {
      return false;
   }
   
   /** 
    * @return Iterator<K>
    */
   public Iterator<K> getKeyIterator() {
      return new KeyIterator();
   }

   /** 
    * @return Iterator<V>
    */
   public Iterator<V> getValueIterator() {
      return new ValueIterator();
      }

   /** 
    * @return boolean
    */
   public boolean isEmpty() {
      return false;
   }
   
   /** 
    * @return int
    */
   public int getSize() {
      return numberOfEntries;
   }

   public void clear() {
      numberOfEntries =0;       
   }

   
   /* Private classes KeyIterator and ValueIterator (see Segment 21.20). >
   . . . */

   private class KeyIterator implements Iterator<K>
   {
      private Node nextNode; // Link to next node

      private KeyIterator()
      {
       nextNode= firstNode;
      } // end default constructor

      public boolean hasNext()
      {
         return nextNode != null;
      } // end hasNext

      public K next()
      {
         K result;
         if (hasNext())
         {
            result = nextNode.getKey();
            nextNode = nextNode.getNextNode(); // Advance iterator
         }
         else{
            throw new NoSuchElementException("Illegal call to next(); " +
            "iterator is after end of list.");
         }
         return result; // Return next entry in iteration
      } // end next

      public void remove()
         {
            throw new UnsupportedOperationException();
         } // end remove
   } // end KeyIterator


   private class ValueIterator implements Iterator<V>
   {
      private Node nextNode;

      private ValueIterator(){
         nextNode = firstNode;
      }
      public boolean hasNext() {
         return nextNode != null;
      } // end hasNext
      

      public V next() {
         V result;
         if (hasNext())
         {
            result = nextNode.getValue();
            nextNode = nextNode.getNextNode(); // Advance iterator
         }
         else{
            throw new NoSuchElementException("Illegal call to next(); " +
            "iterator is after end of list.");
         }
         return result; // Return next entry in iteration
         } // end next

      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
   }

   /* < The private class Node > */

	private class Node
	{
		private K key;
		private V value;
		private Node next;

      private Node(K searchKey, V dataValue)
         {
            key = searchKey;
            value = dataValue;
            next = null;
         } // end constructor

         private Node(K searchKey, V dataValue, Node nextNode)
         {
            key = searchKey;
            value = dataValue;
            next = nextNode;
         } // end constructor
   
    private K getKey()
    {
    return key;
    } // end getKey

    private V getValue()
    {
    return value;
   } // end getValue

    private void setValue(V newValue)
    {
    value = newValue;
    } // end setV
   
    // end entry
    private Node getNextNode()
    {
      return next;
    }

    private void setNextNode(Node nextNode)
    {
      next = nextNode;
    }
     // end entry

   } // end node 

} // end SortedLinkedDictionary