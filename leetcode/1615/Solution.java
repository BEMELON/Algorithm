import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> roadMap = new HashMap<>();

        // 1. Init roadSet
        for(int i = 0; i < n; i++) {
            roadMap.put(i, new HashSet<>());
        }

        // 2. Push road
        for(int[] road: roads) {
            Set<Integer> set = roadMap.get(road[0]);
            set.add(road[1]);
            roadMap.put(road[0], set);

            set = roadMap.get(road[1]);
            set.add(road[0]);
            roadMap.put(road[1], set);
        }


        // 3. All Case
        int result = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                Set<Integer> a = roadMap.get(i);
                Set<Integer> b = roadMap.get(j);
                if (a.contains(j) && b.contains(i)) {
                    result = Math.max(result, a.size() + b.size() - 1);
                } else {
                    result = Math.max(result, a.size() + b.size());
                }
            }
        }

        return result;
    }
}