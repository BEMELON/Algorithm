import java.util.*;

class Edge {
    public int src;
    public int dest;
    public int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class UnionFind {
    private final List<Integer> rank;
    private final List<Integer> parent;

    public UnionFind(int n) {
        this.rank = new ArrayList<>();
        this.parent = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            this.rank.add(1);
            this.parent.add(-1);
        }
    }

    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2)
            return ;

        int r1 = rank.get(p1);
        int r2 = rank.get(p2);

        if (r1 > r2) {
            parent.set(p2, p1);
            rank.set(v1, r1 + r2);
        } else {
            parent.set(p1, p2);
            rank.set(v2, r1 + r2);
        }
    }

    public int find(int v) {
        int p = this.parent.get(v);
        if (p == -1) {
            return v;
        }

        p = find(p);
        parent.set(v, p);
        return p;
    }
}

public class Kruskal {
    private final List<Edge> graph;
    private final UnionFind uf;

    public Kruskal(int n) {
        graph = new ArrayList<>();
        uf = new UnionFind(n);
    }

    public void addEdge(int src, int dest, int weight) {
        graph.add(new Edge(src, dest, weight));
    }

    public int MST() {
        graph.sort(Comparator.comparingInt(e -> e.weight));

        int total_weight = 0;
        for(Edge e: graph) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                total_weight += e.weight;
                uf.union(e.src, e.dest);
            }
        }

        return total_weight;
    }

    public static void main(String[] args) {
        Kruskal k = new Kruskal(4);

        k.addEdge(0, 1, 1);
        k.addEdge(0, 2, 2);
        k.addEdge(0, 3, 2);
        k.addEdge(1, 2, 2);
        k.addEdge(1, 3, 3);
        k.addEdge(2, 3, 3);

        System.out.println("MST : " + k.MST());
    }
}
