import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] map = new String[N];
        boolean[][] visited = new boolean[N][N];
        int visit_count = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        int normal_answer = 0;
        while (visit_count < N * N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visit_count += DFS(i, j, map[i].charAt(j), map, visited);
                        normal_answer++;
                    }
                }
            }
        }

        visit_count = 0;
        visited = new boolean[N][N];
        int abnormal_answer = 0;
        while (visit_count < N * N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visit_count += DFS_A(i, j, map[i].charAt(j), map, visited);
                        abnormal_answer++;
                    }
                }
            }
        }

        System.out.println(normal_answer + " " + abnormal_answer);
    }

    private int DFS_A(int i, int j, char color, String[] map, boolean[][] visited) {
        if (i < 0 || i >= map.length || j < 0 || j >= map.length || visited[i][j]) {
            return 0;
        }
        if ((color == 'R' || color == 'G') && (map[i].charAt(j) == 'R' || map[i].charAt(j) == 'G')) {
            visited[i][j] = true;
            return 1 + DFS_A(i - 1, j, color, map, visited) + DFS_A(i + 1, j, color, map, visited)
                    + DFS_A(i, j - 1, color, map, visited)
                    + DFS_A(i, j + 1, color, map, visited);
        } else if (color == 'B' && map[i].charAt(j) == color) {
            visited[i][j] = true;
            return 1 + DFS_A(i - 1, j, 'B', map, visited) + DFS_A(i + 1, j, 'B', map, visited)
                    + DFS_A(i, j - 1, 'B', map, visited)
                    + DFS_A(i, j + 1, 'B', map, visited);
        }

        return 1;
    }

    private int DFS(int i, int j, char color, String[] map, boolean[][] visited) {
        if (i < 0 || i >= map.length || j < 0 || j >= map.length || visited[i][j] || map[i].charAt(j) != color) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + DFS(i - 1, j, color, map, visited) + DFS(i + 1, j, color, map, visited)
                + DFS(i, j - 1, color, map, visited)
                + DFS(i, j + 1, color, map, visited);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}