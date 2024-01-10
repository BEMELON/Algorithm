import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class App {
    int mem,  cost;

    public App(int mem, int cost) {
        this.mem = mem;
        this.cost = cost;
    }
}

public class Main {
    static StringTokenizer stk;
    static int n, m;

    static List<App> apps;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        apps = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            apps.add(new App(Integer.parseInt(stk.nextToken()), 0));
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            apps.get(i).cost = Integer.parseInt(stk.nextToken());
        }

        // dp[i] = j, i번째까지 App을 이용했을 때 최대 절약할 수 있는 메모리의 양
        int[] dp = new int[10001];

        for(int i = 0; i < apps.size(); i++) {
            App app = apps.get(i);
            for(int memory = 10000; memory >= app.cost; memory--) {
                dp[memory] = Math.max(dp[memory], dp[memory - app.cost] + app.mem);
            }
        }

        for(int i = 0; i < 10001; i++) {
            if (dp[i] >= m) {
                bw.write(i + "\n");
                break;
            }
        }

        br.close();
        bw.close();
    }
}
