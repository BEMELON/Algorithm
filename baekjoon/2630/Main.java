import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int cnt_white = 0;
    private int cnt_blue = 0;
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(paper, 0, 0, N);

        System.out.println(cnt_white);
        System.out.println(cnt_blue);
    }

    private void divide(int[][] paper, int i, int j, int n) {
        if (isColored(paper, i, j, n)) {
            if (paper[i][j] == 1) {
                cnt_blue += 1;
            } else {
                cnt_white += 1;
            }
            return ;
        }

        for(int r = 0; r < 2; r++) {
            for(int c = 0; c < 2; c++) {
                divide(paper, i + r * (n / 2), j + c * (n / 2), n / 2);
            }
        }
    }
    private boolean isColored(int[][] paper, int i, int j, int n) {
        int color = paper[i][j];

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if (paper[i + r][j + c] != color)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}