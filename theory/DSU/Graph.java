import java.util.ArrayList;
import java.util.List;

public class Graph {
    public final List<Integer> parents;

    public Graph(int n) {
        this.parents = new ArrayList<>();

        for(int i = 0; i < n; i++)
            this.parents.add(-1);

    }

    public int find(int v) {
        int parent = this.parents.get(v);
        if (parent == -1) { // 자기가 최상위 노드인 경우
            return v;
        }

        // 부모 노드에서 다시 Find
        return this.find(parent);
    }

    public void union(int v1, int v2) {
        int p1 = this.find(v1);
        int p2 = this.find(v2);

        if (p1 == p2) { // 이미 같은 그룹
            return ;
        }

        // P2의 최상위 부모를 P1으로 설정
        this.parents.set(p2, p1);
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

        System.out.println("==> Union(0, 3)");
        g.union(0, 3);

        System.out.println("==> 노드의 그룹");
        for(int i = 0; i < 5; i++) {
            System.out.print(g.getParent(i) + " ");
        }
        System.out.println();
    }
}
