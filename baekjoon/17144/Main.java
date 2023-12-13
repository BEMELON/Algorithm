import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    static int r, c, t;
    static int[][] grid, nextGrid;

    static Pos topAC, bottomAC;

    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        grid = new int[r][c];
        for(int i = 0; i < r; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());

                if (grid[i][j] == -1) {
                    if (topAC == null) topAC = new Pos(i, j);
                    else bottomAC = new Pos(i, j);
                }
            }
        }


        while (t-- > 0) {
            nextGrid = new int[r][c];
            nextGrid[topAC.x][topAC.y] = nextGrid[bottomAC.x][bottomAC.y] = -1;

            simulateDust();
            simluateAC();

            grid = nextGrid;
        }

        System.out.println(getDustAmount());

    }

    private static void simluateAC() {
        // topAC 반시계
        int x = topAC.x, y = topAC.y;
        int[] acx = {-1, 0, 1, 0}, acy = {0, 1, 0, -1};

        for(int d = 0; d < 4; d++) {
            int nx = x + acx[d], ny = y + acy[d];

            while (inRange(nx, ny) && nx <= topAC.x && nextGrid[nx][ny] != -1) {
                if (nextGrid[x][y] != -1)
                    nextGrid[x][y] = nextGrid[nx][ny];

                x = nx; y = ny;
                nx = x + acx[d]; ny = y + acy[d];
            }
            nextGrid[x][y] = 0;
        }

        // bottomAC 시계
        x = bottomAC.x; y = bottomAC.y;
        int[] cx = {1, 0, -1, 0}, cy = {0, 1, 0, -1};

        for(int d = 0; d < 4; d++) {
            int nx = x + cx[d], ny = y + cy[d];

            while (inRange(nx, ny) && nx >= bottomAC.x && nextGrid[nx][ny] != -1) {
                if (nextGrid[x][y] != -1)
                    nextGrid[x][y] = nextGrid[nx][ny];


                x = nx; y = ny;
                nx = x + cx[d]; ny = y + cy[d];
            }
            nextGrid[x][y] = 0;
        }
    }

    private static void simulateDust() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] <= 0) continue;

                int cnt = 0;
                int unit = (int) Math.floor((double) grid[i][j] / 5);
                for(int d = 0; d < 4; d++) {
                    int nx = i + dx[d], ny = j + dy[d];

                    if (!inRange(nx, ny) || grid[nx][ny] == -1) continue;

                    nextGrid[nx][ny] += unit;
                    cnt++;
                }

                nextGrid[i][j] += grid[i][j] - (cnt * unit);
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }

    private static int getDustAmount() {
        int result = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] > 0)
                    result += grid[i][j];
            }
        }

        return result;
    }
}
