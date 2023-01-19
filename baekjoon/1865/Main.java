import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    class Road {
        int src;
        int dest;
        int weight;

        public Road(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            int W = Integer.parseInt(stk.nextToken());

            List<List> roadList = new ArrayList<List>();
            for(int i = 0; i <= N; i++) {
                roadList.add(new ArrayList<Road>());
            }
            
            for(int road = 0; road < M; road++) {
                stk = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(stk.nextToken());
                int dest = Integer.parseInt(stk.nextToken());
                int weight = Integer.parseInt(stk.nextToken());
                
                roadList.get(src).add(new Road(src, dest, weight));
                roadList.get(dest).add(new Road(dest, src, weight));
            }

            for(int hole = 0; hole < W; hole++) {
                stk = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(stk.nextToken());
                int dest = Integer.parseInt(stk.nextToken());
                int weight = Integer.parseInt(stk.nextToken());

                roadList.get(src).add(new Road(src, dest, -weight));
            }

            boolean cycle = false; 
            for(int i = 1; i <= N; i++) {
                if (bellmanFord(roadList, i, N)) {
                    cycle = true;
                    break;
                }
            }

            if (cycle)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
 


    private boolean bellmanFord(List<List> roadList, int start, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[start] = 0;

        boolean update = false;
        for(int i = 0; i < N; i++) {
            update = false;
            for(int j = 0; j <= N; j++) {
                if (dist[j] == Integer.MAX_VALUE / 2)
                    continue;

                for(Road road : (List<Road>) roadList.get(j)) {
                    if (dist[road.dest] > dist[road.src] + road.weight) {
                        dist[road.dest] = dist[road.src] + road.weight;
                        update = true;
                    }
                }
            }

            if (!update)
                break;
        }

        if (update) {
            for(int j = 0; j <= N; j++) {
                if (dist[j] == Integer.MAX_VALUE / 2)
                    continue;

                for(Road road : (List<Road>) roadList.get(j)) {
                    if (dist[road.dest] > dist[road.src] + road.weight) {
                        dist[road.dest] = dist[road.src] + road.weight;
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}