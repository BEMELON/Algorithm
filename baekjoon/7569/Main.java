import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void printArray(int[][][] arr) {
        System.out.println("printArray");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());
        int H = Integer.parseInt(str.nextToken());

        int[][][] farm = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                str = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    farm[i][j][k] = Integer.parseInt(str.nextToken());
                }
            }
        }

        // find zero in farm
        boolean zero = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (farm[i][j][k] == 0) {
                        zero = true;
                    }
                }
            }
        }

        if (!zero) {
            System.out.println(0);
            return;
        }

        // BFS for farm
        int[][][] visited = new int[H][N][M];
        int[] dx = { 0, 0, 0, 0, 1, -1 };
        int[] dy = { 0, 0, 1, -1, 0, 0 };
        int[] dz = { 1, -1, 0, 0, 0, 0 };

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (farm[i][j][k] == 1) {
                        queue.add(new int[] { i, j, k });
                        visited[i][j][k] = 1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[2] + dz[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= N || nz < 0 || nz >= M) {
                    continue;
                }

                if (farm[nx][ny][nz] == 0 && visited[nx][ny][nz] == 0) {
                    farm[nx][ny][nz] = farm[cur[0]][cur[1]][cur[2]] + 1;
                    visited[nx][ny][nz] = 1;
                    queue.add(new int[] { nx, ny, nz });
                } else if (farm[nx][ny][nz] != 0) {
                    farm[nx][ny][nz] = Math.min(farm[nx][ny][nz], farm[cur[0]][cur[1]][cur[2]] + 1);
                }
            }
        }

        // find non-visited farm
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (visited[i][j][k] == 0 && farm[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, farm[i][j][k]);
                }
            }
        }
        System.out.println(max - 1);
    }
}