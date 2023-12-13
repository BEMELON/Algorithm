import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x, count;

    public Node(int x, int count) {
        this.x = x;
        this. count = count;
    }

}


public class Main {
    static StringTokenizer stk;
    static int a, b;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());

        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.count - b.count);
        Set<Integer> visited = new HashSet<>();

        queue.add(new Node(a, 0));
        visited.add(a);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == b) {
                System.out.println(curr.count + 1);
                return;
            }

            int next = curr.x * 2;
            if (next <= b && !visited.contains(next)) {
                queue.add(new Node(next, curr.count + 1));
                visited.add(next);
            }

            String nStr = curr.x + "1";
            if (nStr.length() >= 10) continue;

            next = Integer.parseInt(curr.x + "1");
            if (next <= b && !visited.contains(next)) {
                queue.add(new Node(next, curr.count + 1));
                visited.add(next);
            }
        }

        System.out.println(-1);
    }
}
