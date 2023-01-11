import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) != Math.abs(o2))
                    return Math.abs(o1) - Math.abs(o2);
                if (o1 < o2)
                    return -1;
                else if (o1 > o2)
                    return 1;
                else
                    return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (heap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(heap.poll()).append("\n");
                }
            } else {
                heap.add(x);
            }
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}