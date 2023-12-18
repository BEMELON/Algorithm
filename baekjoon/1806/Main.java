import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int N, S;
    static int[] nums;
    static int[] len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());

        nums =  new int[N];
        len = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }


        int start = 0, end = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            int next = nums[i];

            sum += next;
            end = i;

            if (sum < S) {
                len[i] = Integer.MAX_VALUE / 16;
            } else {
                while (sum - nums[start] >= S) {
                    sum -= nums[start];
                    start++;
                }

                len[i] = end - start + 1;
            }

        }

        int answer = Integer.MAX_VALUE / 8;
        for(int el: len) {
            answer = Math.min(answer, el);
        }


        if (answer > N) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
