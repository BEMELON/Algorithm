import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer stk;
    static String[][] grid;
    static int n, m;
    static int THRESH_HOLD = 10;
    static int result = 11;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        grid = new String[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                grid[i][j] = String.valueOf(line.charAt(j));
            }
        }

        BackTracking(0, -1, grid);

        if (result > THRESH_HOLD) {
            bw.write("-1\n");
        } else {
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }

    private static void BackTracking(int tries, int move, String[][] curr) {
        if (tries > THRESH_HOLD) {
            return ;
        } else if (canFinishGame(curr)) {
            result = Math.min(result, tries);
            return ;
        }

        for(int d = 0; d < 4; d++) {
            if (d == move) continue; // 같은 방향 한번 더 해봤자 의미 없음
            String[][] next = simulate(curr, d);
            BackTracking(tries + 1, d, next);

        }
    }

    private static String[][] simulate(String[][] curr, int d) {

        if (d == 0) return moveUp(curr);
        else if (d == 1) return moveLeft(curr);
        else if (d == 2) return moveDown(curr);
        else return moveRight(curr);

    }

    private static String[][] moveRight(String[][] curr) {
        String[][] next = initNext();
        printGrid("\n==> [RIGHT] BEFORE", curr);

        for(int row = 1; row < n - 1; row++) {
            for(int col = m - 1; col > 0; col--) {
                if (isBall(curr[row][col])) {
                    int cursor = col;
                    while (cursor < m - 1) {
                        int nextCursor = cursor + 1;

                        if (isExit(curr[row][nextCursor])) {
                            break;
                        } else if (isWall(next[row][nextCursor]) || isBall(next[row][nextCursor])) {
                            // 벽이나 공을 만난 경우 그 자리에 멈춤
                            next[row][cursor] = curr[row][col];
                            break ;
                        }
                        cursor++;
                    }


                }
            }
        }

        printGrid("\n==> [RIGHT] AFTER", next);

        return next;
    }

    private static String[][] moveDown(String[][] curr) {
        String[][] next = initNext();
        printGrid("\n==> [DOWN] BEFORE", curr);
        for(int col = 1; col < m - 1; col++) {
            for(int row = n - 1; row > 0; row--) {
                if (isBall(curr[row][col])) {
                    int cursor = row;
                    while (cursor < n - 1) {
                        int nextCursor = cursor + 1;

                        if (isExit(curr[nextCursor][col])) {
                            break;
                        }else if (isWall(next[nextCursor][col]) || isBall(next[nextCursor][col])) {
                            // 벽이나 공을 만난 경우 그 자리에 멈춤
                            next[cursor][col] = curr[row][col];
                            break ;
                        }

                        cursor++;
                    }


                }
            }
        }

        printGrid("\n==> [DOWN] AFTER", next);


        return next;
    }

    private static String[][] moveLeft(String[][] curr) {
        String[][] next = initNext();
        printGrid("\n==> [LEFT] BEFORE", curr);
        for(int row = 1; row < n - 1; row++) {
            for(int col = 1; col < m - 1; col++) {
                if (isBall(curr[row][col])) {
                    int cursor = col;
                    while (cursor > 0) {
                        int nextCursor = cursor - 1;

                        if (isExit(curr[row][nextCursor])) {
                            break;
                        } else if (isWall(next[row][nextCursor]) || isBall(next[row][nextCursor])) {
                            // 벽이나 공을 만난 경우 그 자리에 멈춤
                            next[row][cursor] = curr[row][col];
                            break ;
                        }

                        cursor--;
                    }


                }
            }
        }

        printGrid("\n==> [LEFT] AFTER", next);
        return next;
    }

    private static String[][] initNext() {
        String[][] curr = new String[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (isBall(grid[i][j])) {
                    curr[i][j] = ".";
                } else {
                    curr[i][j] = grid[i][j];
                }
            }
        }

        return curr;
    }

    private static String[][] moveUp(String[][] curr) {
        String[][] next = initNext();
        printGrid("\n==> [UP] BEFORE", curr);
        for(int col = 1; col < m - 1; col++) {
            for(int row = 1; row < n - 1; row++) {
                if (isBall(curr[row][col])) {
                    int cursor = row;
                    while (cursor > 0) {
                        int nextCursor = cursor - 1;

                        if (isExit(curr[nextCursor][col])) {
                            break;
                        } else if (isWall(next[nextCursor][col]) || isBall(next[nextCursor][col])) {
                            // 벽이나 공을 만난 경우 그 자리에 멈춤
                            next[cursor][col] = curr[row][col];
                            break ;
                        }


                        cursor--;
                    }


                }
            }
        }

        printGrid("\n==> [UP] AFTER", next);

        return next;
    }

    private static boolean isWall(String s) {
        return s.equals("#");
    }

    private static boolean isBall(String s) {
        return s.equals("B") || s.equals("R");
    }

    private static boolean isExit(String s) {
        return s.equals("O");
    }
    private static boolean canFinishGame(String[][] curr) {
        boolean red = false, blue = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (curr[i][j].equals("R")) red = true;
                else if (curr[i][j].equals("B")) blue = true;
            }
        }

        return !red && blue;
    }

    private static void printGrid(String msg, String[][] map) {
//        System.out.println(msg);
//        for(String[] x: map) {
//            System.out.println(Arrays.toString(x));
//        }
    }

}
