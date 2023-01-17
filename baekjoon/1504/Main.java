import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] start_dist = dijstkra(graph, 1, N);

        int start_v1 = start_dist[v1];
        int start_v2 = start_dist[v2];

        if (start_v1 == Integer.MAX_VALUE / 2 || start_v2 == Integer.MAX_VALUE / 2) {
            System.out.println(-1);
            return;
        }

        int[] v1_v2 = dijstkra(graph, v1, N);
        int[] v2_end = dijstkra(graph, v2, N);
        int[] v2_v1 = dijstkra(graph, v2, N);
        int[] v1_end = dijstkra(graph, v1, N);

        int v1_v2_end = v1_v2[v2] + v2_end[N];
        int v2_v1_end = v2_v1[v1] + v1_end[N];

        if (v1_v2_end >= Integer.MAX_VALUE / 2 && v2_v1_end >= Integer.MAX_VALUE / 2) {
            System.out.println(-1);
            return;
        }

        if (v1_v2_end >= Integer.MAX_VALUE / 2) {
            System.out.println(start_v2 + v2_v1_end);
        } else if (v2_v1_end >= Integer.MAX_VALUE / 2) {
            System.out.println(start_v1 + v1_v2_end);
        } else {
            System.out.println(Math.min(start_v1 + v1_v2_end, start_v2 + v2_v1_end));
        }
    }

    private int[] dijstkra(int[][] graph, int start, int n) {
        int[] dist = new int[n + 1];
        for(int j = 0; j < n + 1; j++) {
            dist[j] = Integer.MAX_VALUE / 2;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(start);

        while (!pq.isEmpty()) {
            int cur = pq.poll(); 

            for(int i = 1; i <= n; i++) {
                if (graph[cur][i] == 0) continue;
                if (dist[i] > dist[cur] + graph[cur][i]) {
                    dist[i] = dist[cur] + graph[cur][i];
                    pq.add(i);
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}