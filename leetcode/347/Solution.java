import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        // 1. 가장 많이 나온 순
        // 2. 나온 횟수가 같은 경우, 숫자가 큰 순서로
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b - a;
            }

            return map.get(b) - map.get(a);
        });

        for (int key : map.keySet()) {
            priorityQueue.add(key);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }
}