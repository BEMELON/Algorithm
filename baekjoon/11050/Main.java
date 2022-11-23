import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int[] memory;

    public int factorial(int N) {
        if (N <= 1)
            return 1;

        if (memory[N] != 0)
            return memory[N];
        int result = N * factorial(N - 1);
        memory[N] = result;
        return memory[N];
    }
    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bf.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        memory = new int[N + 1];
        System.out.println(factorial(N) / (factorial(K) *factorial(N - K)));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
