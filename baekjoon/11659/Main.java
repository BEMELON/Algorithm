import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dp[1] = arr[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            if (dp[start] != 0 && dp[end] != 0) {
                sb.append(dp[end] - dp[start - 1]).append('\n');
                continue;
            }

            if (dp[start] == 0) {
                int idx = start - 1;
                while (idx > 0) {
                    if (dp[idx] != 0) {
                        break;
                    }
                    idx--;
                }

                for (int j = idx + 1; j <= start; j++) {
                    dp[j] = dp[j - 1] + arr[j];
                }

            }
            for (int j = start + 1; j <= end; j++) {
                dp[j] = dp[j - 1] + arr[j];
            }

            // print dp array
            // System.out.println(Arrays.toString(dp));
            sb.append(dp[end] - dp[start - 1]).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}