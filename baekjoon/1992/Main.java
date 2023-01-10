import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] tree = new int[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                tree[i][j] = str.charAt(j) - '0';
            }
        }

        DFS(tree, 0, 0, N);
        System.out.println();
    }

    private void DFS(int[][] tree, int i, int j, int n) {
        

        if (checkTree(tree, i, j, n)) {
            System.out.print(tree[i][j]);
        } else {
            int max = n / 2;
            System.out.print("(");
            DFS(tree, i, j, max);
            DFS(tree, i, j + max, max);
            DFS(tree, i + max, j, max); 
            DFS(tree, i + max, j + max, max);
            System.out.print(")");
        }
    }
    private boolean checkTree(int[][] tree, int r, int c, int max) {
        int color = tree[r][c];
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < max; j++) {
                if (color != tree[r + i][c + j])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}