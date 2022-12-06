import GraphPackage.*;
import ADTPackage.*;

public class GraphTraversalDriver 
{
    public static void main(String [] args)
    {
    System.out.println("\nThe graph: {V, E} where\nV = { A, B, C, D, E, F, G, H, I }");
    System.out.println("E = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }\n");

    DirectedGraph<String> BgraphTraversal = new DirectedGraph<>();
  
    BgraphTraversal.addVertex("A");
    BgraphTraversal.addVertex("B");
    BgraphTraversal.addVertex("C");
    BgraphTraversal.addVertex("D");
    BgraphTraversal.addVertex("E");
    BgraphTraversal.addVertex("F");
    BgraphTraversal.addVertex("G");
    BgraphTraversal.addVertex("H");
    BgraphTraversal.addVertex("I");


    BgraphTraversal.addEdge("A", "B");
    BgraphTraversal.addEdge("A", "D");
    BgraphTraversal.addEdge("A", "E");
    BgraphTraversal.addEdge("B", "E");
    BgraphTraversal.addEdge("D", "G");
    BgraphTraversal.addEdge("E", "F");
    BgraphTraversal.addEdge("E", "H");
    BgraphTraversal.addEdge("G", "H");
    BgraphTraversal.addEdge("F", "C");
    BgraphTraversal.addEdge("F", "H");
    BgraphTraversal.addEdge("H", "I");
    BgraphTraversal.addEdge("C", "B");
    BgraphTraversal.addEdge("I", "F");


    System.out.println("number of vertices: " + BgraphTraversal.getNumberOfVertices() + "\nnumber of edges: " + BgraphTraversal.getNumberOfEdges());
    System.out.println("The breadth-first traversal of the graph: " );

    
    QueueInterface<String> bfs = BgraphTraversal.getBreadthFirstTraversal("A");
    while (!bfs.isEmpty())
    {
      System.out.print(bfs.dequeue() + " ");
    }
    System.out.println(); 

    
    DirectedGraph<String> DgraphTraversal = new DirectedGraph<>();
    DgraphTraversal.addVertex("A");
    DgraphTraversal.addVertex("B");
    DgraphTraversal.addVertex("C");
    DgraphTraversal.addVertex("D");
    DgraphTraversal.addVertex("E");
    DgraphTraversal.addVertex("F");
    DgraphTraversal.addVertex("G");
    DgraphTraversal.addVertex("H");
    DgraphTraversal.addVertex("I");


    DgraphTraversal.addEdge("A", "B");
    BgraphTraversal.addEdge("A", "D");
    DgraphTraversal.addEdge("A", "E");
    DgraphTraversal.addEdge("B", "E");
    DgraphTraversal.addEdge("D", "G");
    DgraphTraversal.addEdge("E", "F");
    DgraphTraversal.addEdge("E", "H");
    DgraphTraversal.addEdge("G", "H");
    DgraphTraversal.addEdge("F", "C");
    DgraphTraversal.addEdge("F", "H");
    DgraphTraversal.addEdge("H", "I");
    DgraphTraversal.addEdge("C", "B");
    DgraphTraversal.addEdge("I", "F");

    QueueInterface<String> dfs = DgraphTraversal.getDepthFirstTraversal("A");
    System.out.println("The depth-first traversal of the graph:");
    
    while (!dfs.isEmpty())
    {
      System.out.print(dfs.dequeue() + " ");
    }
    System.out.println(); 

   // System.out.println("The breadth-first tree: \n");

//    System.out.println("The depth-first tree: ");
    }
}
