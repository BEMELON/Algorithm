import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int getGCD(int N, int M) {
        int min = Math.min(N, M);

        int gcd = 0;
        for(int i = 1; i <= min; i++) {
            if (N % i == 0 && M % i == 0)
                gcd = i;
        }

        return (gcd);
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int gcd = getGCD(N, M);
        int lcm = (N * M) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
