import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            String[] visited = new String[10000];
            BFS(visited, A, B);

            sb.append(visited[B]).append('\n');
        }

        System.out.println(sb);
    }

    private void BFS(String[] visited, int a, int b) {  
        Queue<Integer> queue = new LinkedList<>();
        visited[a] = "";
        queue.add(a);
        while (!queue.isEmpty()) {
            int n = queue.poll(); 
            if (n == b) {
                return ; 
            }
            
            int next = D(n);
            if (visited[next] == null) {
                queue.add(next);
                visited[next] = visited[n] + "D";
            } else {
                visited[next] = visited[next].length() > visited[n].length() + 1 ? visited[n] + "D" : visited[next];
            }

            next = S(n);
            if (visited[next] == null) {
                queue.add(next);
                visited[next] = visited[n] + "S";
            } else {
                visited[next] = visited[next].length() > visited[n].length() + 1 ? visited[n] + "S" : visited[next];
            }

            next = L(n);
            if (visited[next] == null) {
                queue.add(next);
                visited[next] = visited[n] + "L";
            } else {
                visited[next] = visited[next].length() > visited[n].length() + 1 ? visited[n] + "L" : visited[next];
            }

            next = R(n);
            if (visited[next] == null) {
                queue.add(next);
                visited[next] = visited[n] + "R";
            } else {
                visited[next] = visited[next].length() > visited[n].length() + 1 ? visited[n] + "R" : visited[next];
            }
        }
    }

    public int D(int n) {
        return (2 * n) % 10000;
    }

    public int S(int n) {
        return (n == 0) ? 9999 : n - 1;
    }

    public int L(int n) {
        n = (n * 10) % 10000 + (n / 1000);
        return n;
    }

    public int R(int n) {
        n = (n / 10) + (n % 10) * 1000;
        return n;
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}