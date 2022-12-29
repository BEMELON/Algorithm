import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y + "\n";
        }
    }

    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Point> list = new ArrayList<>();

        StringTokenizer stk; 

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            list.add(new Point(x, y));
        }

        list.sort(((p0, p1) -> {
            if (p0.y == p1.y)
                return p0.x - p1.x;
            return p0.y - p1.y;
        }));

        StringBuilder sb = new StringBuilder();
        for(Point p: list) {
            sb.append(p);
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}