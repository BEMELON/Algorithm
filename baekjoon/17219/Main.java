import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            String key = stk.nextToken();
            String value = stk.nextToken();
            map.put(key, value);
        }

        for(int i = 0; i < N; i++) {
            String key = br.readLine();
            System.out.println(map.get(key));
        }
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}