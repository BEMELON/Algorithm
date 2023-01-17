import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Node>> arrList,reverse_arrList;
        arrList = new ArrayList<>();
        reverse_arrList = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            arrList.add(new ArrayList<>());
            reverse_arrList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            arrList.get(a).add(new Node(b, c));
            reverse_arrList.get(b).add(new Node(a, c));
        }
        int[] dist1 = dijkstra(arrList, X, M);
        int[] dist2 = dijkstra(reverse_arrList, X, N);

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dist1[i] + dist2[i]);
        }
     
        System.out.println(max);
    }



    private int[] dijkstra(ArrayList<ArrayList<Node>> arr, int start, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE / 2;
        }
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll(); 
            if(visited[curr.idx]) continue;
            
            visited[curr.idx] = true;
            for(Node next : arr.get(curr.idx)) {
                if(dist[next.idx] > dist[curr.idx] + next.dist) {
                    dist[next.idx] = dist[curr.idx] + next.dist;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }

        }

        return dist;
    }



    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}