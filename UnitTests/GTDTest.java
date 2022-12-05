package UnitTests;
import GraphPackage.*;
import ADTPackage.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
//Tests the implementation of breadth and depth traversals 

public class GTDTest 
{

    @Test
    public void testBreadth(){
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
       // assertEquals (expected result, actual result)
        // expected:        actual : 
        QueueInterface<String> bfs = BgraphTraversal.getBreadthFirstTraversal("A");

        String graphTest = null;
        while (!bfs.isEmpty())
        {
          graphTest = bfs.dequeue();
        }
        assertEquals("ABDEGFHCI", graphTest);
    }
   
    @Test
    public void testDepth()
    {
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
        DgraphTraversal.addEdge("A", "D");
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

        String graphTest = null;
        while (!dfs.isEmpty())
        {
          graphTest = dfs.dequeue();
        }
        assertEquals("ABDEGFHCI", graphTest);
    }
} 