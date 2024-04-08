 // 12:04 시작 -> 13:06분 
 // -1 % 3 이 언제부터 -1이였지? Math.floodMod 로 해결 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Snake {
    public int row, col; 
    Snake next; 

    public Snake(int row, int col) {
        this.row = row;
        this.col = col; 
        this.next = null; 
    }
}

public class Main {
    static int[][] grid;
    static int n;
    static Map<Integer, String> dirList;
    static int APPLE = 1;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; 
    static Snake head;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ex6.txt")));
        StringTokenizer stk;
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        dirList = new HashMap<>();

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(stk.nextToken());
            int col = Integer.parseInt(stk.nextToken());
            grid[row - 1][col - 1] = APPLE; 
        }

        int l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++) {
            stk = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(stk.nextToken());
            String dir = stk.nextToken();

            dirList.put(sec, dir); 
        }

        // 좌측 상단에 뱀 위치, 오른쪽 보고 있음
        head = new Snake(0, 0);
        int snakeDir = 0;  

        // 시작은 0초, 1초? 
        int time = 1; 

        while (true) {

            // 1. 몸길이를 늘려 머리를 다음칸에 위치 
            int nr = head.row + dr[snakeDir], nc = head.col + dc[snakeDir]; 

            // 2. 충돌 확인 (벽, 자기 자신의 몸)
            if (!inRange(nr, nc) || onSnake(nr, nc)) break; 

            // 3. 이동한 칸에 사과가 있는 지 
            // 3.1 머리 연장
            Snake newHead = new Snake(nr, nc); 
            newHead.next = head;
            head = newHead;

            if (grid[nr][nc] != APPLE) {
                // 4. 사과가 있지 않다면, 꼬리 이동 -> next의 좌표를 현재 좌표로 변경  
                // 4.1 꼬리 짜르기 
                Snake curr = head; 
                Snake prev = curr; 
                while (curr.next != null) {
                    prev = curr;
                    curr = curr.next;
                }

                prev.next = null;
            } else {
                grid[nr][nc] = 0;
            }
            
            // 5. 초 끝났을 대 방향 변환 확인
            if (dirList.get(time) != null) {
                String nextDir = dirList.get(time);
                if (nextDir.equals("L")) {
                    snakeDir = Math.floorMod(snakeDir - 1, 4);
                } else {
                    snakeDir = (snakeDir + 1) % 4;  
                }
            }
            
            // debug();
            // System.out.printf("time %d, dir : %d\n", time, snakeDir);

            // 6. 시간 경과
            time++;
        }

        System.out.println(time);
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n; 
    }

    public static boolean onSnake(int r, int c) {
        Snake curr = head;

        while (curr != null) {
            if (curr.row == r && curr.col == c) 
                return true; 
            
            curr = curr.next; 
        }

        return false; 
    }

    public static void debug() {
        int[][] map = new int[n][n];
        for(int i =0 ; i < n; i++) {
            for(int j = 0; j < n; j++){
                map[i][j] = grid[i][j];
            }
        }
        Snake curr = head; 
        
        while (curr != null) {
            map[curr.row][curr.col] = 9;
            curr = curr.next;
        }

        for(int[] m: map) {
            System.out.println(Arrays.toString(m));
        } 
    }

    public static void printSnake() {
        Snake curr = head; 
        while (curr != null) {
            System.out.printf("-> (%d, %d) ", curr.row, curr.col);
            curr = curr.next;
        }
        System.out.println();
    }

 }