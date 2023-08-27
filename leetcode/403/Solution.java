import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Integer, Integer> idx_stones = new HashMap<>();
    public int[][] dp;

    public boolean solve(int idx, int step, int[] stones) {
        // Reaches end-of-stones
        if (idx == stones.length - 1) {
            return true;
        }

        // Memorization : 1 for success, 0 for fail
        if (dp[idx][step] != -1) {
            return dp[idx][step] == 1;
        }

        boolean minus = false, zero = false, plus = false;
        int next_stone = stones[idx] + step;
        if (idx_stones.containsKey(next_stone)) {
            zero = solve(idx_stones.get(next_stone), step, stones);
        }

        if (idx_stones.containsKey(next_stone + 1)) {
            plus = solve(idx_stones.get(next_stone + 1), step + 1, stones);
        }

        if (step > 1 && idx_stones.containsKey(next_stone - 1)) {
            minus = solve(idx_stones.get(next_stone - 1), step - 1, stones);
        }

        dp[idx][step] = (minus || zero || plus) ? 1 : 0;
        return dp[idx][step] == 1;
    }

    public boolean canCross(int[] stones) {
        // stones[0] ~ stones[1] distance are not 1 
        if (stones[1] - stones[0] != 1)
            return false;

        // Init DP 
        dp = new int[stones.length][stones.length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // Init reverse stone_idx 
        for(int i = 0; i < stones.length; i++) {
            idx_stones.put(stones[i], i);
        }

        return solve(1, 1, stones);
    }

}

