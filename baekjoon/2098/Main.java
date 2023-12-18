import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] graph;
    static int[][] memo;
    static int VISITED_ALL;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        VISITED_ALL = (1 << n) - 1;
        memo = new int[n][VISITED_ALL];
        for(int[] d: memo) {
            Arrays.fill(d, -1);
        }
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j= 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        System.out.println(DFS(0, 1));
        br.close();
    }

    private static int DFS(int start, int visited) {
        if (visited == VISITED_ALL) {
            if (graph[start][0] != 0) {
                return graph[start][0];
            } else {
                return Integer.MAX_VALUE / 16;
            }
        }

        if (memo[start][visited] != -1)
            return memo[start][visited];


        int minCost = Integer.MAX_VALUE / 16;
        for(int j = 0; j < n; j++) {
            if (graph[start][j] == 0 || ((visited & (1 << j)) != 0)) continue;
            int cost = DFS(j, visited | (1 << j)) + graph[start][j];
            minCost = Math.min(cost, minCost);
        }

        memo[start][visited] = minCost;
        return minCost;
    }
}
