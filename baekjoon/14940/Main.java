import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int row, col, dist;

    public Pos(int row, int col) {
        this.row = row;
        this.col = col;
        this.dist = 0;
    }

    public Pos(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pos)) return false;

        Pos p = (Pos) obj;

        return p.row == this.row && p.col == this.col;
    }
}


public class Main {
    static StringTokenizer stk;
    static int[][] grid, result;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];
        result = new int[n][m];

        Pos curr = new Pos(-1, -1);
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int x = Integer.parseInt(stk.nextToken());
                grid[i][j] = x;

                if (x == 2)
                    curr = new Pos(i, j, 0);
            }
        }

         boolean[][] visited = new boolean[n][m];
         visited[curr.row][curr.col] = true;
         int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

        Queue<Pos> queue = new LinkedList<>();
        queue.add(curr);

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            result[p.row][p.col] = p.dist;

            for(int d = 0; d < 4; d++) {
                int nx = p.row + dx[d], ny = p.col + dy[d];

                if (!inRange(nx, ny) || grid[nx][ny] != 1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new Pos(nx, ny, p.dist + 1));

            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] != 0)
                    sb.append(-1).append(" ");
                else
                    sb.append(result[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
