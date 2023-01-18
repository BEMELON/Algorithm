import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int numOfKnown = Integer.parseInt(stk.nextToken());
        int[] known = new int[numOfKnown];
        for (int i = 0; i < numOfKnown; i++) {
            known[i] = Integer.parseInt(stk.nextToken());
        }

        int[][] party_people = new int[M + 1][N + 1];
        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(stk.nextToken());
            for(int j = 0; j < partyNum; j++) {
                int person = Integer.parseInt(stk.nextToken());
                party_people[i + 1][person] = 1;
            }
        } 


        boolean[] partyVisited = new boolean[M + 1];
        boolean[] peopleSelcted = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numOfKnown; i++) {
            queue.add(known[i]);
            peopleSelcted[known[i]] = true;
        }

        if (queue.isEmpty()) {
            System.out.println(M);
            return;
        }

        int partyCount = 0; 
        while (!queue.isEmpty() && partyCount < M) {
            int people = queue.poll();
            for(int i = 1; i <= M; i++) {
                if (party_people[i][people] == 1) {
                    if (!partyVisited[i]) {
                        partyVisited[i] = true;
                        partyCount++;
                    }
                    for(int j = 1; j <= N; j++) {
                        if (party_people[i][j] == 1 && !peopleSelcted[j]) {
                            queue.add(j);
                            peopleSelcted[j] = true;
                        }
                    }
                }
            }
        }
        if (partyCount == 0) {
            System.out.println(M);
        } else {
            System.out.println(M - partyCount);
        }
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}