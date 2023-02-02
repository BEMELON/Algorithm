import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            boolean[][] visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j] && isSafe(map, i, j)) {
                        cnt++;
                        spread(i, j, map, visited, true);
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) {
                        cnt++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static boolean isSafe(char[][] map, int i, int j) {
        if (i - 1 >= 0 && map[i - 1][j] == '*') return false;
        if (i + 1 < map.length && map[i + 1][j] == '*') return false;
        if (j - 1 >= 0 && map[i][j - 1] == '*') return false;
        if (j + 1 < map.length && map[i][j + 1] == '*') return false;
        if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == '*') return false;
        if (i - 1 >= 0 && j + 1 < map.length && map[i - 1][j + 1] == '*') return false;
        if (i + 1 < map.length && j - 1 >= 0 && map[i + 1][j - 1] == '*') return false;
        if (i + 1 < map.length && j + 1 < map.length && map[i + 1][j + 1] == '*') return false;

        return true;
    }

    private static void spread(int i, int j, char[][] map, boolean[][] visited, boolean CanGo) {
        if (i < 0 || i >= map.length || j < 0 || j >= map.length) return;
        if (map[i][j] == '*' || visited[i][j]) return;

        visited[i][j] = true;
        CanGo = isSafe(map, i, j);
        if (!CanGo) {
            return;
        }
        spread(i - 1, j, map, visited, CanGo);
        spread(i + 1, j, map, visited, CanGo);
        spread(i, j - 1, map, visited, CanGo);
        spread(i, j + 1, map, visited, CanGo);
        spread(i - 1, j - 1, map, visited, CanGo);
        spread(i - 1, j + 1, map, visited, CanGo);
        spread(i + 1, j - 1, map, visited, CanGo);
        spread(i + 1, j + 1, map, visited, CanGo);
    }

}