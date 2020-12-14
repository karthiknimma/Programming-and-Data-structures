
public class Queues {
    int[] queue;
    int front;
    int rear;
    int capacity;
    int size;


    public Queues(int vertices) {
        queue = new int[vertices];
        capacity = vertices;
        front = 0;
        rear = capacity - 1;
        size = 0;
    }
    //  front and rear are calculated to determine position at which enqueue or dequeue should be performed.
//  size controls the logical size of the queue
    void enqueue(int vertex) {
        if (capacity == size)
            return;
        rear = (rear + 1) % capacity;
        queue[rear] = vertex;
        size++;
    }
    int dequeue(){
        int vertex = queue[front];
        front = (front + 1) % capacity;
        size--;
        return vertex;
    }
}