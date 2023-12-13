import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Move {
    int x, y, currentDir;

    public Move(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.currentDir = dir;
    }

    public boolean containPos(int tx, int ty) {
        int[] xMoves = Main.dx[currentDir];
        int[] yMoves = Main.dy[currentDir];

        return x + xMoves[1] == tx && y + yMoves[1] == ty;
    }

    @Override
    public String toString() {
        return "Move{" +
                "x=" + x +
                ", y=" + y +
                ", currentDir=" + getDirName(currentDir) +
                '}';
    }

    private String getDirName(int currentDir) {
        if (currentDir == Main.DIR_HOR) return "수평";
        else if (currentDir == Main.DIR_DIA) return "대각";
        return "수직";
    }

    @Override
    public boolean equals(Object o) {
        Move mo = (Move) o;

        return mo.x == x && mo.y == y && mo.currentDir == currentDir;
    }


}

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] grid;

    static int DIR_HOR = 0, DIR_DIA = 1, DIR_VER = 2;

    static  int[][] dx = {
            {0, 0},
            {0, 1},
            {0, 1}
    }, dy = {
            {0, 1},
            {0, 1},
            {0, 0}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for(int i = 0;  i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        if (grid[n - 1][n - 1] == 1) {
            System.out.println(0);
            return ;
        }

        Stack<Move> stack = new Stack<>();
        stack.push(new Move(0, 0, DIR_HOR));

        int answer = 0;
        while (!stack.isEmpty()) {
            Move m = stack.pop();
            // 끝에 도달한 경우
            if (m.containPos(n - 1, n - 1)) {
                answer++;
                continue;
            }

            // 현재 방향 기준으로 다음 방향 확인
            int currentDir = m.currentDir;
            List<Integer> nextDirs = getNextDirs(currentDir);

            int nx = m.x + dx[m.currentDir][1], ny = m.y + dy[m.currentDir][1];

            for(int nextDir: nextDirs) {
                if (canMove(nx, ny, nextDir)) {
                    stack.push(new Move(nx, ny, nextDir));
                }
            }

        }

        System.out.println(answer);
    }

    private static boolean canMove(int nx, int ny, int dir) {
        if (!inRange(nx, ny)) return false;
        else if (grid[nx][ny] == 1) return false;

        if (dir == DIR_HOR) {
            return inRange(nx, ny + 1) && grid[nx][ny + 1] != 1;
        } else if (dir == DIR_VER) {
            return inRange(nx + 1, ny) && grid[nx + 1][ny] != 1;
        } else {
            return inRange(nx, ny + 1) && grid[nx][ny + 1] != 1 &&
                   inRange(nx + 1, ny) && grid[nx + 1][ny] != 1 &&
                   inRange(nx + 1, ny + 1) && grid[nx + 1][ny + 1] != -1;
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    

    private static List<Integer> getNextDirs(int currentDir) {
        ArrayList<Integer> nextDirs = new ArrayList<>();
        if (currentDir == DIR_HOR) {
            nextDirs.add(DIR_HOR); nextDirs.add(DIR_DIA);
        } else if (currentDir == DIR_DIA) {
            nextDirs.add(DIR_DIA); nextDirs.add(DIR_HOR); nextDirs.add(DIR_VER);
        } else {
            nextDirs.add(DIR_VER); nextDirs.add(DIR_DIA);
        }

        return nextDirs;
    }
}
