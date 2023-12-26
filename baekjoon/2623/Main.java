import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n, m;
    static int[] inDegree;
    static List<ArrayList<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        inDegree = new int[n + 1];

        m = Integer.parseInt(stk.nextToken());
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(stk.nextToken());
            int prev = -1;
            for(int j = 0; j < len; j++) {
                int node = Integer.parseInt(stk.nextToken());
                if (prev != -1) {
                    list.get(prev).add(node);
                    inDegree[node]++;
                }
                prev = node;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> visited = new LinkedList<>();
        while (!queue.isEmpty()) {
            int el = queue.poll();
            sb.append(el).append("\n");
            visited.add(el);
            for(int next: list.get(el)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (visited.size() != n) {
            bw.write("0\n");
        } else {
            bw.write(sb.toString());
        }

        br.close();
        bw.close();
    }
}
