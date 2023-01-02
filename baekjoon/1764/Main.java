import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
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

        // Hash for String
        HashMap<String, Integer> hash1 = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            hash1.put(str, i);
        }

        // Hash for String
        HashMap<String, Integer> hash2 = new HashMap<String, Integer>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            hash2.put(str, 1);
        }

        // Intersect of hash1, hash2
        LinkedList<String> list = new LinkedList<>();
        for (String key : hash1.keySet()) {
            if (hash2.containsKey(key)) {
                list.add(key);
            }
        }

        // sort list by alphabet
        list.sort(null);

        System.out.println(list.size());
        for (String str : list) {
            System.out.println(str);
        }
    }
}