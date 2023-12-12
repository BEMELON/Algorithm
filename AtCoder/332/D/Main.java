import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int h, w, answer;

    static int[][] src, dest, temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        h = Integer.parseInt(stk.nextToken());
        w = Integer.parseInt(stk.nextToken());
        src = new int[h][w];
        dest = new int[h][w];
        temp = new int[h][w];
        Set<Integer> nums = new HashSet<>();
        for(int i = 0; i < h; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                src[i][j] = Integer.parseInt(stk.nextToken());
                temp[i][j] = src[i][j];
                nums.add(src[i][j]);
            }
        }

        boolean canMatch = true;
        for(int i = 0; i < h; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                dest[i][j] = Integer.parseInt(stk.nextToken());
                canMatch &= nums.contains(dest[i][j]);
            }
        }
        if (!canMatch) {
            System.out.println(-1);
            return ;
        } else if (isEqual(src, dest)) {
            System.out.println(0);
            return ;
        }


        answer = 20;
        bt(temp, 0);
        if (answer == 20) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

    private static void bt(int[][] currentGrid, int count) {
        if (count >= answer) return ;

        if (isEqual(currentGrid, dest)) {
            answer = Math.min(answer, count);
            return ;
        }

        for(int i = 0 ; i < h - 1; i++) {
            swapRows(currentGrid, i, i + 1);
            bt(currentGrid, count + 1);
            swapRows(currentGrid, i, i + 1);
        }

        for(int j = 0; j < w - 1; j++) {
            swapColumns(currentGrid, j, j + 1);
            bt(currentGrid, count + 1);
            swapColumns(currentGrid, j, j + 1);
        }
    }


    private static void swapRows(int[][] grid, int row1, int row2) {
        int[] temp = grid[row1];
        grid[row1] = grid[row2];
        grid[row2] = temp;
    }

    private static void swapColumns(int[][] grid, int col1, int col2) {
        for (int i = 0; i < h; i++) {
            int temp = grid[i][col1];
            grid[i][col1] = grid[i][col2];
            grid[i][col2] = temp;
        }
    }

    private static boolean isEqual(int[][] src, int[][] dest) {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if (src[i][j] != dest[i][j]) return false;
            }
        }

        return true;
    }
}
