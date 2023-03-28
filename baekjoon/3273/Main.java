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

        // 해당 값을 사용해서 X를 만들 수 있는 경ㅇ우의 수를 저장하는 HashMap
        Map<Integer, Integer> count = new HashMap<>();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            // 두 수의 합이기 때문에, (X - arr[i])가 HashMap에 있는지 확인하면 arr[i]는 자동으로 확인됨  
            int diff = X - arr[i];

            // count에 diff가 있다면, 그 값만큼 answer에 더해줌
            // 더하는 이유는, 중복된 값이 있을 수 있기 때문인데 예시로, 
            // 3 3 3 3 3 같은 경우가 해당된다.
            if (count.containsKey(diff)) {
                answer += count.get(diff);
            }

            // HashMap 업데이트
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(answer);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}