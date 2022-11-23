import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y + "\n";
        }
    }
    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Point> points = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] inputs = bf.readLine().split(" ");
            points.add(new Point(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }

        points.sort((p1, p2) -> {
            if (p1.x != p2.x)
                return (p1.x - p2.x);
            return p1.y - p2.y;
        });

        StringBuilder sb = new StringBuilder();
        for(Point p: points)
            sb.append(p);

        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
