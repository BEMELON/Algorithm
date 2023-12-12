import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N가지의 물품
// P의 가격, Q의 양
// S 이상 구매한 경우 무료, 아니면 K 수수료 부과

public class Main {
    static StringTokenizer stk;
    static int n, s, k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        s = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        long sum = 0;
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(stk.nextToken());
            int amount = Integer.parseInt(stk.nextToken());
            sum += ((long) price * amount);
        }

        if (sum >= s) {
            System.out.println(sum);
        } else {
            System.out.println(sum + k);
        }
    }
}
