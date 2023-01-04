import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sqrt = (int) Math.sqrt(N);
        
        int[][] dp = new int[sqrt + 1][N + 1];
        
        for(int i = 1; i <= sqrt; i++) {
            for(int j = 1; j <= N; j++) {
                if (i * i == j)
                    dp[i][j] = 1;
                else if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else if (i * i < j) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i][j - (i * i)]) + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

    
        System.out.println(dp[sqrt][N]);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}