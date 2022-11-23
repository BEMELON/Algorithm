import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String[] inputs = bf.readLine().split(" ");
            String operation = inputs[0];
            switch (operation) {
                case "push_front":
                    int value = Integer.parseInt(inputs[1]);
                    queue.addFirst(value);
                    break;
                case "push_back":
                    queue.addLast(Integer.parseInt(inputs[1]));
                    break;
                case "front":
                    if (queue.isEmpty())
                        stringBuilder.append("-1\n");
                    else
                        stringBuilder.append(queue.peekFirst()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        stringBuilder.append("-1\n");
                    else
                        stringBuilder.append(queue.peekLast()).append("\n");
                    break;
                case "size":
                    stringBuilder.append(queue.size()).append("\n");
                    break;
                case "empty":
                    stringBuilder.append(queue.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "pop_front":
                    if (queue.isEmpty())
                        stringBuilder.append("-1\n");
                    else
                        stringBuilder.append(queue.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    if (queue.isEmpty())
                        stringBuilder.append("-1\n");
                    else
                        stringBuilder.append(queue.removeLast()).append("\n");
                    break;

            }
        }

        System.out.println(stringBuilder);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
