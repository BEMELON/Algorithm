import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // 흠, 최댓값 * 최솟값을 게속 곱해주는 Greedy? 
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int x: A)
            minHeap.add(x);

        for(int x: B)
            maxHeap.add(x);

        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += minHeap.poll() * maxHeap.poll();
        }

        return sum;
    }
}