import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String N = bf.readLine();
        int n = Integer.parseInt(N);

        for(int i = 1; i <= n; i++) {
            int sum = i;
            String str = String.valueOf(i);
            for(int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';
            }

            if (sum == n) {
                System.out.println(i);
                return ;
            }
        }

        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
