import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                stack.pop();
            else 
                stack.push(num);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum +=  (int) stack.pop();
        }

        System.out.println(sum);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}