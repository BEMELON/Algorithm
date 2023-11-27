import java.util.*;

class Solution {
    // S -> B, S -> A 최단거리 : 최대 비용 

    // 하차 지점을 먼저 찾을 수 있는 지? 
    // 없다, 합승 노선에 대해서 값이 업데이트 되어야 하기 때문에. 

    // 결국, 모든 경우를 봐야한다. 
    // 임의의 정점까지 합승, 정점에서 A와 B까지의 최단 경로를 더함, (V^2 * V^2) > 시간초과 

    // ... 플로이드-워샬로 모든 경로에 대한 최단경로를 구함
    // min(d(S, N) + d(N, A) + d(N, B))

    public int dp[][];
    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(fares, n);

        int minFare = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            // System.out.printf("%d -> %d 합승(%d), A의 비용(%d), B의 비용(%d)\n", s, i, dp[s][i] / 2, dp[i][a], dp[i][b]);
            minFare = Math.min(minFare, (dp[s][i]) + dp[i][a] + dp[i][b]);
        }

        return minFare;
    }

    public void init(int[][] fares, int n) {
        dp = new int[n + 1][n + 1];
        for(int[] d: dp) {
            Arrays.fill(d, Integer.MAX_VALUE / 4);
        }

        for(int[] fare: fares) {
            dp[fare[0]][fare[1]] = fare[2];
            dp[fare[1]][fare[0]] = fare[2];
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if (i == j)
                    dp[i][j] = 0;
            }
        }


        // Floyd-Warshell 
        for(int i = 1; i <= n; i++) {
            // j -> k = min(j->i, i->k)
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
    }
}