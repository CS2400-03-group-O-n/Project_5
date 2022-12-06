package GraphPackage;
import java.util.*;


import ADTPackage.*; // Classes that implement various ADTs
/**
   A class that implements the ADT directed graph.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Graph<E> implements BasicGraphInterface<E>
{ 
  // Constructors
  // Boolean method 
  //     isEdge(int source, int target)
  // Methods:
  //      addEdge(int source, int target) .
  //      getLabel(int vertex).
  //      neighbors(int vertex)
  //      removeEdge(int source, int target)
  //      setLabel(int vertex, E newLabel)
  //      size()

  private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
  private E[] labels; // labels[i] contains the label for vertex i  

  public Graph(int n) {
      edges = new boolean[n][n]; // All values initially false
      labels = (E[]) new Object[n]; // All values initially null
    }

      // Accessor method to get the label of a vertex of this Graph 
    public E getLabel(int vertex) {
        return labels[vertex];
    }
    // Test whether an edge exists
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    // Add an edge
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

        // Obtain a list of neighbors of a specified vertex of this Graph
        public int[] neighbors(int vertex) {
            int i;
            int count = 0;
            int[] answer;
            for (i = 0; i < labels.length; i++) {
                if (edges[vertex][i])
                    count++;
            }
            answer = new int[count];
            count = 0;
            for (i = 0; i < labels.length; i++) {
                if (edges[vertex][i])
                    answer[count++] = i;
            }
            return answer;
        }
      // Remove an edge
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }
    // Change the label of a vertex of this Graph
    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }
    // Accessor method to determine the number of vertices in this Graph
    public int size() {
        return labels.length;
    }

    public void getAdjacencyMatrix(Graph<E> graph){
        int vertex = graph.size();
        boolean matrix[][] = new boolean[vertex][vertex];
        
        System.out.println("The Adjacency Matrix is: ");
        for (int i = 1; i < vertex; i++){
            for (int j = 1; j< vertex; j++){
                if (graph.isEdge(i, j) == true){
                    matrix[i][j] = true;
                    System.out.print(matrix[i][j] + " ");
                } else{
                    matrix[i][j] = false;
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void getAdjacencyList(Graph<E> graph){
        LinkedListWithIterator<String> adj = new LinkedListWithIterator<String>();
        int vertex = graph.size();

        for (int i = 1; i < vertex; i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 1; j < vertex; j++){
                if (graph.isEdge(i, j) == true){
                    System.out.print(" -> " + graph.getLabel(j));
                }
            }
            System.out.print(" -> null");
            System.out.println();
        }
    }

    @Override
    public boolean addVertex(E vertexLabel) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addEdge(E begin, E end, double edgeWeight) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addEdge(E begin, E end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasEdge(E begin, E end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getNumberOfVertices() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNumberOfEdges() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public QueueInterface<E> getBreadthFirstTraversal(E origin) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public QueueInterface<E> getDepthFirstTraversal(E origin) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StackInterface<E> getTopologicalOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getShortestPath(E begin, E end, StackInterface<E> path) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getCheapestPath(E begin, E end, StackInterface<E> path) {
        // TODO Auto-generated method stub
        return 0;
    }
}