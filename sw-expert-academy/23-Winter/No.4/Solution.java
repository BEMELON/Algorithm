import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        new Solution().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer cypers = new StringTokenizer(br.readLine());
            int COMMAND_N = Integer.parseInt(br.readLine());
            StringTokenizer cmds = new StringTokenizer(br.readLine());
                
            List<Integer> cyperList = new LinkedList<Integer>();
            for(int i = 0; i < N; i++) {
                cyperList.add(Integer.parseInt(cypers.nextToken()));
            }

            while (cmds.hasMoreTokens()) {
                String cmd = cmds.nextToken();
                switch (cmd) {
                    case "I":
                        int idx = Integer.parseInt(cmds.nextToken());
                        int cnt = Integer.parseInt(cmds.nextToken());
                        for(int i = 0; i < cnt; i++) {
                            cyperList.add(idx++, Integer.parseInt(cmds.nextToken()));
                        }
                        break;
                    case "D":
                        idx = Integer.parseInt(cmds.nextToken());
                        cnt = Integer.parseInt(cmds.nextToken());
                        for(int i = 0; i < cnt; i++) {
                            cyperList.remove(idx);
                        }
                        break;
                    case "A":
                        cnt = Integer.parseInt(cmds.nextToken());
                        for(int i = 0; i < cnt; i++) {
                            cyperList.add(Integer.parseInt(cmds.nextToken()));
                        }
                        break;
                }
            }
            sb.append("#").append(test_case).append(" ");
            for(int i = 0; i < 10; i++) {
                sb.append(cyperList.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}