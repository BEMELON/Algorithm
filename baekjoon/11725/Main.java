import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static Map<Integer, LinkedList<Integer>> graph;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        parents = new int[n + 1];

        for(int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            graph.putIfAbsent(start, new LinkedList<>());
            graph.putIfAbsent(end, new LinkedList<>());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!stack.isEmpty()) {
            int parent = stack.pop();
            List<Integer> list = graph.get(parent);

            for(Integer next: list) {
                if (!visited[next]) {
                    parents[next] = parent;
                    visited[next] = true;
                    stack.push(next);
                }
            }

        }

        for(int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }

    }
}
