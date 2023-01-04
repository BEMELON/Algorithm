import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        int[][] graph = new int[M + 1][M + 1];
        boolean[] visited = new boolean[M + 1];

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());

            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        int result = 0;
        for(int i = 1 ; i <= M; i++) {
            if (!visited[i]) {
                DFS(graph, visited, i, M);
                result++;
            }
        }

        System.out.println(result);
    }


    private void DFS(int[][] graph, boolean[] visited, int offset, int vertex) {
        visited[offset] = true;
        for(int i = 1; i <= vertex; i++) {
            if (i == offset)
                continue;

            if (!visited[i] && graph[offset][i] == 1) {
                visited[i] = true;
                DFS(graph, visited, i, vertex);
            } 
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}