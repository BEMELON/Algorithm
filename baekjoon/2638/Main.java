import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class Main {
    static StringTokenizer stk;
    static int n, m;

    static int[][] grid, nextGrid;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];

        int remainCheeze = 0;
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int x = Integer.parseInt(stk.nextToken());
                grid[i][j] = x;

                if (x == 1)
                    remainCheeze++;
            }
        }

        for(int j = 0; j < m; j++) {
            grid[0][j] = 2;
            grid[n - 1][j] = 2;
        }

        for(int i = 0; i < n; i++) {
            grid[i][0] = 2;
            grid[i][m - 1] = 2;
        }

        // 최초 전파
        simulate(grid);

        int time = 0;
        while (remainCheeze > 0) {
            nextGrid = new int[n][m];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if (grid[i][j] != 1) continue;

                    int expose = 0;
                    for(int d = 0; d < 4; d++) {
                        int nx = i + dx[d], ny = j + dy[d];

                        if (!inRange(nx, ny) || grid[nx][ny] == 2) expose++;
                    }

                    if (expose >= 2) {
                        nextGrid[i][j] = 2;
                        remainCheeze--;
                    } else {
                        nextGrid[i][j] = 1;
                    }
                }
            }

            grid = nextGrid;
            simulate(grid);


            time++;
        }

        System.out.println(time);
    }

    private static void simulate(int[][] grid) {
        // BFS
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] != 2 || visited[i][j]) continue;
                Queue<Pos> q = new LinkedList<>();
                q.add(new Pos(i, j));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Pos p = q.poll();

                    for(int d = 0; d < 4; d++) {
                        int nx = p.x + dx[d], ny = p.y + dy[d];

                        if (!inRange(nx, ny) || grid[nx][ny] != 0 || visited[nx][ny]) continue;

                        visited[nx][ny] = true;
                        grid[nx][ny] = 2;
                        q.add(new Pos(nx, ny));
                    }
                }
            }
        }


    }

    private static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }

    private static void printGrid() {
        for(int[] g: grid)
            System.out.println(Arrays.toString(g));

        System.out.println();
    }

}
