package ADTPackage;
import java.util.EmptyStackException;
	
    public class LinkedStack<T> implements StackInterface<T> {
    
        private Node topNode;
    
        public LinkedStack() {
            topNode = null;
        }
    
        /** 
         * @param newEntry
         */
        public void push(T newEntry) {
            Node newNode = new Node(newEntry, topNode);
            topNode = newNode;
            } // end push
        
        /** 
         * @return T
         */
        public T pop() {
            T top = peek(); // Might throw EmptyStackException
            // Assertion: topNode != null
            topNode = topNode.getNextNode();
            return top;
            } // end pop
        /** 
         * @return T
         */
        public T peek() {
                if (isEmpty())
                throw new EmptyStackException();
                else
                return topNode.getData();
                } // end peek
    
        
        /** 
         * @return boolean
         */
        public boolean isEmpty() {
            return topNode == null;
        }
    
        public void clear() { // change everything to null
            topNode = null;
        }
    
        private class Node {
            private T data;
            private Node next;
    
            private Node(T dataPortion) {
                this(dataPortion, null);
            }
    
            private Node(T dataPortion, Node nextNode) {
                data = dataPortion;
                next = nextNode;
            }
            private T getData()
            {
                return data;
            } // end getData
          
            private Node getNextNode()
            {
                return next;
            } // end getNextNode
            
           
        } // end Node

 }

