class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class UserSolution {

	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
    private Node head;
    
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {
        head = null;
	}

	public void addNode2Head(int data) {
        Node newNode = getNode(data);
        newNode.next = head;
        head = newNode;
	}

	public void addNode2Tail(int data) {
        Node newNode = getNode(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
	}

	public void addNode2Num(int data, int num) {
        Node newNode = getNode(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node cur = head;
        for(int i = 1; i < num - 1 && cur.next != null ; i++) {
            cur = cur.next;
        }

        if (cur == head) {
            newNode.next = head;
            head = newNode;
            return;
        }

        newNode.next = cur.next;
        cur.next = newNode;
	}

	public void removeNode(int data) {
        if(head == null) {
            return;
        }

        Node cur = head;
        Node prev = null;
        while(cur != null) {
            if(cur.data == data) {
                if(prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        }
	}

	public int getList(int[] output) {
		int count = 0;
        Node cur = head;
        while (cur != null) {
            output[count++] = cur.data;
            cur = cur.next;
        }
        return count;
	}
}