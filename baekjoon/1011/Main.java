package baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1011
 *  1. DFS 완전탐색 -> StackOverFlow
 *  2. DFS + Memory ->
 *  3. Math --> Solve
 */
public class Main {
    public static Integer solve(int start, int end) {
        int distance = end - start;
        int max_int = (int) Math.floor(Math.sqrt(distance));

        if (max_int * max_int == distance) {
            return 2 * max_int - 1;
        } else if (max_int * max_int < distance && distance <= (max_int * max_int) + max_int) {
            return 2 * max_int;
        } else {
            return 2 * max_int + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            Integer answer = solve(start, end);
            System.out.println(answer);
        }
    }
}
