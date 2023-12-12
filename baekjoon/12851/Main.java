import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Move {
    int pos, count;

    public Move(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}

public class Main {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        if (start >= end) {
            System.out.println(start - end);
            System.out.println(1);
            return;
        }

        Queue<Move> queue = new PriorityQueue<>((a, b) -> a.count - b.count);
        Map<Integer, Integer> visited = new HashMap<>();
        queue.add(new Move(start, 0));

        int minMove = 100000;
        int answer = 0;
        while (!queue.isEmpty()) {
            Move m = queue.poll();
            visited.putIfAbsent(m.pos, m.count);

            if (m.count > visited.get(m.pos)) continue;
            visited.put(m.pos, m.count);

            if (m.count > minMove) break;

            if (m.pos == end) {
                if (m.count == minMove) answer++;
                else answer = 1;

                minMove = m.count;
                continue;
            }

            if (inRange(m.pos + 1))
                queue.add(new Move(m.pos + 1, m.count + 1));

            if (inRange(m.pos - 1))
                queue.add(new Move(m.pos - 1, m.count + 1));

            if (inRange(m.pos * 2) && m.pos < end)
                queue.add(new Move(m.pos * 2, m.count + 1));
        }

        System.out.println(minMove);
        System.out.println(answer);
    }

    public static boolean inRange(int x) {
        return 0 <= x && x <= 100_000;
    }
}

