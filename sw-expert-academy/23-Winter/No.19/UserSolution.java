class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class UserSolution {
    private int map_size;
    private int[][] map; 
    void bfs_init(int map_size, int map[][]) {
        this.map = new int[map_size + 1][map_size + 1];
        for(int i = 0; i < map_size; i++) {
            for(int j = 0; j < map_size; j++) {
                this.map[i + 1][j + 1] = map[i][j];
            }
        }
        this.map_size = map_size;
    }

    int bfs(int x1, int y1, int x2, int y2) {
        int[][] visited = new int[map_size + 1][map_size + 1];
        int[][] dist = new int[map_size + 1][map_size + 1];
        Point[] queue = new Point[(map_size + 1) * (map_size + 1)];
        int QUEUE_SIZE = (map_size + 1) * (map_size + 1);
        Point dest = new Point(x2, y2);
        int front = 0, rear = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int nx, ny = 0;
        queue[rear++] = new Point(x1, y1);
        while (front != rear) {
            Point p = queue[front];
            front = (front + 1) % QUEUE_SIZE;
            if (visited[p.y][p.x] == 1) {
                continue;
            }

            visited[p.y][p.x] = 1;
            for(int i = 0; i < 4; i++) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                if (nx <= 0 || ny <= 0 || nx > map_size || ny > map_size) {
                    continue;
                }
                if (dest.x == nx && dest.y == ny) {
                    if (dist[ny][nx] == 0)
                        return dist[p.y][p.x] + 1;
                    else
                        return dist[ny][nx] < dist[p.y][p.x] + 1 ? dist[ny][nx] : dist[p.y][p.x] + 1;
                }
                if (map[ny][nx] == 1 || visited[ny][nx] == 1) {
                    continue;
                }

                if (dist[ny][nx] == 0)
                    dist[ny][nx] = dist[p.y][p.x] + 1;
                else
                    dist[ny][nx] = dist[ny][nx] <  dist[p.y][p.x] + 1 ? dist[ny][nx] : dist[p.y][p.x] + 1;
                queue[rear] = new Point(nx, ny);
                rear = (rear + 1) % QUEUE_SIZE;
            }
        }

        return -1;
    }	
}
