import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int[] nums, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        dp = new int[n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = nums[0];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }

            dp[i] = Math.max(dp[i], nums[i]);
        }


        int answer = 0;
        for(int el: dp) {
            answer = Math.max(answer, el);
        }

        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}
