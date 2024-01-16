import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        // dp[0] = 1
        // dp[2] = 3
        // dp[4] = dp[2] * 3 + dp[0] * 2
        // dp[6] = dp[4] * 3 + dp[2] * 2 + dp[0] * 2;
        // https://hello-backend.tistory.com/156
        if (n % 2 == 1) {
            bw.write("0\n");
        } else if (n == 2) {
            bw.write("3\n");
        } else {
                dp[0] = 1;
                dp[2] = 3;
                for(int i = 4; i <= n; i++) {
                    if (n % 2 == 1) {
                        dp[i] = 0;
                    } else {
                        dp[i] = 3 * dp[i - 2];

                        for(int j = i - 4; j >= 0; j -= 2) {
                            dp[i] += dp[j] * 2;
                        }
                    }
                }

                bw.write(dp[n] + "\n");
        }

        br.close();
        bw.close();
    }
}
