import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Pos {
    int pos, time;

    public Pos(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }
}
public class Main {
    static StringTokenizer stk;
    static int start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        start = Integer.parseInt(stk.nextToken());
        end = Integer.parseInt(stk.nextToken());

        // start < end
        int[] visited = new int[100_001];
        Arrays.fill(visited, 100_100);

        visited[start] = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(start, 0));

        while (!queue.isEmpty()) {
            Pos p = queue.poll();

            int prev = p.pos - 1;
            if (inRange(prev) && visited[prev] > (p.time + 1)) {
                visited[prev] = p.time + 1;
                queue.add(new Pos(prev, visited[prev]));
            }

            int next = p.pos + 1;
            if (inRange(next) && visited[next] > (p.time + 1)) {
                visited[next] = p.time + 1;
                queue.add(new Pos(next, visited[next]));
            }

            int jump = p.pos * 2;
            if (inRange(jump) && visited[jump] > p.time) {
                visited[jump] = p.time;
                queue.add(new Pos(jump, visited[jump]));
            }
        }

        System.out.println(visited[end]);
    }

    public static boolean inRange(int x) {
        return 0 <= x && x <= 100_000;
    }
}
