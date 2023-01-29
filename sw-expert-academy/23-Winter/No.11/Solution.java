import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int num;
    Node parent;
    int left;
    int right;
    int depth;
}

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void run() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            Node[] nodes = new Node[V + 1];

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if (nodes[parent] == null) {
                    nodes[parent] = new Node();
                }

                if (nodes[child] == null) {
                    nodes[child] = new Node();
                }

                if (nodes[parent].left == 0) {
                    nodes[parent].left = child;
                } else {
                    nodes[parent].right = child;
                }

                nodes[child].parent = nodes[parent];
                nodes[parent].num = parent;
                nodes[child].num = child;
            }

            initDepth(nodes, 1, 1);

            // Find LCA of v1 and v2
            Node n1 = nodes[v1];
            Node n2 = nodes[v2];

            if (n1.depth > n2.depth) {
                while (n1.depth != n2.depth) {
                    n1 = n1.parent;
                }
            } else if (n1.depth < n2.depth) {
                while (n1.depth != n2.depth) {
                    n2 = n2.parent;
                }
            }

            while (n1 != n2) {
                n1 = n1.parent;
                n2 = n2.parent;
            }

            int tree_size = getTreeSize(nodes, n1);
            sb.append("#").append(test_case).append(" ").append(n1.num).append(" ").append(tree_size).append('\n');
        }
        System.out.println(sb.toString());
    }

    private int getTreeSize(Node[] nodes, Node node) {
        if (node == null)
            return 0;

        int left = getTreeSize(nodes, nodes[node.left]);
        int right = getTreeSize(nodes, nodes[node.right]);
        return left + right + 1;
    }

    private void initDepth(Node[] nodes, int idx, int depth) {
        if (idx >= nodes.length || nodes[idx] == null) {
            return;
        }

        nodes[idx].depth = depth;
        initDepth(nodes, nodes[idx].left, depth + 1);
        initDepth(nodes, nodes[idx].right, depth + 1);
    }
}