class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] roadCnt = new int[n];

        // 2. Push road
        for(int[] road: roads) {
            roadCnt[road[0]] += 1;
            roadCnt[road[1]] += 1;

            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }


        // 3. All Case
        int result = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                result = Math.max(result, roadCnt[i] + roadCnt[j] - (connected[i][j] ? 1 : 0));
            }
        }

        return result;
    }
}