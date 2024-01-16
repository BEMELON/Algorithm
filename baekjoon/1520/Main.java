import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n, m;
    static int[][] grid, dp;

    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        grid = new int[n][m];
        dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                Arrays.fill(dp[i], -1);
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(0, 0, 0);

        bw.write(dp[0][0] + "\n");
        br.close();
        bw.close();
    }

    private static int dfs(int r, int c, int prevDirection) {
        if (r == (n - 1) && c == (m - 1)) {
            return 1;
        } else if (r >= n || c >= m) {
            return 0;
        }

        int sum = 0;
        for(int d = 0; d < 4; d++) {
            int nx = r + dx[d], ny = c + dy[d];

            if (inRange(nx, ny) && grid[nx][ny] < grid[r][c]) {
                if (dp[nx][ny] == -1) {
                    sum += dfs(nx, ny, d);
                } else {
                    sum += dp[nx][ny];
                }
            }
        }

        dp[r][c] = sum;
        return dp[r][c];
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
