import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;

    static int n, result;
    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        result = 0;
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            temp[i] = grid[i].clone();
        }

        backtracking(0, temp);

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    private static void backtracking(int cnt, int[][] temp) {
        if (cnt == 5) {
            result = Math.max(result, getMax(temp));
            return;
        }

        backtracking(cnt + 1, up(temp));
        backtracking(cnt + 1, down(temp));
        backtracking(cnt + 1, left(temp));
        backtracking(cnt + 1, right(temp));
    }

    private static int[][] up(int[][] temp) {
        int[][] next = new int[n][n];

        for(int col = 0; col < n; col++) {
            int nextIdx = 0;

            for(int row = 0; row < n; row++) {
                if (next[nextIdx][col] == 0) {
                    next[nextIdx][col] = temp[row][col];
                } else {
                    if (next[nextIdx][col] == temp[row][col]) {
                        next[nextIdx][col] *= 2;
                        nextIdx++;
                    } else {
                        next[row][col] = temp[row][col];
                    }
                }
            }
        }

        return next;
    }

    private static int[][] down(int[][] temp) {
        int[][] next = new int[n][n];

        for(int col = 0; col < n; col++) {
            int nextIdx = n - 1;

            for(int row = n - 1; row >= 0; row--) {
                if (next[nextIdx][col] == 0) {
                    next[nextIdx][col] = temp[row][col];
                } else {
                    if (next[nextIdx][col] == temp[row][col]) {
                        next[nextIdx][col] *= 2;
                        nextIdx--;
                    } else {
                        next[row][col] = temp[row][col];
                    }
                }
            }
        }

        return next;
    }

    private static int[][] left(int[][] temp) {
        int[][] next = new int[n][n];

        for(int row = 0; row < n; row++) {
            int nextIdx = 0;

            for(int col = 0; col < n; col++) {
                if (next[row][nextIdx] == 0) {
                    next[row][nextIdx] = temp[row][col];
                } else {
                    if (next[row][nextIdx] == temp[row][col]) {
                        next[row][nextIdx] *= 2;
                        nextIdx++;
                    } else {
                        next[row][col] = temp[row][col];
                    }
                }
            }
        }

        return next;
    }

    private static int[][] right(int[][] temp) {
        int[][] next = new int[n][n];

        for(int row = 0; row < n; row++) {
            int nextIdx = n - 1;

            for(int col = n - 1; col >= 0; col--) {
                if (next[row][nextIdx] == 0) {
                    next[row][nextIdx] = temp[row][col];
                } else {
                    if (next[row][nextIdx] == temp[row][col]) {
                        next[row][nextIdx] *= 2;
                        nextIdx--;
                    } else {
                        next[row][col] = temp[row][col];
                    }
                }
            }
        }

        return next;
    }



    private static int getMax(int[][] temp) {
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, temp[i][j]);
            }
        }
        return max;
    }
}
