import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private boolean[][] farm; 
    private boolean[][] visited;
    private int M;
    private int N;
    private int answer;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            stk = new StringTokenizer(br.readLine());
            M = Integer.parseInt(stk.nextToken());
            N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());

            farm = new boolean[M][N];
            visited = new boolean[M][N];
            answer = 0;

            for(int x = 0; x < K; x++) {
                stk = new StringTokenizer(br.readLine());
                int pos_x = Integer.parseInt(stk.nextToken());
                int pos_y = Integer.parseInt(stk.nextToken());
                
                farm[pos_x][pos_y] = true;
            }

            DFS(); 

            System.out.println(answer);
        }
    }

    private void DFS() {
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if (farm[r][c] && !visited[r][c]) {
                    putWarm(r, c);
                    answer += 1;
                }
            }
        }
    }

    private void putWarm(int r, int c) {
        if (r < 0 || c < 0 || r >= M || c >= N) return;

        if (visited[r][c] || !farm[r][c]) return;

        visited[r][c] = true; 
        putWarm(r + 1, c);
        putWarm(r - 1, c);
        putWarm(r, c + 1);
        putWarm(r, c - 1);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}