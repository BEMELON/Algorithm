import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < src.length(); i++) {
            stack.push(src.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean canBomb = true;
                for(int j = 0; j < bomb.length(); j++) {
                    if (stack.get((stack.size() - bomb.length()) + j) != bomb.charAt(j)) {
                        canBomb = false; break;
                    }
                }

                if (canBomb) {
                    for(int j = 0; j < bomb.length(); j++)
                        stack.pop();
                }
            }
        }

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuffer sb = new StringBuffer();
            for(Character ch: stack) {
                sb.append(String.valueOf(ch));
            }

            System.out.println(sb);
        }

    }
}
