import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private int cnt_minus = 0;
    private int cnt_zero = 0;
    private int cnt_plus = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solve();
    }

    private void solve() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        divide(board, 0, 0, N);

        System.out.println(cnt_minus);
        System.out.println(cnt_zero);
        System.out.println(cnt_plus);
    }

    private void divide(int[][] board, int i, int j, int n) {
        if (isSame(board, i, j, n)) {
            if (board[i][j] == -1) {
                cnt_minus++;
            } else if (board[i][j] == 0) {
                cnt_zero++;
            } else {
                cnt_plus++;
            }
        } else {
            int m = n / 3;
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    divide(board, i + a * m, j + b * m, m);
                }
            }
        }
    }

    private boolean isSame(int[][] board, int i, int j, int n) {
        int num = board[i][j];
        for (int a = i; a < i + n; a++) {
            for (int b = j; b < j + n; b++) {
                if (board[a][b] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}