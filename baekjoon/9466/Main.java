import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int T, n, result;
    static int[] preferStudents;
    static boolean[] onTeam, visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            preferStudents = new int[n + 1];
            stk = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                preferStudents[i] = Integer.parseInt(stk.nextToken());
            }

            onTeam = new boolean[n + 1];
            visited = new boolean[n + 1];

            result = n;

            // 다인팀
            for(int i = 1; i <= n; i++) {
                DFS(i);
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void DFS(int student) {
        if (visited[student]) return;

        visited[student] = true;

        int next = preferStudents[student];

        if (!visited[next]) {
            DFS(next);
        } else if (!onTeam[next]) {
            // student
            result--;
            for(int i = next; i != student; i = preferStudents[i]) {
                result--;
            }
        }

        onTeam[student] = true;
    }
}
