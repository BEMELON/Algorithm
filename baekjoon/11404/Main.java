import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n, m;
    static int[][] graph, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        answer = new int[n][n];

        for(int i = 0 ; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken()) - 1;
            int end = Integer.parseInt(stk.nextToken()) - 1;
            int cost = Integer.parseInt(stk.nextToken());

            if (graph[start][end] == 0) graph[start][end] = cost;
            else graph[start][end] = Math.min(graph[start][end], cost);
        }

        // Init
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i == j) answer[i][j] = 0;
                else if (graph[i][j]  != 0) answer[i][j] = graph[i][j];
                else answer[i][j] = 10000000;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int src = 0; src < n; src++) {
                for(int dest = 0; dest < n; dest++) {
                    answer[src][dest] = Math.min(answer[src][dest], answer[src][i] + answer[i][dest]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (answer[i][j] >= 10000000) System.out.print("0 ");
                else System.out.printf("%d ", answer[i][j]);
            }
            System.out.println();
        }

    }
}
