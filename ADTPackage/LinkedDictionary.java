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
public class LinkedDictionary <K, V> 
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
          algorithm:  public T remove()
         {
         T result = null;
         if (firstNode != null)
         {
         result = firstNode.data;
         firstNode = firstNode.next; // Remove first node from chain
         numberOfEntries--;
         } // end if
         return result;
         } // end remove

         Algorithm remove(key)
         // Removes an entry from the dictionary, given its search key, and returns its value.
         // If no such entry exists in the dictionary, returns null.
         result = null
         Search the array for an entry containing key
         if (an entry containing key is found in the array)
         {
         result = value currently associated with key
         Replace the entry with the last entry in the array
         Set array element containing last entry to null
         Decrement the size of the dictionary
         }
         // Else result is null
         return result
    */
   public V remove(K key) {
      V result = null;

      // Search chain until you either find a node containing key
      // or locate where it should be
      
             Node currentNode = firstNode;
             Node nodeBefore = null;
            // Key in dictionary; remove corresponding value

         while ( (currentNode != null) && (key.equals(currentNode.getKey())) )
         {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
         } // end while
            // Assertion: key and value are not null
      
         if(currentNode != null )
            {
               result = currentNode.getValue();
               currentNode = currentNode.getNextNode();
               nodeBefore.setNextNode(currentNode);  // 
               numberOfEntries--;               // decrease length for both cases
            } // end if
         else{
         return result=null; 
         }

        return result;
   }  // end remove

   /** 
    * @param key
    * @return V
      Algorithm getValue(key)
    */
   public V getValue(K key) {
      V result = null;
      Node currNode= firstNode;
      while ( (currNode != null) && (!key.equals(currNode.getKey())) )
      {
         currNode = currNode.getNextNode();
      } // end while
      
     if ( (currNode != null) )
      {
         // Key in dictionary
         result = currNode.getValue(); // Get old value
      }
   return result;
   }
   
   /** Sees whether a specific entry is in this dictionary.
       @param key  An object search key of the desired entry.
       @return  True if key is associated with an entry in the dictionary. */
   public boolean contains(K key) {
		return getValue(key) != null;
   } // end contains
   
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
      return isEmpty();
   }
   
   /** 
    * @return int
    */
   public int getSize() {
      return numberOfEntries;
   }

   public void clear() {
      initializeDataFields();
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
         }
         // end constructor

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