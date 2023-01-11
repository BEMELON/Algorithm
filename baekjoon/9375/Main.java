import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {            
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                String name = input[1];
                map.put(name, map.getOrDefault(name, 0) + 1);
            }

            
            int ans = 1;
            for(int val: map.values()) {
                ans *= (val + 1);
            }
            System.out.println(ans - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}