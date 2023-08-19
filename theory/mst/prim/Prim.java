import java.util.*;

class Node {
    public int v;
    public int weight;

    public Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

public class Prim {
    private final List<List<Node>> graph = new ArrayList<>();

    public Prim(int n) {
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        List<Node> srcGraph = this.graph.get(src);
        List<Node> destGraph = this.graph.get(dest);

        srcGraph.add(new Node(dest, weight));
        destGraph.add(new Node(src, weight));

        graph.set(src, srcGraph);
        graph.set(dest, destGraph);
    }

    public int MST() {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        boolean[] visited = new boolean[this.graph.size()];
        visited[0] = true;

        int total_weight = 0;
        queue.addAll(graph.get(0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.v])
                continue;


            total_weight += node.weight;
            visited[node.v] = true;

            for(Node n: graph.get(node.v)) {
                if (!visited[n.v])
                    queue.add(n);
            }
        }

        return total_weight;
    }

    public static void main(String[] args) {
        Prim p = new Prim(4);

        p.addEdge(0, 1, 1);
        p.addEdge(0, 2, 2);
        p.addEdge(0, 3, 2);
        p.addEdge(1, 2, 2);
        p.addEdge(1, 3, 3);
        p.addEdge(2, 3, 3);

        System.out.println("MST : " + p.MST());
    }
}
