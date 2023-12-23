import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);
        int[] result = new int[3];

        long minDist = Long.MAX_VALUE;
        for(int std = 0; std < n; std++) {
            int left = std + 1, right = n - 1;

            while (left < right) {
                long dist = (long) arr[left] + arr[right] + arr[std];

                if (Math.abs(dist) < minDist) {
                    minDist = Math.abs(dist);
                    result[0] = std; result[1] = left; result[2] = right;
                    }

                if (dist < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        bw.write(arr[result[0]] + " " + arr[result[1]] + " " + arr[result[2]]);
        br.close();
        bw.close();
    }
}
