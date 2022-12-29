import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(list[i]).append('\n');
        }

        System.out.printf("%s", sb);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}