import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    static String[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        grid = new String[n][m];


        Pos curr = null;
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                String val = String.valueOf(line.charAt(j));
                grid[i][j] = val;

                if (val.equals("I"))
                    curr = new Pos(i, j);
            }
        }

        int result = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(curr);
        boolean[][] visited = new boolean[n][m];
        visited[curr.x][curr.y] = true;

        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            Pos p = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nx = p.x + dx[d], ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || grid[nx][ny].equals("X")) continue;

                if (grid[nx][ny].equals("P"))
                    result += 1;

                visited[nx][ny] = true;
                queue.add(new Pos(nx, ny));
            }
        }

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }


}
