import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] coins = new int[n];

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 16);
        dp[0] = 0;
        for(int coin: coins) {
            for(int m = coin; m <= k; m++) {
                dp[m] = Math.min(dp[m], dp[m - coin] + 1);
            }
        }

        if (dp[k] >= Integer.MAX_VALUE / 16)
            bw.write("-1\n");
        else
            bw.write(dp[k] + "\n");

        br.close();
        bw.close();
    }
}
