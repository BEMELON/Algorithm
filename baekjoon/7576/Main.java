import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        boolean[][] visited = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Already filled with tomatos
        if (checkTomatos(map)) {
            System.out.println(0);
            return;
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 1) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W || visited[nx][ny] || map[nx][ny] == -1) {
                        continue;
                    }

                    if (map[nx][ny] == -1) {
                        continue;
                    }

                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[cur[0]][cur[1]] + 1;
                        queue.add(new int[] { nx, ny });
                    } else if (map[nx][ny] != 1) {
                        map[nx][ny] = Math.min(map[nx][ny], map[cur[0]][cur[1]] + 1);
                        queue.add(new int[] { nx, ny });
                    }

                }
            }
        }

        // find Max in map
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }

        System.out.println(max - 1);
    }

    private boolean checkTomatos(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}