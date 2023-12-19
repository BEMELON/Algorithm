import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static Map<Integer,Integer> inDegree;
    static Map<Integer, ArrayList<Integer>> graph;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m =  Integer.parseInt(stk.nextToken());

        inDegree = new HashMap<>();
        graph = new HashMap<>();
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            graph.putIfAbsent(first, new ArrayList<>());
            graph.get(first).add(end);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> pq = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if (!inDegree.containsKey(i)) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int student = pq.poll();

            sb.append(student).append(" ");
            if (graph.containsKey(student)) {
                for(int next: graph.get(student)) {
                    inDegree.put(next, inDegree.get(next) - 1);

                    if (inDegree.get(next) == 0)
                        pq.add(next);
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
