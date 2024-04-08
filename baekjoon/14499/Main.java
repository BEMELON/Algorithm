import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // TOP/상/하/좌/우/BOTTOM
    static int[] dice = new int[6];
    static int[][] grid;
    static int n, m, r ,c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
    
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int dir = Integer.parseInt(stk.nextToken());
            
            int[] nextPos = getNextPos(dir); 
            int nx = nextPos[0], ny = nextPos[1]; 

            if (!inRange(nx, ny)) continue;

            if (dir == 1) {
                int temp = dice[0]; 
                dice[0] = dice[3];
                dice[3] = dice[5]; 
                dice[5] = dice[4]; 
                dice[4] = temp;

            } else if (dir == 2) {
                int temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp; 

            } else if (dir == 3) {
                int temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp; 

            } else {
                int temp = dice[0];
                dice[0] = dice[1]; 
                dice[1] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp; 
            }

            if (grid[nx][ny] == 0) {
                grid[nx][ny] = dice[5];
            } else {
                dice[5] = grid[nx][ny];
                grid[nx][ny] = 0;
            }

            r = nx; c = ny;
            System.out.println(dice[0]);
        }
    }
    private static int[] getNextPos(int dir) {
       if (dir == 1) {
        return new int[] {r, c + 1};
       } else if (dir == 2) {
        return new int[] {r, c - 1};
       } else if (dir == 3) {
        return new int[] {r - 1, c};
       }

       return new int[] {r + 1, c};
    }
    private static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }
}