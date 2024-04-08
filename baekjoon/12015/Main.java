import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[] arr, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp = new int[n + 1];
        Arrays.fill(dp, 1);

        int maxNum = arr[0];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

//        bw.write(Arrays.toString(dp) + "\n");

        bw.write(dp[n] + "\n");
        br.close();
        bw.close();
    }
}
