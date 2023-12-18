import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


// 시작점만 알아낼 수 있다면, 모든 경로에 대해서 최장 Dijkstra ,이후 가장 큰 값이 정답

public class Main {
    static StringTokenizer stk;

    static int t, n, k;
    static int[] buildTimes, indgree;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            k = Integer.parseInt(stk.nextToken());
            buildTimes = new int[n];
            indgree = new int[n];

            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                buildTimes[i] = Integer.parseInt(stk.nextToken());
            }

            graph = new int[n][n];
            for(int i = 0 ; i < k; i++) {
                stk = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(stk.nextToken()) - 1;
                int end = Integer.parseInt(stk.nextToken()) - 1;
                indgree[end]++;
                graph[start][end] = 1;
            }

            int w = Integer.parseInt(br.readLine()) - 1;

            int[] cost = new int[n];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                if (indgree[i] == 0) {
                    cost[i] = buildTimes[i];
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for(int i = 0; i < n; i++) {
                    if (graph[curr][i] == 0) continue;

                    cost[i] = Math.max(cost[i], cost[curr] + buildTimes[i]);
                    indgree[i]--;

                    if (indgree[i] == 0) {
                        queue.add(i);
                    }
                }
            }

            System.out.println(cost[w]);

        }
    }

}
