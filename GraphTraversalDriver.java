import GraphPackage.*;
import ADTPackage.*;

public class GraphTraversalDriver 
{
    public static void main(String [] args)
    {
    System.out.println("\nThe graph: {V, E} where\nV = { A, B, C, D, E, F, G, H, I }");
    System.out.println("E = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }\n");

    BasicGraphInterface<String> graphTraversal = new DirectedGraph<> ();
    
    graphTraversal.addVertex("A");
    graphTraversal.addVertex("B");
    graphTraversal.addVertex("C");
    graphTraversal.addVertex("D");
    graphTraversal.addVertex("E");
    graphTraversal.addVertex("F");
    graphTraversal.addVertex("G");
    graphTraversal.addVertex("H");
    graphTraversal.addVertex("I");

    graphTraversal.addEdge("A", "B", 5.0);
    graphTraversal.addEdge("A", "D",7.0);
    graphTraversal.addEdge("A", "E", 8.0);
    graphTraversal.addEdge("B", "E", 8.0);
    graphTraversal.addEdge("D", "G", 9.0);
    graphTraversal.addEdge("E", "F", 8.0);
    graphTraversal.addEdge("E", "H",5.0);
    graphTraversal.addEdge("G", "H", 0.0);
    graphTraversal.addEdge("F", "C",5.0);
    graphTraversal.addEdge("F", "H",3.0);
    graphTraversal.addEdge("H", "I",1.0);
    graphTraversal.addEdge("C", "B",7.0);
    graphTraversal.addEdge("I", "F",1.0);

    System.out.println("The breadth-first traversal of the graph: \n");
    QueueInterface<String> breadthGraph = graphTraversal.getBreadthFirstTraversal("A");
    System.out.println(breadthGraph.dequeue());

    System.out.println("The depth-first traversal of the graph: \n");

    System.out.println("The breadth-first tree: \n");

    System.out.println("The depth-first tree: ");
    }
}
