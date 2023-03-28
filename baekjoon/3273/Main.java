import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        int X = Integer.parseInt(br.readLine());
        Map<Integer, Integer> count = new HashMap<>();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int diff = X - arr[i];

            if (count.containsKey(diff)) {
                answer += count.get(diff);
            }

            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(answer);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}