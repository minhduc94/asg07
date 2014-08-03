public class Node{
    Item data;
    Node next;
	public Node(){
		data = null;
		next = null;
	}
    public Node(Item data, Node next ){
		this.data = data.clone();
		this.next = next;
    }
	public Node(Node node){
		data = node.data;
		next = node.next;
	}
}