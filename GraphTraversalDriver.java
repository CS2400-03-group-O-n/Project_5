import GraphPackage.*;

import javax.lang.model.util.Elements.Origin;
import java.lang.ArrayIndexOutOfBoundsException;

import ADTPackage.*;

public class GraphTraversalDriver 
{
    public static void main(String [] args)
    {
    System.out.println("\nThe graph: {V, E} where\nV = { A, B, C, D, E, F, G, H, I }");
    System.out.println("E = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }\n");

    DirectedGraph<String> BgraphTraversal = new DirectedGraph<>();
    Graph<String> AdjGraph = new Graph<>(10);
  
    AdjGraph.setLabel(1, "A");
    AdjGraph.setLabel(2, "B");
    AdjGraph.setLabel(3, "C");
    AdjGraph.setLabel(4, "D");
    AdjGraph.setLabel(5, "E");
    AdjGraph.setLabel(6, "F");
    AdjGraph.setLabel(7, "G");
    AdjGraph.setLabel(8, "H");
    AdjGraph.setLabel(9, "I");

    AdjGraph.addEdge(1, 2);
    AdjGraph.addEdge(1, 4);
    AdjGraph.addEdge(1, 5);
    AdjGraph.addEdge(2, 3);
    AdjGraph.addEdge(2, 5);
    AdjGraph.addEdge(4, 7);
    AdjGraph.addEdge(5, 6);
    AdjGraph.addEdge(5, 8);
    AdjGraph.addEdge(6, 8);
    AdjGraph.addEdge(6, 3);
    AdjGraph.addEdge(7, 8);
    AdjGraph.addEdge(8, 9);
    AdjGraph.addEdge(9, 6);

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

   System.out.println("The breadth-first tree: \n");

   System.out.println("The depth-first tree: ");

   System.out.println();
   AdjGraph.getAdjacencyMatrix(AdjGraph);
   AdjGraph.getAdjacencyList(AdjGraph);
   System.out.println();
    }
}
