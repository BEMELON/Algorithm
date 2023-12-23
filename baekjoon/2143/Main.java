import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;

    static int T;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }

        n = Integer.parseInt(br.readLine());
        B = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(stk.nextToken());
        }

        int[] sumOfA = new int[(A.length * (A.length + 1)) / 2];
        int idx = 0;
        for(int i = 0; i < A.length; i++) {
            int sum = 0;
            for(int j = i; j < A.length; j++) {
                sum += A[j];
                sumOfA[idx++] = sum;
            }
        }

        long[] sumOfB = new long[(B.length * (B.length + 1)) / 2];
        idx = 0;
        for(int i = 0; i < B.length; i++) {
            int sum = 0;
            for(int j = i; j < B.length; j++) {
                sum += B[j];
                sumOfB[idx++] = sum;
            }
        }

        Arrays.sort(sumOfA);
        Arrays.sort(sumOfB);

        int left = 0;
        int right = sumOfB.length - 1;

        long result = 0;
        while (left < sumOfA.length && right >= 0) {
            long valueA = sumOfA[left];
            long valueB = sumOfB[right];

            if (valueB + valueA == T) {
                long equalACnt = 0;
                while (left < sumOfA.length && valueA == sumOfA[left]) {
                    left++;
                    equalACnt++;
                }

                long equalBCnt = 0;
                while (right >= 0 && valueB == sumOfB[right]) {
                    right--;
                    equalBCnt++;
                }

                result += (equalACnt * equalBCnt);
            } else if (valueB + valueA > T) {
                right--;
            } else {
                left++;
            }
        }
        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
