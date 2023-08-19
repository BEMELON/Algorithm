import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class UnionFind {
    private List<Integer> parent = new ArrayList<>();
    private List<Integer> rank = new ArrayList<>();

    public UnionFind(int n) {
        for(int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(1);
        }
    }

    public int find(int n) {
        int p = parent.get(n);
        if (p == n) {
            return n;
        }

        int root = find(p);
        parent.set(n, root);

        return root;
    }

    public void union(int v1, int v2) {
        int p1 = parent.get(v1);
        int p2 = parent.get(v2);

        if (find(p1) == find(p2)) {
            return ;
        }

        int r1 = rank.get(p1);
        int r2 = rank.get(p2);
        if (r1 > r2) {
            rank.set(v1, r1 + r2);
            parent.set(p2, p1);
        } else {
            rank.set(v2, r1 + r2);
            parent.set(p1, p2);
        }
    }
}

class Solution {

    public int Kruskal(int n, int[][] edges, int block_edge_idx, int union_edge_idx) {
        UnionFind uf = new UnionFind(n);
        int total_weight = 0;

        if (union_edge_idx != -1) {
            uf.union(edges[union_edge_idx][0], edges[union_edge_idx][1]);
            total_weight += edges[union_edge_idx][2];
        }

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            if (i == block_edge_idx)
                continue;

            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
                total_weight += edge[2];
            }
        }

        // 간선을 조작하면서 끊어진 정점이 있는지 확인
        for(int i = 1; i < n; i++) {
            if (uf.find(0) != uf.find(i))
                return Integer.MAX_VALUE;
        }

        return total_weight;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // 정답을 위한 데이터 추가
        for(int i = 0; i < edges.length; i++) {
            edges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }

        // 간선 가중치 별 정렬
        Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]);

        // 기준 MST
        int mst = Kruskal(n, edges, -1, -1);
        List<Integer> critical = new LinkedList<>();
        List<Integer> pseudoCritical = new LinkedList<>();

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            // i번째 간선을 제외하고 MST를 계산했을 떄 값이 증가하는 경우 => 필수 간선
            if (mst < Kruskal(n, edges, i, -1)) {
                critical.add(edge[3]);
            } else if (mst == Kruskal(n, edges, -1, i)) {
                // i번째 간선을 강제로 포함하고 계산했을 때 값이 동일한 경우 => 대체 가능한 간선
                pseudoCritical.add(edge[3]);
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        result.add(critical);
        result.add(pseudoCritical);

        return result;
    }
}
