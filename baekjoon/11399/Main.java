import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] waitlist = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            waitlist[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(waitlist);

        int total = 0;
        int time = 0;
        for(int i = 0 ; i < N; i++) {
            time += waitlist[i];
            total += time;
        }

        System.out.println(total);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}