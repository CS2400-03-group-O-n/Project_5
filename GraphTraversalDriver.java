import GraphPackage.*;

import javax.lang.model.util.Elements.Origin;

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


    BgraphTraversal.addEdge("A", "B", 2.0);
    BgraphTraversal.addEdge("B", "C", 3.0);
    BgraphTraversal.addEdge("C", "A", 4.0);
    BgraphTraversal.addEdge("A", "C", 5.0);


    System.out.println("The breadth-first traversal of the graph: ");
    QueueInterface<String> bfs = BgraphTraversal.getBreadthFirstTraversal("A");
    while (!bfs.isEmpty())
    {
      System.out.print(bfs.dequeue() + " ");
    }
    System.out.println(); 

    QueueInterface<String> dfs = BgraphTraversal.getDepthFirstTraversal("A");
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
