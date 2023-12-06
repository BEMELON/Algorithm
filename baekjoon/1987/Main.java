import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int row, col;
    static String[][] graph;
    static int maxDistance;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        row = Integer.parseInt(stk.nextToken()); col = Integer.parseInt(stk.nextToken());


        graph = new String[row][col];
        for(int i = 0; i < row; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                graph[i][j] = String.valueOf(line.charAt(j));
            }
        }

        maxDistance = 1;
        Set<String> alphabet = new HashSet<>();
        alphabet.add(graph[0][0]);

        backtracking(0, 0, alphabet);

        System.out.println(maxDistance);
    }

    private static void backtracking(int r, int c, Set<String> alphabet) {
        maxDistance = Math.max(maxDistance, alphabet.size());
        for(int d = 0; d < 4; d++) {
            int nx = r + dx[d], ny = c + dy[d];

            if (!inRange(nx, ny) || alphabet.contains(graph[nx][ny])) continue;

            alphabet.add(graph[nx][ny]);
            backtracking(nx, ny, alphabet);
            alphabet.remove(graph[nx][ny]);
        }

    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < row && 0 <= c && c < col;
    }
}
