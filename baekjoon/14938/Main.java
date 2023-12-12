import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n, m, r;
    static int[] items;
    static int[][] graph, dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());

        items = new int[n];
        graph = new int[n][n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 0; i < r; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;
            int cost = Integer.parseInt(stk.nextToken());

            graph[x][y] = cost;
            graph[y][x] = cost;
        }

        floyd();


        int maxItems = 0;
        for(int i = 0; i < n; i++) {
            int itemCnt = 0;
            for(int j = 0; j < n; j++) {
                if (i == j || dist[i][j] <= m) {
                    itemCnt += items[j];
                }
            }

            maxItems = Math.max(maxItems, itemCnt);
        }

        System.out.println(maxItems);
    }

    private static void floyd() {
        int INF = Integer.MAX_VALUE / 16;
        // Init dist
        dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else if (graph[i][j] != 0) dist[i][j] = graph[i][j];
                else dist[i][j] = INF;
            }
        }


        for(int m = 0; m < n; m++) {
            for(int s = 0; s < n; s++) {
                for(int e = 0; e < n; e++) {
                    dist[s][e] = Math.min(dist[s][e], dist[s][m] + dist[m][e]);
                }
            }
        }
    }
}
