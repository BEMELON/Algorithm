import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n, m;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        // 위상정렬
        // 선행 문제가 없는 문제들에 대해서 PriorityQueue 하면 되나?
        // 조건이 하나 없는데, 먼저 푸는 문제가 1개인게 확실한건지?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        inDegree = new int[n + 1];
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            graph.get(A).add(B);
            inDegree[B]++;
        }

        Queue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int p = 1; p <= n; p++) {
            if (inDegree[p] == 0) {
                pq.add(p);
            }
        }


        while (!pq.isEmpty()) {
            int currentProblem = pq.poll();
            sb.append(currentProblem).append(" ");

            for(int nextProblem: graph.get(currentProblem)) {
                inDegree[nextProblem]--;

                if (inDegree[nextProblem] == 0)
                    pq.add(nextProblem);
            }
        }


        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
