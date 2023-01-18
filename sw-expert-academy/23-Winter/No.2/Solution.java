import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        new Solution().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());

            int bit = 0;
            for(int i = 0; i < N; i++) {
                bit |= 1 << i;
            }

            if ((M & bit) == bit) {
                sb.append("#").append(test_case).append(" ").append("ON").append('\n');
            } else {
                sb.append("#").append(test_case).append(" ").append("OFF").append('\n');
            }
        }
        System.out.println(sb);
    }
}