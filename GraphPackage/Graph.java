package GraphPackage;
import ADTPackage.*; // Classes that implement various ADTs


public class GraphTraversal <E> 
{


public QueueInterface<T> getBreadthFirstTraversal (T origin)
{
    resetVertices();
    QueueInterface<T> traversalOrder = new LinkedQueue<T>();
    QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();

    VertexInterface<T> originVertex = vertices.getValue(origin);
    originVertex.visit();
    traversalOrder.enqueue(origin);  // enqueue vertex label
    vertexQueue.enqueue(originVertex);  // enqueue vertex

    while (!vertexQueue.isEmpty())
    {
        VertexInterface<T> frontVertex = vertexQueue.dequeue();
        Iterator <VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

        while(neighbors.hasNext())
        {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if (!nextNeighbor.isVisted())
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexQueue.enqueue(nextNeighbor);
            }
        }
    }
    return traversalOrder;
} // end getBreadthFirstTraversal



}