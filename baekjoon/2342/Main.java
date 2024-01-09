import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int[][][] dp;

    static List<Integer> nums;
    static int[][] weight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stk = new StringTokenizer(br.readLine());
        weight = new int[5][5];

        weight[0][0] = 99999;
        for(int i = 1; i < 5; i++) {
            weight[i][i] = 1;
        }
        // 가운데에서 X
        for(int i = 1 ; i < 5; i++) {
            weight[0][i] = 2;
            weight[i][0] = 99999;
        }



        // X에서 양옆 Y
        for(int i = 2; i < 4; i++) {
            weight[i][i - 1] = weight[i][i + 1] = 3;
        }
        weight[1][2] = weight[4][3] = 3;
        weight[1][4] = weight[4][1] = 3;
        weight[1][3] = weight[3][1] = 4;
        weight[2][4] = weight[4][2] = 4;


        dp = new int[100000][5][5];
        nums = new ArrayList<>();

        while (stk.hasMoreElements()) {
            int next = Integer.parseInt(stk.nextToken());
            if (next != 0)
                nums.add(next);
        }

        bw.write(search(0, 0, 0) + "\n");

        br.close();
        bw.close();
    }

    private static int search(int idx, int l, int r) {
        if (idx == nums.size())
            return 0;

        if (dp[idx][l][r] != 0)
            return dp[idx][l][r];

        int next = nums.get(idx);

        dp[idx][l][r] = Math.min(search(idx + 1, next, r) + weight[l][next], search(idx + 1, l, next) + weight[r][next]);
        return dp[idx][l][r];
    }
}
