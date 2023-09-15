import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] dist = new int[points.length];
        Set<Integer> visited = new HashSet<Integer>();
        int answer = 0;

        // 0. Connect All Edges to Vertex (0)
        visited.add(0);
        for(int i = 1; i < dist.length; i++) {
            dist[i] = getDistance(points[i], points[0]);
        }

        // 1. Loop until All vertex has been visited 
        while (visited.size() != dist.length) {
            // 2. Find shortest Edge 
            int min_idx = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < dist.length; i++) {
                if (visited.contains(i)) continue;

                if (min > dist[i]) {
                    min = dist[i];
                    min_idx = i;
                }
            }

            // 3. Connect to shortest Edge 
            visited.add(min_idx);
            answer += min;

            // 4. Update distance from {min_idx} Vertex
            for(int i = 0; i < dist.length; i++) {
                if (visited.contains(i)) continue;

                dist[i] = Math.min(dist[i], getDistance(points[i], points[min_idx]));
            }
        }

        return answer;
    }

    public int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}