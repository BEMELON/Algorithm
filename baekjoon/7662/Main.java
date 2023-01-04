import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.size() == 0) {
                        continue;
                    }

                    int count;
                    int n;
                    if (num == 1) {
                        n = map.lastKey();
                        count = map.remove(map.lastKey());
                    } else {
                        n = map.firstKey();
                        count = map.remove(map.firstKey());
                    }
                    
                    if (count > 1) {
                        map.put(n, count - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastEntry().getKey() + " " + map.firstEntry().getKey()).append("\n");
            }
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}