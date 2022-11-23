import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        bf.readLine();
        int[] cards = new int[20000002];

        String[] inputs = bf.readLine().split(" ");
        for(String n : inputs) {
            cards[Integer.parseInt(n) + 10000000] += 1;
        }
        bf.readLine();
        String[] numbers = bf.readLine().split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for(String n : numbers) {
            stringBuilder.append(cards[Integer.parseInt(n) + 10000000]).append(" ");
        }

        System.out.println(stringBuilder);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
