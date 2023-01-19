import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<HashMap<Integer, Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new HashMap<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int tree = Integer.parseInt(str.nextToken());
            do {
                int n = Integer.parseInt(str.nextToken());
                if (n == -1) {
                    break;
                }

                int weight = Integer.parseInt(str.nextToken());
                graph.get(tree).put(n, weight);
            } while (str.hasMoreTokens());
        }
        
        int[] dist1 = Dikjstra(graph, 1, N);
        int max_idx = 1; 
        int max = Integer.MIN_VALUE / 2;
        for(int i = 1; i <= N; i++) {
            if (max < dist1[i]) {
                max = dist1[i];
                max_idx = i; 
            }
        }

        int[] dist2 = Dikjstra(graph, max_idx, N); 
        max = Integer.MIN_VALUE / 2;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dist2[i]);
        }
        System.out.println(max);

    }

    public int[] Dikjstra(List<HashMap<Integer, Integer>> graph, int start, int N) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -Integer.MIN_VALUE / 2);
        distance[start] = 0;
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(start);
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll(); 
            visited[cur] = true;
            for(int next: graph.get(cur).keySet()) {
                if (distance[next] < distance[cur] + graph.get(cur).get(next)) {
                    if (!visited[next]) {
                        distance[next] = Math.max(distance[next], distance[cur] + graph.get(cur).get(next));
                        queue.add(next);
                    }
                }

            }
        }

        return distance;
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}