import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
            int N = Integer.parseInt(br.readLine());            
            
            int answer = 0;
            int cnt = 0;
            int backup = N;
            while (answer != 1023) {
                while (N > 0) {
                    int temp = N % 10;
                    answer |= 1 << temp;
                    N /= 10;
                }

                cnt++;
                N = backup * (cnt + 1);
            }

            sb.append("#").append(test_case).append(" ").append(backup * cnt).append('\n');
        }

        System.out.println(sb);
    }
}