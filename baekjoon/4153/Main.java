import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            int z = Integer.parseInt(inputs[2]);

            if (x == 0 && y == 0 && z == 0) break;

            if (x > Math.max(y, z)) {
                if (x * x == (y * y) + (z * z)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if (y > Math.max(x, z)) {
                if (y * y == (x * x) + (z * z)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if (z > Math.max(x, y)) {
                if (z * z == (x * x) + (y * y)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
