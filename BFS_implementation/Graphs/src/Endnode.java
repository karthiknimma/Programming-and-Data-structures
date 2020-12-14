//Data type of the nodes in linked list
public class EndNode {
    int end_node_id;
    EndNode next;

    public EndNode(){
        end_node_id=0;
        next=null;
    }
    public EndNode(int source, EndNode next) {
        end_node_id = source;
        this.next = next;
    }
}