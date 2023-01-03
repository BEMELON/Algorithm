import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String cmd = stk.nextToken();
            int num;
            switch (cmd) {
                case "add":
                    num = Integer.parseInt(stk.nextToken());
                    if (!set.contains(num))
                        set.add(num);
                    break;
                
                case "check":
                    num = Integer.parseInt(stk.nextToken());
                    if (set.contains(num)) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "remove":
                    num = Integer.parseInt(stk.nextToken());
                    if (set.contains(num)) {
                        set.remove(num);
                    }
                    break;
                
                case "toggle":
                    num = Integer.parseInt(stk.nextToken());
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                
                case "all":
                    set.clear();
                    for(int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                
                case "empty":
                    set.clear();
                    break;

            }
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}