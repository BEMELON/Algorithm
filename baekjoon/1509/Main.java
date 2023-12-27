import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static long MOD = 1_000_000_000L;

    static long[][][] dp;

    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // dp[i][j][k] = k의 자리를 방문했으면서 i번째 자리에 j가 올 수 있는 경우의 수
        dp = new long[n][10][1 << 10];

        // 1자리
        for(int i = 1; i < 10; i++) {
            dp[0][i][1 << i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 1024; k++) {


                    if (j - 1 >= 0)
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];


                    if (j + 1 <= 9)
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];


                    dp[i][j][k | (1 << j)] %= MOD;
                }
            }
        }
        long result = 0;
        for(int i = 0; i < 10; i++) {
            result += dp[n - 1][i][1023];
            result %= MOD;
        }

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}
