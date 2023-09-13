import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    public int rate;
    public int idx;
    public int candy;

    public Node(int rate, int idx) {
        this.rate = rate;
        this.idx = idx;
        this.candy = 1;
    }
}

class Solution {
    public void DFS(Node[] arr, Node curr) {
        int[] dx = {-1, 1};

        for(int d: dx) {
            int idx = curr.idx + d;
            if (idx < 0 || idx > arr.length - 1) continue;

            if (arr[idx].rate > curr.rate &&
                    arr[idx].candy <= curr.candy) {
                arr[idx].candy = curr.candy + 1;
                DFS(arr, arr[idx]);
            }
        }
    }

    public int candy(int[] ratings) {
        Node[] arr = new Node[ratings.length];
        PriorityQueue<Node> q = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.rate)
        );

        for(int i = 0; i < ratings.length; i++) {
            Node n = new Node(ratings[i], i);

            arr[i] = n;
            q.add(n);
        }

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.println(curr.idx);
            DFS(arr, curr);
        }

        int sum = 0;
        for(Node n: arr) {
            sum += n.candy;
        }

        return sum;
    }
}