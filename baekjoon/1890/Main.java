import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n;

    static long[][] grid, dp;

    static int[] dx = {1, 0}, dy = {0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        grid = new long[n][n];
        dp = new long[n][n];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                long jump = grid[r][c];

                if (jump == 0)
                    break;

                for(int d = 0; d < 2; d++) {
                    long nx = r + jump * dx[d], ny = c + jump * dy[d];

                    if (!inRange((int) nx, (int) ny)) continue;

                    dp[(int) nx][(int) ny] += dp[r][c];

                }
            }
        }
        bw.write(dp[n - 1][n - 1] + "\n");
        br.close();
        bw.close();
    }
    
    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
