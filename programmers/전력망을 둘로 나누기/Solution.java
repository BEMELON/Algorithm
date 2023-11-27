import java.util.*;

class Solution {
    // 1. 완전탐색 > 전선의 개수 * 노드의 개수 = 99 * 100 ? 
    int[][] grid;
    int n;
    public int solution(int n, int[][] wires) {
        init(n, wires);

        int minDiff = Integer.MAX_VALUE;
        for(int[] wire: wires) {
            int groupCnt = 0;
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(visited, false);
            int nodeCnt = 0;
            for(int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                int node = getNode(i, visited, wire);
                nodeCnt = Math.abs(nodeCnt - node);
                groupCnt++;

            }

            if (groupCnt == 2)
                minDiff = Math.min(minDiff, nodeCnt);

        }

        return minDiff;
    }



    private void init(int n, int[][] wires) {
        n = n;
        grid = new int[n + 1][n + 1];
        for(int[] wire: wires) {
            grid[wire[0]][wire[1]] = 1;
            grid[wire[1]][wire[0]] = 1;

        }
    }

    private int getNode(int node, boolean[] visited, int[] forbiddenWire) {
        visited[node] = true;

        int[] nextEdges = grid[node];

        int count = 1;
        for(int i = 0; i < nextEdges.length; i++) {
            int edge = nextEdges[i];
            if (visited[i] || edge == 0 || equals(new int[]{node, i}, forbiddenWire) || equals(new int[]{i, node}, forbiddenWire)) continue;

            visited[i] = true;
            count += getNode(i, visited, forbiddenWire);
        }

        return count;
    }

    private boolean equals(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }
}