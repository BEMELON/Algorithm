import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] maze = new int[N][M];
        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            if (x == N - 1 && y == M - 1) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (next_x < 0 || next_y < 0 || next_x >= M || next_y >= N)
                    continue;
                
                if (maze[next_y][next_x] == 1) {
                    if (visited[next_y][next_x] && dist[next_y][next_x] >= dist[y][x] + 1)
                        continue;

                    if (visited[next_y][next_x])
                        dist[next_y][next_x] = Math.min(dist[next_y][next_x], dist[y][x] + 1);
                    else
                        dist[next_y][next_x] = dist[y][x] + 1;
                    if (!visited[next_y][next_x])
                        queue.add(new int[] {next_x, next_y});
                    visited[next_y][next_x] = true;

                }
            }
        }

        System.out.println(dist[N - 1][M - 1] + 1);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}