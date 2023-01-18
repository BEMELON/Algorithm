import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Integer[][] graph = new Integer[N + 1][N + 1]; 
        for(int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2);
        }
        StringTokenizer str;
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(str.nextToken());
            int dest = Integer.parseInt(str.nextToken());
            int weight = Integer.parseInt(str.nextToken());
            graph[src][dest] = Math.min(graph[src][dest], weight);
        }

        str = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(str.nextToken());
        int end = Integer.parseInt(str.nextToken());

        System.out.println(Dijkstra(start, end, graph));
    }
    private int Dijkstra(int start, int end, Integer[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Integer[] dist = new Integer[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[start] = 0;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer arg0, Integer arg1) {
                return dist[arg0] - dist[arg1];
            }
            
        }); 
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll(); 
            for(int i = 1; i < graph.length; i++) {
                if (dist[i] > dist[cur] + graph[cur][i]) {
                    dist[i] = dist[cur] + graph[cur][i];

                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }

        }

        // System.out.println(Arrays.toString(dist));
        return dist[end];
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}