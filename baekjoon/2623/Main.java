import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n, m;
    static Map<Integer, ArrayList<Integer>> graph;
    static int[] inDegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new HashMap<>();
        for(int i = 0; i <= n; i++)
            graph.put(i, new ArrayList<>());

        inDegree = new int[n + 1];
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(stk.nextToken());

            int prev = -1;
            for(int j = 0; j < len; j++) {
                int curr = Integer.parseInt(stk.nextToken());

                if (prev != -1) {
                    graph.get(prev).add(curr);
                    inDegree[curr]++;
                }

                prev = curr;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            for(int next: graph.get(curr)) {
                inDegree[next]--;

                if (inDegree[next] == 0)
                    queue.add(next);
            }
        }

        if (order.size() != n) {
            bw.write("0");
        } else {
            for(int el: order) {
                bw.write(el + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
