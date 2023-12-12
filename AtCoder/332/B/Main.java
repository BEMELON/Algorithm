import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Glass 와 Mug 를 판매 중, 가용용량은 Glass < Mug
// 모든 컵은 비어있고, K번의 연산 이후 glass와 mug에 각각 얼마나 들어있는지 출력
// 1. Glass가 꽉차있다면, glass에 있는 물을 모두 버림
// 2. Mug가 비어있다면 Mug를 물로 채움
// 3. Mug가 비어있지 않다면, Mug에서 Glass로 물을 이동 (Mug가 비었거나, Glass가 꽉찰때까지)
public class Main {
    static StringTokenizer stk;
    static int k, g, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        k = Integer.parseInt(stk.nextToken());
        g = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int waterOfGlass = 0, waterOfMug = 0;

        while (k-- > 0) {
            if (waterOfGlass == g) {
                waterOfGlass = 0;
            } else if (waterOfMug == 0) {
                waterOfMug = m;
            } else {
                if (waterOfGlass + waterOfMug <= g) {
                    waterOfGlass += waterOfMug;
                    waterOfMug = 0;
                } else {
                    waterOfMug -= (g - waterOfGlass);
                    waterOfGlass = g;
                }
            }
        }

        System.out.println(waterOfGlass + " " + waterOfMug);
    }
}
