import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Reference : https://yabmoons.tistory.com/523
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        for (int c = 0; c < cases; c++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N + 1];
            int[][] arr = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int i = 2; i <= N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}