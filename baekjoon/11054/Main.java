import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int[] minDp, maxDP;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        minDp = new int[n + 1];
        maxDP = new int[n + 1];
        arr = new int[n + 1];


        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // dp[i] = j, i를 마지막으로 값을 가졌을 때 가장 긴 증가부분 수열의 길이
        for(int i = 1; i <= n; i++) {
            int maxValue = 0;
            for(int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    maxValue = Math.max(maxValue, maxDP[j]);
                }
            }

            maxDP[i] = maxValue + 1;
        }

        for(int i = n; i > 0; i--) {
            int maxValue = 0;
            for(int j = n; j > i && j <= n; j--) {
                if (arr[j] < arr[i]) {
                    maxValue = Math.max(maxValue, minDp[j]);
                }
            }

            minDp[i] = maxValue + 1;
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, maxDP[i] + minDp[i]);
        }

        System.out.println(max - 1);
    }
}
