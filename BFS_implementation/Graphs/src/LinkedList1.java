
public class LinkedList1 {
    EndNode head;           //Reference to End node

    public LinkedList1(){
        head = null;
    }
    public LinkedList1(int source){
        head = null;
        insert(source);     //Inserts source vertex, at start of the linked list
    }
    public LinkedList1(EndNode head) {
        this.head = head;
    }

    public void insert(int vertex){
        EndNode newNode = new EndNode(vertex,null);
        if(head == null){
            head = newNode;
            newNode.next = null;
        }
        else{
            EndNode iter = head;
            while (iter.next != null){
                iter = iter.next;
            }
            iter.next = newNode;
            newNode.next = null;
        }

    }
    void  display(){
        for(EndNode iter  = head; iter!=null;iter = iter.next ){
            System.out.print(iter.end_node_id+1 + "-->");      //Value incremented by one as offset
        }
    }

}