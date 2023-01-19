import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    class Node {
        int from;
        int to;
        int weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<HashMap<Integer, Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            adj.add(new HashMap<>());
        }

        for(int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            if (adj.get(from).containsKey(to)) {
                adj.get(from).put(to, Math.min(adj.get(from).get(to), weight));
            } else {
                adj.get(from).put(to, weight);
            }
    
        }

        // Dijkstra로  start 에서 모든 정점까지의 최단거리를 구한다. 
        int[] dist = Dijkstra(adj, start, V);
    
        // 최단 경로 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if (dist[i] >= Integer.MAX_VALUE / 2)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    private int[] Dijkstra(List<HashMap<Integer, Integer>> adj, int start, int V) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.add(new Node(start, start, 0));
        boolean[] visited = new boolean[V + 1];

        while (!pq.isEmpty()) {
            Node curr_node = pq.poll();
            int cur = curr_node.to;
            visited[cur] = true;

            for(int next : adj.get(cur).keySet()) {
                if (dist[next] > dist[cur] + adj.get(cur).get(next)) {
                    dist[next] = dist[cur] + adj.get(cur).get(next);
                    if (!visited[next])
                        pq.add(new Node(next, dist[next]));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}