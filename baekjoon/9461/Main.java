import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] memory = new long[101];
        memory[0] = memory[1] = memory[2] = memory[3] = 1;
        for(int i = 0; i < T; i++) {
            System.out.println(find(Integer.parseInt(br.readLine()), memory));
        }
    }

    private long find(int n, long[] memory) {
        if (n <= 3) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        if (memory[n - 2] == 0) {
            memory[n - 2] = find(n - 2, memory);
        }

        if (memory[n - 3] == 0) {
            memory[n - 3] = find(n - 3, memory);
        }
        return memory[n - 2] + memory[n - 3];
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}