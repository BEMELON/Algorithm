import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n;

    static Map<Integer, ArrayList<Integer>> dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            dp.put(i, new ArrayList<>());
        }

        dp.get(1).add(1);
        for(int i = 2; i <= n; i++) {
            dp.get(i).add(i);

            List<Integer> rest = dp.get(i - 1);

            if (i % 3 == 0 && rest.size() > dp.get(i / 3).size()) {
                rest = dp.get(i / 3);
            }

            if (i % 2 == 0 && rest.size() > dp.get(i / 2).size()) {
                rest = dp.get(i / 2);
            }

            dp.get(i).addAll(rest);
        }

        bw.write(dp.get(n).size() - 1 + " \n");

        for(int el: dp.get(n)) {
            bw.write(el + " ");
        }
        bw.write("\n");
        br.close();
        bw.close();
    }
}
