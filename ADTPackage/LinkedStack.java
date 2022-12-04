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
            topNode = new Node(newEntry, topNode);
        }
    
        
        /** 
         * @return T
         */
        public T pop() {
            if (isEmpty())
                throw new EmptyStackException();
    
            T top = topNode.data;
            topNode = topNode.next;
            return top;
        }
    
        /** 
         * @return T
         */
        public T peek() {
            if (isEmpty())
                throw new EmptyStackException();
            return topNode.data;
        }
    
        
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
        }
    }
