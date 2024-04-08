// 14:10분 시작

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, mainTh, subTh;
    static int[] rooms;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        rooms = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        mainTh = Integer.parseInt(stk.nextToken());
        subTh = Integer.parseInt(stk.nextToken());

        long answer = 0;
        for(int room : rooms) {
            room -= mainTh;
            // System.out.printf("Rest : %d\n", room);

            if (room > 0) {
                answer += Math.ceil((double) room / subTh);
                // System.out.printf("Need more (%f)\n", Math.max(1, Math.ceil((double) room / subTh)));
            }

            answer += 1;
        }
        System.out.println(answer);

    }
}