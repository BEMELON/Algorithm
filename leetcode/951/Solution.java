import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Node {

    // idx on Map
    int idx;

    // consecutive value
    int n;

    public Node(int idx, int n) {
        this.idx = idx;
        this.n = n;
    }
}

class StockSpanner {
    private Stack<Node> s;
    private Map<Integer, Integer> memory;
    private int i;

    public StockSpanner() {
        s = new Stack<Node>();
        i = 0;
        memory = new HashMap<>();
    }

    public int next(int price) {
        int consecutive = 1;
        while (!s.isEmpty() && s.peek().n <= price) {
            consecutive += memory.get(s.pop().idx);
        }

        s.push(new Node(i, price));
        memory.put(i, consecutive);
        i++;


        return consecutive;
    }
}
