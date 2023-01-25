class Node {
	public int data;
	public Node prev;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
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
        if (head == null) {
            head = getNode(data);
        } else {
            Node newNode = getNode(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
	}

	public void addNode2Tail(int data) {
        if (head == null) {
            head = getNode(data);
        } else {
            Node newNode = getNode(data);
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
            newNode.prev = cur;
        }
    
	}

	public void addNode2Num(int data, int num) {
        if (head == null) {
            head = getNode(data);
        } else {
            Node newNode = getNode(data);
            Node cur = head;
            for (int i = 1; i < num - 1 && cur.next != null; i++) {
                cur = cur.next;
            }
            if (cur == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                return;
            } else if (cur.next == null) {
                cur.next = newNode;
                newNode.prev = cur;
                return;
            }
            newNode.next = cur.next;
            newNode.prev = cur;
            cur.next = newNode;
            newNode.next.prev = newNode;
        }
	
	}
	
	public int findNode(int data) {
		Node cur = head;
        int cnt = 1;
        while (cur != null) {
            if (cur.data == data) {
                return cnt;
            }
            cur = cur.next;
            cnt++;
        }
        return -1;
	}
	
	public void removeNode(int data) {
        Node cur = head; 
        while (cur != null) {
            if (cur.data == data) {
                if (cur.prev != null) {
                    cur.prev.next = cur.next;
                } else {
                    head = cur.next;
                }
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                }
                break;
            }
            cur = cur.next;
        }
	}

	public int getList(int[] output) {
		Node cur = head;
        int count = 0;
        while (cur != null) {
            output[count++] = cur.data;
            cur = cur.next;
        }
        return count;
	}
	
	public int getReversedList(int[] output) {
		Node cur = head;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
        }
        while (cur != null) {
            output[count++] = cur.data;
            cur = cur.prev;
        }
        return count;
	}
}