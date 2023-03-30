import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.naming.ldap.ExtendedRequest;

class State {
    int x, y; 
    int count; 
    boolean canBreak; 

    public State(int x, int y, int count, boolean canBreak) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.canBreak = canBreak;
    }
}

public class Main {
    private int min = Integer.MAX_VALUE;
    private int N, M;

    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M]; 
        // [0] : 벽을 부수지 않은 세계관
        // [1] : 벽을 부수는 세계관
        boolean[][][] visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) == '0';
            }
        }

        Queue<State> queue = new LinkedList<>(); 
        queue.add(new State(0, 0, 0, true));

        while (!queue.isEmpty()) {
            State prev = queue.poll(); 

            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            if (prev.x == N - 1 && prev.y == M - 1) {
                System.out.println(prev.count + 1);
                return ;
            }

            for(int i = 0; i < 4; i++) {
                int next_x = prev.x + dx[i];
                int next_y = prev.y + dy[i];

                if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M) continue;

                if (map[next_x][next_y]) {  // 벽이 아닌 경우
                    if (prev.canBreak && !visited[next_x][next_y][0]) { // 벽을 부순 적이 없는 경우
                        visited[next_x][next_y][0] = true;
                        queue.add(new State(next_x, next_y, prev.count + 1, prev.canBreak));
                    } else if (!prev.canBreak && !visited[next_x][next_y][1]) { // 벽을 부순 적이 있는 경우
                        visited[next_x][next_y][1] = true;
                        queue.add(new State(next_x, next_y, prev.count + 1, prev.canBreak));
                    }
                } else {
                    if (prev.canBreak && !visited[next_x][next_y][0]) { // 벽을 부순 적이 없는 경우
                        // 벽을 부순다.
                        visited[next_x][next_y][1] = true; 
                        queue.add(new State(next_x, next_y, prev.count + 1, false));
                    }
                }
            }
        }

        System.out.println("-1");
    }  

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}