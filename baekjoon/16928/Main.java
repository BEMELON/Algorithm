import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    class Pair {
        int x;
        int dice;

        public Pair(int x, int dice) {
            this.x = x;
            this.dice = dice;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        int[] map = new int[101];
        int[] move = new int[101];
        boolean[] visited = new boolean[101];
        for (int i = 1; i <= 100; i++) {
            map[i] = i + 1;
        }
        map[100] = 100;

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            map[src] = dest;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            map[src] = dest;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int next = p.x;
            int dice = p.dice;

            visited[next] = true;
            int nextJump = -1;
            for (int i = next; i <= (next + 6) && i <= 100; i++) {
                if (move[i] == 0)
                    move[i] = dice + 1;

                if (map[i] != i + 1) {
                    if (!visited[map[i]])
                        queue.add(new Pair(map[i], dice + 1));
                    else if (move[map[i]] == 0)
                        move[map[i]] = dice + 1;
                    else
                        move[map[i]] = Math.min(move[map[i]], dice + 1);
                } else {
                    nextJump = i;
                }
            }

            if (nextJump != -1 && !visited[nextJump])
                queue.add(new Pair(nextJump, dice + 1));

        }

        System.out.println(move[100]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
