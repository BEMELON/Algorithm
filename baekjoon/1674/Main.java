import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int dest, cost;

    public Node(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

public class Main {
    static StringTokenizer stk;
    static int n, m;
    static List<ArrayList<Node>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());


        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            graph.get(src).add(new Node(dest, cost));
            graph.get(dest).add(new Node(src, cost));
        }

        // MST - 간선들을 알고 있어야 함
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        pq.addAll(graph.get(1));

        Set<Integer> vistied = new HashSet<>();
        vistied.add(1);


        Queue<Integer> edges = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (vistied.contains(curr.dest)) continue;

            edges.add(curr.cost);
            result += curr.cost;
            vistied.add(curr.dest);

            for(Node next: graph.get(curr.dest)) {
                if (!vistied.contains(next.dest)) {
                    pq.add(next);
                }
            }
        }


        // 가장 긴 간선 하나 삭제
        System.out.println(result - edges.peek());
    }
}
