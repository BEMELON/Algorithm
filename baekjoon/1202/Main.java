import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Diamond {
    int weight, value;

    public Diamond(int w, int v) {
        this.weight = w;
        this.value = v;
    }
}


public class Main {
    static StringTokenizer stk;
    static int n, k;
    static Diamond[] diamonds;

    static int[] bags;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        diamonds = new Diamond[n];

        for(int i =0 ; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(stk.nextToken());
            int value = Integer.parseInt(stk.nextToken());

            diamonds[i] = new Diamond(weight, value);
        }

        bags = new int[k];
        for(int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(bags);
        Arrays.sort(diamonds, (a, b) -> {
            if (a.weight == b.weight) {
                return b.value - a.value;
            }

            return a.weight - b.weight;
        });

        long result = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int diaIdx = 0;
        for(int bagCap: bags) {

            while (diaIdx < n && diamonds[diaIdx].weight <= bagCap) {
                pq.add(diamonds[diaIdx++].value);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
