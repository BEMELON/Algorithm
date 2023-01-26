import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        new Solution().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            int L = Integer.parseInt(stk.nextToken());
            List<Integer> list = new ArrayList<>();
            
            stk  = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(stk.nextToken()));
            }

            for(int i = 0; i < M; i++) {
                stk = new StringTokenizer(br.readLine());

                String cmd = stk.nextToken();
                int idx;
                switch (cmd) {
                case "I":
                    idx = Integer.parseInt(stk.nextToken());
                    int num = Integer.parseInt(stk.nextToken());
                    list.add(idx, num);
                    break;
                case "D":
                    idx = Integer.parseInt(stk.nextToken());
                    list.remove(idx);
                    break; 
                case "C":
                    idx = Integer.parseInt(stk.nextToken());
                    int num2 = Integer.parseInt(stk.nextToken());
                    list.set(idx, num2);
                    break;
                }
            }
            if (L >= list.size())
                sb.append("#").append(test_case).append(" -1").append('\n');
            else
                sb.append("#").append(test_case).append(" ").append(list.get(L)).append('\n');
        }

        System.out.println(sb);
    }
}