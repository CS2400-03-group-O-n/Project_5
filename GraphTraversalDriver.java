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

   System.out.println("The breadth-first tree: \n");

   System.out.println("The depth-first tree: ");

   System.out.println();
   AdjGraph.getAdjacencyMatrix(AdjGraph);
   AdjGraph.getAdjacencyList(AdjGraph);
   System.out.println();
    }
}
