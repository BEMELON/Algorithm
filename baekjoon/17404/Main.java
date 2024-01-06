import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] rgb, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        rgb = new int[n][3];
        dp = new int[n][3];

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int start = 0; start < 3; start++) {
            for(int color = 0; color < 3; color++) {
                if (color == start) dp[0][color] = rgb[0][color];
                else dp[0][color] = Integer.MAX_VALUE / 16;
            }

            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

            for(int color = 0; color < 3; color++) {
                if (color == start) continue;

                answer = Math.min(answer, dp[n - 1][color]);
            }

        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
