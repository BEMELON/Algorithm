import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] fix = new int[M + 1];
        for (int i=1; i<=M; i++) {
            fix[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[50];
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        for(int i=3; i<=N; i++) {
            count[i] = count[i-1] + count[i-2];
        }

        long answer = 1;
        for(int i=1; i<=M; i++) {
            int fixCnt = fix[i] - fix[i-1] - 1;
            answer *= count[fixCnt];
        }
        // 마지막 덩어리 처리
        answer *= count[N - fix[M]];

        System.out.println(answer);
    }

}