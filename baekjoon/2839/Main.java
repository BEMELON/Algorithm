import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int answer = Integer.MAX_VALUE;
    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int count = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N = 0;
            } else {
                count += 1;
                N -= 3;
            }
        }

        if (N == 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
