import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stk = new StringTokenizer(br.readLine());
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        int minIdx = -1, maxIdx = -1;
        int left = 0, right = n - 1;
        long minSum = Long.MAX_VALUE;

        while (left < right) {
            long dist = Math.abs(nums[left] + nums[right]);

            if (dist <= minSum) {
                minSum = dist;
                minIdx = left;
                maxIdx = right;
            }

            if ((long) nums[left] + nums[right] < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(nums[minIdx] + " " + nums[maxIdx]);
    }
}
