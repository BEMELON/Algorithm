import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[] nums, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        dp = new int[n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int el: dp) {
            max = Math.max(max, el);
        }
        bw.write(max + "\n");
        br.close();
        bw.close();
    }
}
