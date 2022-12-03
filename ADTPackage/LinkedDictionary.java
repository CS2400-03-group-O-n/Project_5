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
public class LinkedDictionary <K extends Comparable <? super K>, V> 
             implements DictionaryInterface<K, V>
{
	private Node firstNode; // Reference to first node of chain
	private int  numberOfEntries; 
	
	public LinkedDictionary()
	{
      initializeDataFields();
	} // end default constructor
	
   private void initializeDataFields() {
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
         
         while ( (currentNode != null) && (key.compareTo(currentNode.getKey()) > 0) )
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
   int keyIndex = locateIndex(key);
   
   if (keyIndex < numberOfEntries)
   {
   // Key found; remove entry and return its value
   result = dictionary[keyIndex].getValue();
   // Replace removed entry with last entry
   dictionary[keyIndex] = dictionary[numberOfEntries - 1];
   dictionary[numberOfEntries - 1] = null;
   numberOfEntries--;
   } // end if
   // Else result is null
   
   return result;
} // end remove


   
   /** 
    * @param key
    * @return V
    */
   public V getValue(K key) {
      // TODO Auto-generated method stub
      return null;
   }

   
   /** 
    * @param key
    * @return boolean
    */
   public boolean contains(K key) {
      // TODO Auto-generated method stub
      return false;
   }

   
   /** 
    * @return Iterator<K>
    */
   public Iterator<K> getKeyIterator() {
      // TODO Auto-generated method stub
      return null;
   }

   
   /** 
    * @return Iterator<V>
    */
   public Iterator<V> getValueIterator() {
      // TODO Auto-generated method stub
      return null;
   }

   
   /** 
    * @return boolean
    */
   public boolean isEmpty() {
      // TODO Auto-generated method stub
      return false;
   }

   
   
   /** 
    * @return int
    */
   public int getSize() {
      // TODO Auto-generated method stub
      return 0;
   }

   public void clear() {
      numberOfEntries =0;       
   }

   
   /* Private classes KeyIterator and ValueIterator (see Segment 21.20). >
   . . . */

   private class KeyIterator implements Iterator<K>
   {
      private KeyIterator()
      {
      
      } // end default constructor
      public boolean hasNext()
      {
      } // end hasNext
      public K next()
      {
         K result;
      if (hasNext())
         {
            result = hashTable[currentIndex].getKey();
            
         }
      else
            throw new NoSuchElementException();
      return result;
      } // end next
         public void remove()
         {
            throw new UnsupportedOperationException();
         } // end remove
   } // end KeyIterator


   private class ValueIterator implements Iterator<K>
   {
      private Node nextNode;

      private ValueIterator(){
         nextNode = firstNode;
      }
      public boolean hasNext() {
         // TODO Auto-generated method stub
         return false;
      }

      public K next() {
         // TODO Auto-generated method stub
         return null;
      }
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
		
