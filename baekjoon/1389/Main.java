import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private boolean[][] friends;
    private int[][] relation; 
    private boolean[] visited;
    private int N;
    private int M;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        friends = new boolean[N + 1][N + 1];
        relation = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());

            friends[src][dest] = true;
            friends[dest][src] = true; 
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                visited = new boolean[N + 1];
                if (i == j) {
                    relation[i][j] = -1;
                } else if (friends[i][j]){
                    relation[i][j] = 1;
                } else {
                    relation[i][j] = DFS(i, j);
                }
            }
        }

        int MIN_RESULT = Integer.MAX_VALUE;
        int MIN_IDX = Integer.MAX_VALUE;
        for(int r = 1; r <= N; r++) {
            int sum = 0;
            for(int c = 1; c <= N; c++) {
                if (r == c || relation[r][c] < 0)
                    continue;
                sum += relation[r][c]; 
            }

            if (sum < MIN_RESULT) {
                MIN_RESULT = sum;
                MIN_IDX = r;
            }
        }

        System.out.println(MIN_IDX);
    }

    private int DFS(int from, int to) throws IOException {
        if (friends[from][to]) return 1;

        int min_relations = Integer.MAX_VALUE / 2;
        visited[from] = true;
        for(int i = 1; i <= N; i++) {
            if (friends[from][i] && !visited[i]) {
                min_relations = Math.min(min_relations, 1 + DFS(i, to));
            }
        }

        return min_relations;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}