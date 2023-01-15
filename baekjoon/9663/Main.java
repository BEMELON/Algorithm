import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        System.out.println(BackTracking(board, visited, 0, N));
    }

    private int BackTracking(int[][] board, boolean[][] visited, int i, int n) {
        if (i == n) {
            return 1;
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            if (isPossible(board, visited, i, j, n)) {
                visited[i][j] = true;
                count += BackTracking(board, visited, i + 1, n);
                visited[i][j] = false;
            }
        }

        return count;
    }

    private boolean isPossible(int[][] board, boolean[][] visited, int i, int j, int n) {
        if (visited[i][j]) {
            return false;
        }

        for (int k = 0; k < n; k++) {
            if (visited[k][j]) {
                return false;
            }
        }

        for (int k = 0; k < n; k++) {
            if (visited[i][k]) {
                return false;
            }
        }

        int x = i;
        int y = j;
        while (x >= 0 && y >= 0) {
            if (visited[x][y]) {
                return false;
            }
            x--;
            y--;
        }

        x = i;
        y = j;
        while (x >= 0 && y < n) {
            if (visited[x][y]) {
                return false;
            }
            x--;
            y++;
        }

        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}