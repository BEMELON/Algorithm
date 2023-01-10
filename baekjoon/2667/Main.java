import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int count = 1; 
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Position> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (findPosition(map, visited, N) != null) {
            queue.add(findPosition(map, visited, N));

            while (!queue.isEmpty()) {
                Position position = queue.poll();
                if (visited[position.x][position.y]) {
                    continue;
                } 
                visited[position.x][position.y] = true;
                map[position.x][position.y] = count;
                for(int i = 0; i < 4; i++) {
                    int next_x = position.x + dx[i];
                    int next_y = position.y + dy[i];
    
                    if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) {
                        continue;
                    }
    
                    if (map[next_x][next_y] == 1) {
                        queue.add(new Position(next_x, next_y));
                    }
                }
            }

            count++;
        }

        int[] result = new int[count - 1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    result[map[i][j] - 1]++;
                }
            }
        }

        System.out.println(count - 1);
        Arrays.sort(result);
        for(int i = 0; i < count - 1; i++) {
            System.out.println(result[i]);
        }
       
    }

    private Main.Position findPosition(int[][] map, boolean[][] visited, int N) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    return new Position(i, j);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}