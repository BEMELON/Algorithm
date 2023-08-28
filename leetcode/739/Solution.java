import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[temps.length];
        Stack<Integer> descStack = new Stack<Integer>();


        for(int i = 0; i < temps.length; i++) {
            while (!descStack.isEmpty() && temps[i] > temps[descStack.peek()]) {
                int idx = descStack.pop();
                answer[idx] = i - idx;
            }

            descStack.push(i);
        }

        return answer;
    }
}