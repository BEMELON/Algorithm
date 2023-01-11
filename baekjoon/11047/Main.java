import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[] tokens = new int[N];
        for(int i = 0; i < N; i++) {
            tokens[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        while (K > 0) {
            for(int i = N - 1; i >= 0; i--) {
                if (K >= tokens[i]) {
                    int temp = K / tokens[i];
                    K -= (temp * tokens[i]);
                    count += temp;
                }
            }
        }

        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}