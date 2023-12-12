import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  0, 1, 2로 이루어진 N자리 String S가 들어옴.
 *   0 : Plan X
 *   1 : 외식
 *   2 : CP 참여
 *
 *
 *   M개의 Plain 티셔츠가 있음, 모두 세척됨
 *    > 조건에 맞도록 AtCoder 티셔츠를 구매할 예정
 *
 *    1.  외식을 하는 경우, 일반 혹은 AtCoder 티셔츠를 입음
 *    2. CP에 참여하는 경우 AtCoder 티셔츠
 *    3. 아무일정도 없는 경우 모든 티셔츠 세탁을 함
 *    4. 티셔츠를 입는 경우, 다시 세척할 동안 다시 입지 않음.
 */
public class Main {
    static StringTokenizer stk;
    static int n, m;
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        s = br.readLine();

        int amountOfShirts = m, amountOfAtCoder = 0;

        // 가장 오래 이어지는 대회 일정 > 최소 Atcoder 티셔츠 개수
        // 가장 오래 이어지는 외식 일정 > 최소 티셔츠 개수


        // if AtCoder-티셔츠 개수 + m >= 최소 티셔츠 개수  -> AtCoder-티셔츠 개수
        // else AtCoder-티셔츠 개수 + (최소 티셔츠 개수 - m)

        int maxOutgoing = 0, maxContest = 0;

        int longOfOutgoing = 0, longOfContest = 0;
        for(Character ch: s.toCharArray()) {
            int type = ch - '0';
            if (type == 0) {
                maxOutgoing = Math.max(maxOutgoing, longOfOutgoing);
                maxContest = Math.max(maxContest, longOfContest);

                longOfContest = 0;
                longOfOutgoing = 0;
            } else if (type == 1) {
                longOfOutgoing++;
            } else {
                longOfContest++;
                longOfOutgoing++;
            }

        }
        maxOutgoing = Math.max(maxOutgoing, longOfOutgoing);
        maxContest = Math.max(maxContest, longOfContest);

        if (maxContest + m >= maxOutgoing) {
            System.out.println(maxContest);
        } else {
            System.out.println(maxContest + (maxOutgoing - (maxContest + m)));
        }

    }
}
