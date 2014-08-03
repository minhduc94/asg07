import java.util.Stack;

public class MyList implements Item{
    private Node start;
    private Node end;
    private int size;
	
    public MyList() {
		start = null;
		end = null;
		size = 0;
    }
	
	public MyList(Node start, Node end, int size){
		this.start = start;
		this.end = end;
		this.size = size;
	}
	
	public MyList(MyList m){
		start = m.start;
		end = m.end;
		size = m.size;
	}
	
	public MyList clone() {
		MyList list = new MyList();
		list.appendList(this);
		return list;
	}
	
	public String toString(){
		String result = "(";
		Node current = this.start;
		boolean first = true;
		while (current != null){
			if (first){
			result += current.data.toString();
			first = false;
			}
			else
				result += ", " + current.data.toString();
			current = current.next;
		}
		result += ")";
		return result;
	}
	
	public boolean equals(Item item){
		if (item == null)
			return false;
		if (!(item instanceof MyList))
			return false;	
		MyList list = (MyList)item;
		Node n1 = this.start;
		Node n2 = list.start;
		if (length() != list.length())
		return false;
		while ((n1 != null) && (n2 != null)){
			if (!n1.data.equals(n2.data))
				return false;
			n1 = n1.next;
			n2 = n2.next;
		}
		return true;
	}
	
    public void append(Item data){
		size++;
		if (start == null){
			Node node = new Node(data, null);
			start = node;
			end = node;
		}
		else{
			Node node = new Node(data, null);
			end.next = node;
			end = node;
		}
	}
	
	public void appendList(MyList list){
		Node current = list.start;
		while (current != null){
			append(current.data);
			current = current.next;
		}
	}
	
	public int length(){
		return size;
	}

    public Item find(Item item){
		Node current = this.start;
		while (current != null){
		if (!current.data.equals(item))
		return current.data;
		}
		return null;
	}

	private void addInvert(Node head){
		if (head != null){
		addInvert(head.next);
		append(head.data);
		}
	}

	public void invert(){
		Node head = start;
		start = end = null;
		size = 0;
		addInvert(head);
	}

	public static void main(String args[]) {
		MyList l = new MyList();
		l.append(new NumeralItem(1));
		l.append(new NumeralItem(2));
		System.out.println(l); // (1, 2)
		MyList l2 = new MyList();
		l2.append(new StringItem("a"));
		l2.append(new StringItem("b"));
		System.out.println(l2.toString()); // (a, b)
		l.append(l2);
		System.out.println(l + " co do dai la " + l.length()); // (1, 2, (a, b))
		l.appendList(l2);
		System.out.println(l + " co do dai la " + l.length()); // (1, 2, (a, b), a, b)
		MyList newList = (MyList)l.clone();
		System.out.println(newList); // (1, 2, (a, b), a, b)
		System.out.println(newList.length() + " lll " + l.length());
		System.out.println(newList.equals(l));
		newList.invert();
		System.out.println(newList);
	}
}