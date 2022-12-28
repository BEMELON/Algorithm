import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            
            if (line.equals(".")) break;
            
            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            for(int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '[' || ch == '(') {
                    stack.push((int) ch);
                } else if (ch == ']' || ch == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                    } else {
                        int top = stack.pop(); 

                        if ((ch == ']' && top != '[') || (ch == ')' && top != '('))
                            flag = false; 
                    }
                }
            }

            if (flag && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}