import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int[] board;
    private int N;
    private int max_bishop;
    public void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.N = Integer.parseInt(br.readLine());
        this.board = new int[N * N];
        for(int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                board[i * N + j] = Integer.parseInt(tk.nextToken());
            }
        }
    }

    public boolean isValid() {
        for(int i = 0; i < this.N * this.N; i++) {
            if (this.board[i] == 2 && !(validUpperLeftCross(i) && validUpperRightCross(i)))
                return false;
        }
        return true;
    }

    private boolean validUpperRightCross(int idx) {
        if ((idx % this.N) == (this.N - 1)) return true;

        idx -= (this.N - 1);
        while (idx >= 0) {
            if (this.board[idx] == 2)
                return false;

            if ((idx % this.N) == (this.N - 1)) return true;
            idx -= (this.N - 1);
        }

        return true;
    }

    private boolean validUpperLeftCross(int idx) {
        if (idx % this.N == 0) return true;

        idx -= (this.N + 1);
        while (idx >= 0) {
            if (this.board[idx] == 2)
                return false;

            if (idx % this.N == 0) return true;
            idx -= (this.N + 1);
        }

        return true;
    }

    private boolean isBlack(int idx) {
        int row = idx / this.N;
        int col = idx % this.N;

        if (row % 2 == 0) {
            return col % 2 == 0;
        } else {
            return col % 2 == 1;
        }
    }
    public void backtracking(int idx, int count, boolean isBlack) {
        for(int i = idx; i < this.N * this.N; i++) {
            if (this.board[i] == 0 || isBlack(i) != isBlack)
                continue;
            else if (!isValid())
                return ;
            this.board[i] = 2;
            backtracking(i + 1, count + 1, isBlack);
            this.board[i] = 1;
        }

        if (isValid()) {
            this.max_bishop = Math.max(this.max_bishop, count);
        }
    }

    public void solve() throws IOException {
        getInput();

        if (this.N == 1) {
            System.out.println(this.board[0]);
        } else {
            // Black
            this.max_bishop = 0;
            backtracking(0, 0, true);
            int black_bishop = this.max_bishop;

            // White
            this.max_bishop = 0;
            backtracking(1, 0, false);
            int white_bishop = this.max_bishop;

            System.out.println(black_bishop + white_bishop);
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
