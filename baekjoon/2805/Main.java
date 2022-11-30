import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] trees = new long[N];

        long tree_min = 0;
        long tree_max = Long.MIN_VALUE;

        st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(tree_max < trees[i]) {
                tree_max = trees[i];
            }
        }

        long tree_height = 0;
        long tree_sum;
        while (tree_min < tree_max) {
            tree_sum = 0;
            tree_height = (tree_min + tree_max) / 2;
            for (long tree : trees) {
                if (tree > tree_height)
                    tree_sum += (tree - tree_height);
            }

            if (tree_sum < M) {
                tree_max = tree_height;
            } else {
                tree_min = tree_height + 1;
            }
        }

        System.out.println(tree_min - 1);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
