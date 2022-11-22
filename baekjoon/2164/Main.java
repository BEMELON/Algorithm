import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++)
            queue.add(i);

        while (queue.size() > 1) {
            queue.poll();

            Integer head = queue.poll();
            queue.add(head);
        }

        System.out.println(queue.peek());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
