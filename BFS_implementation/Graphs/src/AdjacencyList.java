
import java.util.ArrayList;


public class AdjacencyList {
    int vertex;
    ArrayList<LinkedList1> list;    //An arraylist with elements of type of linked list

    public AdjacencyList(int vertex) {
        this.vertex=vertex;
        list = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {

            list.add(i,new LinkedList1(i));     //Creating a new linked list at every index of Arraylist
        }
    }

    public void addEdge(int source, int destination) {
        //add edge
        //decrementing by one as offset, ArrayList index starts from zero;  Input starts from 1
        LinkedList1 ref = list.get(source-1);   //Get a reference to a specified index in Arraylist.
        ref.insert(destination-1);
    }

    public void printGraph(){
        System.out.println("Adjacency List:");
        for(int i=0; i<vertex;i++){
            LinkedList1 iter = list.get(i);
            iter.display();
            System.out.println();
        }
    }
    public Queues bfs(int start){
        boolean visited[] = new boolean[vertex];
        Queues queue = new Queues(vertex);
        Queues result = new Queues(vertex);
        start--;    //Decremented to ensure Array Index isn't out of Bound
        visited[start] = true;
        queue.enqueue(start);

        int vertices = start;

        while (queue.size != 0){

            vertices = queue.dequeue();
            result.enqueue(vertices);   //Adding values to result in bfs order
            EndNode iter = list.get(vertices).head;

            while (iter != null){
                int n = iter.end_node_id;
                if(!visited[n]){        //If n is not visited, mark visited, add it to queue.
                    visited[n] = true;
                    queue.enqueue(n);
                }
                iter = iter.next;   //Move on to next element in the list
            }

        }
        return result;
    }
}