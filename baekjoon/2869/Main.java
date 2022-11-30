import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        double A = Integer.parseInt(tk.nextToken());
        double B = Integer.parseInt(tk.nextToken());
        double V = Integer.parseInt(tk.nextToken());

        int result = (int) Math.ceil(((V - B) / (A - B)));
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
