    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main {
        static StringTokenizer stk;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String word = br.readLine();
            int idx = Integer.parseInt(br.readLine());

            System.out.println(word.charAt(idx - 1));
        }
    }
