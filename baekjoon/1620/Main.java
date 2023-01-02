import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // HashMap for int key and String value
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        // HashMap for String key and int value
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(i, name);
            map2.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                int num = Integer.parseInt(str);
                System.out.println(map.get(num - 1));
            } else {
                System.out.println(map2.get(str) + 1);
            }
        }
    }
}