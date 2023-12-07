import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int num;
    Node left, right;

    public Node(int num) {
        this.num = num;
    }

    public Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static StringTokenizer stk;
    static Node tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));

        while (br.ready()) {
            int x = Integer.parseInt(br.readLine());

            if (tree == null)
                tree = new Node(x);
            else {
                insertNode(tree, x);
            }
        }

        postOrder(tree);
    }

    private static void insertNode(Node tree, int x) {
        if (tree.num > x) {
            if (tree.left == null) tree.left = new Node(x);
            else insertNode(tree.left, x);
        } else {
            if (tree.right == null) tree.right = new Node(x);
            else insertNode(tree.right, x);
        }
    }

    private static void postOrder(Node tree) {

        if (tree.left != null)
            postOrder(tree.left);

        if (tree.right != null)
            postOrder(tree.right);

        System.out.println(tree.num);
    }
}
