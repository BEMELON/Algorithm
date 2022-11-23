import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int height = Integer.parseInt(inputs[0]);
            int width  = Integer.parseInt(inputs[1]);
            int customerNumber = Integer.parseInt(inputs[2]);

            int row = 0;
            int col = 1;
            for(int j = 0; j < customerNumber; j++) {
                if (row >= height) {
                    row = 1;
                    col += 1;
                } else
                    row += 1;
            }
            System.out.printf("%d%02d\n", row, col);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
