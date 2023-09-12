class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int c = 0;

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i <= cost.length; i++) {
            if (i == cost.length) c = 0;
            else c = cost[i];

            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + c;
        }

        return dp[cost.length];
    }
}