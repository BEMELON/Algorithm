import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static boolean[][] palindrome;
    static int n;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];

        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        palindrome = new boolean[n + 1][n + 1];
        // SIZE 1
        for(int i = 1; i <= n; i++) {
            palindrome[i][i] = true;
        }

        // SIZE 2
        for(int i = 1; i < n; i++) {
            if (nums[i] == nums[i + 1]) {
                palindrome[i][i + 1] = true;
            }
        }

        // ELSE
        for(int len = 3; len <= n; len++) {
            for(int start = 1; start <= n; start++) {
                if (start + len  - 1 > n) continue;

                int last = start + len - 1;
                if (nums[start] == nums[last] && palindrome[start + 1][last - 1])
                    palindrome[start][last] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            if (palindrome[start][end]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
