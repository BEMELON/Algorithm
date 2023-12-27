import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static long T;

    static long lenOfA, lenOfB;

    static long[] A, B;

    static List<Long> sumOfA, sumOfB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        lenOfA = Long.parseLong(br.readLine());
        A = new long[(int) lenOfA];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < lenOfA; i++) {
            A[i] = Long.parseLong(stk.nextToken());
        }

        lenOfB = Long.parseLong(br.readLine());
        stk = new StringTokenizer(br.readLine());
        B = new long[(int) lenOfB];
        for(int i = 0; i < lenOfB; i++) {
            B[i] = Long.parseLong(stk.nextToken());
        }

        long result = 0;
        sumOfA = new ArrayList<>();
        sumOfB = new ArrayList<>();

        for(int i = 0; i < lenOfA; i++) {
            long temp = A[i];
            for(int j = i + 1; j < lenOfA; j++) {
                sumOfA.add(temp);
                temp += A[j];
            }
            sumOfA.add(temp);
        }


        for(int i = 0; i < lenOfB; i++) {
            long temp = B[i];
            for(int j = i + 1; j < lenOfB; j++) {
                sumOfB.add(temp);
                temp += B[j];
            }
            sumOfB.add(temp);
        }

        sumOfB.sort(Comparator.comparingLong(a -> a));
        sumOfA.sort(Comparator.comparingLong(a -> a));
        int left = 0, right = sumOfB.size() - 1;

        while (left < sumOfA.size() && right >= 0) {
            long elementOfA = sumOfA.get(left);
            long elementOfB = sumOfB.get(right);
            if (elementOfB + elementOfA == T) {
                int leftCursor = left;
                int leftCount = 0;
                while (leftCursor < sumOfA.size() && sumOfA.get(leftCursor) == elementOfA) {
                    leftCursor++;
                    leftCount++;
                }

                left = leftCursor;

                int rightCursor = right;
                int rightCount = 0;
                while (rightCursor >= 0 && sumOfB.get(rightCursor) == elementOfB) {
                    rightCursor--;
                    rightCount++;
                }

                right = rightCursor;

                result += ((long) leftCount * rightCount);
            } else if (elementOfB + elementOfA > T) {
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
