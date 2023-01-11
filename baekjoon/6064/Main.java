import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int M = sc.nextInt(), N = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();

            int lcm = M * N / gcd(M, N);
            int n = 0;
            int ans = -1;
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    ans = n * M + x;
                    break;
                }
                n++;
            }

            System.out.println(ans);
        }
    }
    private int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}