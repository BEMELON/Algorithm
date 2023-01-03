import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        DFS(graph, visited, N, 1);

        int count = 0;
        for(int i = 0; i <= N; i++) {
            if (visited[i])
                count++;
        }

        System.out.println(Math.max(0, count - 1));
    }
    private void DFS(int[][] graph, boolean[] visited, int N, int idx) {
        for(int i = 1; i <= N; i++) {
            if (graph[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                DFS(graph, visited, N, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}