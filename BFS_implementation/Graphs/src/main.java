
public class Main {

    public static void main(String[] args) {
        // write your code here
        AdjacencyList graph = new AdjacencyList(6);
        graph.addEdge(1,2);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(6,6);
        graph.printGraph();

//        Test case 1
        Queues q1= graph.bfs(3);        // bfs returns a queue in bfs order
        System.out.print("BFS Traversal : ");

        for(int i=0; i<q1.size; i++){
            System.out.print(" " + (q1.queue[i]+1));   //Value incremented as offset to match the input
        }
        System.out.println("\n");

//        Test Case 2
        AdjacencyList graph1 =  new AdjacencyList(6);
        graph1.addEdge(3,1);
        graph1.addEdge(2,1);
        graph1.addEdge(4,3);
        graph1.addEdge(4,2);
        graph1.addEdge(5,2);
        graph1.addEdge(5,4);
        graph1.addEdge(6,4);
        graph1.addEdge(6,5);
        graph1.addEdge(6,3);
        graph1.printGraph();

        Queues q2= graph1.bfs(6);
        System.out.print("BFS Traversal : ");
        for(int i=0;i<q2.size;i++){
            System.out.print(" " + (q2.queue[i]+1));
        }
    }
}