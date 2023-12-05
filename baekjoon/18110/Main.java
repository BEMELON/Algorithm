import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        int score = 0;
        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        if (pq.isEmpty()) {
            System.out.println(score);
            return;
        }

        int size = pq.size();
        int exclude = (int) Math.round(pq.size() * 0.15);
        int sum = 0;
        for(int i = 0; i < (size - exclude); i++) {
            if (i < exclude) {
                pq.poll();
                continue;
            }

            int x = pq.poll();
            sum += x;
        }

        System.out.println((int) Math.round((float) sum / (size - 2 * exclude)));

    }
}
