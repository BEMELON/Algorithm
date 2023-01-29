import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    Double data;
    int left;
    int right;

    public Node(int data) {
        this.data = (double) data;
    }
}

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().start();
    }

    private void start() throws NumberFormatException, IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            Node[] tree = new Node[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int V = Integer.parseInt(st.nextToken());
                String op = st.nextToken();
                if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                    tree[V] = new Node(op.charAt(0));
                    tree[V].left = Integer.parseInt(st.nextToken());
                    tree[V].right = Integer.parseInt(st.nextToken());
                } else {
                    tree[V] = new Node(Integer.parseInt(op));
                }
            }
            sb.append("#").append(test_case).append(" ").append(postOrder(tree, 1).intValue()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private Double postOrder(Node[] tree, int idx) {
        if (tree[idx] == null) {
            return 0.0;
        }

        if (tree[idx].left == 0 && tree[idx].right == 0) {
            return tree[idx].data;
        }

        Double left = postOrder(tree, tree[idx].left);
        Double right = postOrder(tree, tree[idx].right);
        Double result = 0.0;
        switch (tree[idx].data.intValue()) {
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            case '*':
                result = left * right;
                break;
            case '/':
                result = left / right;
                break;
            default:
                result = tree[idx].data;
                break;
        }
        return result;
    }
}