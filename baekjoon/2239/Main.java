import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static StringTokenizer stk;

    static int[][] answer;

    static List<Pos> blanks;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] grid = new int[10][10];
        blanks = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            String line = br.readLine();
            for(int j = 1; j <= 9; j++) {
                grid[i][j] = line.charAt(j - 1) - '0';
                if (grid[i][j] == 0) {
                    blanks.add(new Pos(i, j));
                }
            }
        }
        solve(grid,0);

        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                bw.write(answer[i][j] + "");
            }
            bw.write("\n");
        }


        br.close();
        bw.close();
    }

    private static void solve(int[][] currentGrid, int idx) {
        if (answer != null) return ;
        else if (idx == blanks.size()) {

            answer = new int[10][10];
            for(int i = 0; i <= 9; i++) {
                System.arraycopy(currentGrid[i], 0, answer[i], 0, 10);
            }

            return ;
        }

        Pos curr = blanks.get(idx);

        List<Integer> candidates = getCandidates(currentGrid, curr);
        for(int next: candidates) {
            currentGrid[curr.x][curr.y] = next;
            solve(currentGrid, idx + 1);
            currentGrid[curr.x][curr.y] = 0;
        }
    }

    private static List<Integer> getCandidates(int[][] grid, Pos curr) {
        int x = curr.x, y = curr.y;

        Set<Integer> candidates = new HashSet<>();
        for(int i = 1; i <= 9; i++) {
            candidates.add(i);
        }

        // 가로 후보자
        for(int c = 1; c <= 9; c++) {
            if (grid[x][c] == 0) continue;

            candidates.remove(grid[x][c]);
        }

        // 세로 후보자
        for(int r = 1; r <= 9; r++) {
            if (grid[r][y] == 0) continue;

            candidates.remove(grid[r][y]);
        }

        int startRow = 3 * (((x - 1) / 3)) + 1, startCol = 3 * (((y - 1) / 3)) + 1;

        for(int r = startRow; r < startRow + 3; r++) {
            for(int c = startCol; c < startCol + 3; c++) {
                if (grid[r][c] == 0) continue;

                candidates.remove(grid[r][c]);
            }
        }

        return new ArrayList<>(candidates);
    }
}
