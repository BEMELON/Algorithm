import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Pos  {
        int row, col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            Pos other = (Pos) obj;

            return other.col == this.col && other.row == this.row;
        }
    }
    static StringTokenizer stk;
    static int n, m;
    static int[][] grid, nextGrid;

    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    static List<Pos> posList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        grid = new int[m][n];

        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        findPositions();

        int maxSafeAreas = 0;
        for(int i = 0; i < posList.size(); i++) {
            for(int j = i + 1; j < posList.size(); j++) {
                for(int k = j + 1; k < posList.size(); k++) {
                    setWall(posList.get(i), posList.get(j), posList.get(k));
                    maxSafeAreas = Math.max(maxSafeAreas, getSafeArea());

                }
            }
        }
        System.out.println(maxSafeAreas);
    }

    private static int getSafeArea() {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (nextGrid[i][j] == 2) {
                    Queue<Pos> queue = new LinkedList<>();
                    queue.add(new Pos(i, j));
                    Set<Pos> visited = new HashSet<>();
                    while (!queue.isEmpty()) {
                        Pos p = queue.poll();

                        for(int d = 0; d < 4; d++) {
                            int nx = p.row + dx[d], ny = p.col + dy[d];

                            Pos next = new Pos(nx, ny);
                            if (!inRange(nx, ny) || visited.contains(next) || nextGrid[nx][ny] != 0) continue;
                            nextGrid[nx][ny] = 2;
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
        }

        int safeArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(nextGrid[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        return safeArea;
    }

    private static void setWall(Pos pos, Pos pos1, Pos pos2) {
        nextGrid = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                nextGrid[i][j] = grid[i][j];
            }
        }

        nextGrid[pos.row][pos.col] = nextGrid[pos1.row][pos1.col] = nextGrid[pos2.row][pos2.col] = 1;
    }


    private static void findPositions() {
        posList = new ArrayList<>();

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if (grid[r][c] != 0) continue;
                posList.add(new Pos(r, c));
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }
}

