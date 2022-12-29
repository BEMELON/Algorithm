import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N; 
    private int M;
    private int B; 
    private int[][] block;
    private int MIN_TIME = Integer.MAX_VALUE; 
    private int MAX_BLOCK = Integer.MIN_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
        block = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                block[i][j] = Integer.parseInt(stk.nextToken());
                min = Math.min(block[i][j], min);
                max = Math.max(block[i][j], max);
            }
        }

        for(int height = min; height <= max; height++) {
            int time = getTime(height);
            if (time != -1 && time <= MIN_TIME) {
                MIN_TIME = time;
                MAX_BLOCK = height;
            }            
        }
        System.out.printf("%d %d\n", MIN_TIME, MAX_BLOCK);
    }


    private int getTime(int mid) {
        int remain = B;
        int time = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (block[i][j] > mid) {
                    remain += (block[i][j] - mid);
                    time += ((block[i][j] - mid) * 2);
                } else {
                    remain -= (mid - block[i][j]);
                    time += (mid - block[i][j]);
                }
            }
        }

        if (remain < 0)
            return -1; 
        return time;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}