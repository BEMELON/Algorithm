import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        for(int i = 0; i < N; i++) {
            String line = bf.readLine();
            int stack = 0;
            boolean valid = true;
            for(int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '(') {
                    stack++;
                } else if (ch == ')') {
                    if (stack > 0)
                        stack--;
                    else
                        valid = false;
                }
            }
            if (valid && stack == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
