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

/* Implementations of other methods in DictionaryInterface.
   . . .
   Private classes KeyIterator and ValueIterator (see Segment 21.20). >
   . . . */

   private class KeyIterator implements Iterator<K>
   {
   private int currentIndex; // Current position in hash table
   private int NumberLeft; // Number of entries left in iteration
   private KeyIterator()
   {
   currentIndex = 0;
   numberLeft = numberOfEntries;
   } // end default constructor
   public boolean hasNext()
   {
   return numberLeft > 0;
   } // end hasNext
   public K next()
   {
   K result = null;
   if (hasNext())
   {
   // Skip table locations that do not contain a current entry
   while ( (hashTable[currentIndex] == null) ||
   hashTable[currentIndex] == AVAILABLE )
   {
   currentIndex++;
   } // end while
   result = hashTable[currentIndex].getKey();
   numberLeft--;
   currentIndex++;
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
   }



	private class Node
	{
		private K key;
		private V value;
		private Node next;
   
   } // end Node



   public V remove(K key) {
      // TODO Auto-generated method stub
      return null;
   }

   public V getValue(K key) {
      // TODO Auto-generated method stub
      return null;
   }

   public boolean contains(K key) {
      // TODO Auto-generated method stub
      return false;
   }

   public Iterator<K> getKeyIterator() {
      // TODO Auto-generated method stub
      return null;
   }

   public Iterator<V> getValueIterator() {
      // TODO Auto-generated method stub
      return null;
   }

   public boolean isEmpty() {
      // TODO Auto-generated method stub
      return false;
   }

   
   public int getSize() {
      // TODO Auto-generated method stub
      return 0;
   }

   public void clear() {
      // TODO Auto-generated method stub
      
   }


/*    Constructors and the methods getKey, getValue, setValue, getNextNode,
      and setNextNode are here. There is no setKey.
      . . . */



      
	
} // end SortedLinkedDictionary
		
