import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];

        dp[1] = arr[1];
        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(findMax(dp, arr, N));
    }

    private int findMax(int[] dp, int[] arr, int n) {
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}