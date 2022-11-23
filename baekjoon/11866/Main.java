import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++)
            q.add(i + 1);

        int K = Integer.parseInt(inputs[1]);


        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(q.size() > 1) {

            for(int i = 0; i < K - 1; i++) {
                int val = q.poll();
                q.offer(val);
            }

            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
