import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            }
        }

        // sort set
        int[] sortedArr = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            sortedArr[idx++] = i;
        }
        Arrays.sort(sortedArr);

        for(int i = 0; i < N; i++) {
            arr[i] = Arrays.binarySearch(sortedArr, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}