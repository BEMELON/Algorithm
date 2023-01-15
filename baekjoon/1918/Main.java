import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringBuilder output = new StringBuilder();

        Stack stack = new Stack();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty()) {
                    char pop = (char) stack.pop();
                    if (pop == '(') {
                        break;
                    }
                    output.append(pop);
                }
            } else if (isOperator(ch)) {
                if (stack.isEmpty()) {
                    stack.add(ch);
                } else {
                    char top = (char) stack.peek();
                    if (top == '(') {
                        stack.add(ch);
                    } else {
                        if ((ch == '+' || ch == '-') && (top == '*' || top == '/')) {
                            while (!stack.isEmpty()) {
                                char pop = (char) stack.pop();
                                if (pop == '(') {
                                    stack.add(pop);
                                    break;
                                }
                                output.append(pop);
                            }
                            stack.add(ch);
                        } else if ((ch == '*' || ch == '/') && (top == '+' || top == '-')) {
                            stack.add(ch);
                        } else if ((ch == '*' || ch == '/') && (top == '*' || top == '/')) {
                            while (!stack.isEmpty()) {
                                char pop = (char) stack.pop();
                                if (pop == '(' || pop == '+' || pop == '-') {
                                    stack.add(pop);
                                    break;
                                }
                                output.append(pop);
                            }
                            stack.add(ch);
                        } else if ((ch == '+' || ch == '-') && (top == '+' || top == '-')) {
                            output.append(stack.pop());
                            stack.add(ch);
                        }
                    }
                }
            } else {
                output.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        System.out.println(output.toString());
    }

    public boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}