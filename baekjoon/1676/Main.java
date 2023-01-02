import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solve();
    }

    private void solve() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }

        System.out.println(count);
    }
}