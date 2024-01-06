import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[] players, nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        players = new int[n];
        boolean[] exist = new boolean[1_000_001];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            players[i] = Integer.parseInt(stk.nextToken());
            exist[players[i]] = true;
        }



        int[] answer = new int[1_000_001];
        for(int player: players) {
            for(int next = player * 2; next < 1_000_001; next += player) {
                if (exist[next]) {
                    answer[player]++;
                    answer[next]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int player: players) {
            sb.append(answer[player]).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
