import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(1);
            return ;
        }

        int level = 1;
        int range = 2;

        while (range <= N) {
            range = range + (6 * level);
            level++;
        }

        System.out.println(level);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
