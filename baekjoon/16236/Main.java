import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    class Fish {
        public int x;
        public int y;
        public int distance;

        public Fish(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Fish [x=" + x + ", y=" + y + ", distance=" + distance + "]";
        }
    }

    class Shark extends Fish {
        public int size = 2;
        public int remain_fish = 2;

        public Shark(int x, int y) {
            super(x, y);
        }

        public Shark(int x, int y, int distance) {
            super(x, y);
            this.distance = distance;
        }

        public void eat() {
            remain_fish--;
            if (remain_fish == 0) {
                size++;
                remain_fish = size;
            }
        }

        public void move(Fish fish) {
            this.x = fish.x;
            this.y = fish.y;
        }
    }

    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        Shark shark = findShark(map, N);

        Queue<Fish> queue = new LinkedList<>();
        queue.add(findClosestFish(map, shark, N));

        int time = 0;
        while (!queue.isEmpty()) {
            Fish fish = queue.poll();
            // System.out.println(fish);
            if (fish == null)
                break;
            map[fish.x][fish.y] = 9;
            map[shark.x][shark.y] = 0;
            // print map
            // for (int i = 0; i < N; i++) {
            // for (int j = 0; j < N; j++) {
            // System.out.print(map[i][j] + " ");
            // }
            // System.out.println();
            // }
            // System.out.printf("Shark Size : (%d/%d)\n", (shark.size - shark.remain_fish),
            // shark.size);
            time += fish.distance;
            shark.move(fish);
            shark.eat();

            Fish nextFish = findClosestFish(map, shark, N);
            if (nextFish != null)
                queue.add(nextFish);
        }

        System.out.println(time);
    }

    private Fish findClosestFish(int[][] map, Shark shark, int N) {
        int[] dx = { -1, 0, 0, 1 };
        int[] dy = { 0, -1, 1, 0 };
        boolean[][] visited = new boolean[N][N];
        Queue<Fish> queue = new LinkedList<>();
        Queue<Fish> temp = new LinkedList<>();
        queue.add(shark);
        visited[shark.x][shark.y] = true;
        while (!queue.isEmpty()) {
            Fish fish = queue.poll();

            boolean foundFish = false;
            for (int i = 0; i < 4; i++) {
                int nx = fish.x + dx[i];
                int ny = fish.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (map[nx][ny] > shark.size)
                    continue;
                visited[nx][ny] = true;
                if (map[nx][ny] != 0 && map[nx][ny] < shark.size) {
                    temp.add(new Fish(nx, ny, fish.distance));
                    foundFish = true;
                    break;
                } else if (!foundFish)
                    queue.add(new Fish(nx, ny, fish.distance + 1));
            }
        }

        Fish closestFish = null;
        while (!temp.isEmpty()) {
            Fish fish = temp.poll();
            if (closestFish == null)
                closestFish = fish;
            else {
                if (closestFish.distance > fish.distance)
                    closestFish = fish;
                else if (closestFish.distance == fish.distance) {
                    if (closestFish.x > fish.x)
                        closestFish = fish;
                    else if (closestFish.x == fish.x) {
                        if (closestFish.y > fish.y)
                            closestFish = fish;
                    }
                }
            }
        }
        return closestFish;
    }

    private Shark findShark(int[][] map, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 9)
                    return new Shark(i, j, 1);
            }
        }

        return null;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}