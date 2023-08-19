import java.util.ArrayList;
import java.util.List;

public class Graph {
    public final List<Integer> parents;
    public final List<Integer> rank;

    public Graph(int n) {
        this.parents = new ArrayList<>();
        this.rank = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            this.parents.add(-1);
            this.rank.add(1);
        }
    }

    public int find(int v) {
        int parent = this.parents.get(v);
        if (parent == -1) { // 자기가 최상위 노드인 경우
            return v;
        }

        // 루트를 찾아서 할당
        int root = this.find(parent);
        this.rank.set(v, root);

        return root;
    }

    public void union(int v1, int v2) {
        int p1 = this.find(v1);
        int p2 = this.find(v2);

        if (p1 == p2) { // 이미 같은 그룹
            return ;
        }

        int r1 = this.rank.get(p1);
        int r2 = this.rank.get(p2);

        // P2가 더 큰 그룹인 경우
        if (r1 < r2) {
            this.parents.set(p1, p2); // P1의 부모를 P2로
            this.rank.set(p2, r1 + r2);
        } else {
            this.parents.set(p2, p1);
            this.rank.set(p1, r1 + r2);
        }
    }

    public int getParent(int v) {
        return this.find(v);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);


        System.out.println("==> 노드의 그룹");
        for(int i = 0; i < 5; i++) {
            System.out.print(g.getParent(i) + " ");
        }
        System.out.println();

        System.out.println("==> Union(0, 1)");
        g.union(0, 1);

        System.out.println("==> 노드의 그룹");
        for(int i = 0; i < 5; i++) {
            System.out.print(g.getParent(i) + " ");
        }
        System.out.println();

        System.out.println("==> Union(3, 4)");
        g.union(3, 4);

        System.out.println("==> 노드의 그룹");
        for(int i = 0; i < 5; i++) {
            System.out.print(g.getParent(i) + " ");
        }
        System.out.println();

        System.out.println("==> Union(2, 3)");
        g.union(2, 3);

        System.out.println("==> 노드의 그룹");
        for(int i = 0; i < 5; i++) {
            System.out.print(g.getParent(i) + " ");
        }
        System.out.println();

        System.out.println("==> Union(0, 3)");
        g.union(0, 3);

        System.out.println("==> 노드의 그룹");
        for(int i = 0; i < 5; i++) {
            System.out.print(g.getParent(i) + " ");
        }
        System.out.println();
    }
}
