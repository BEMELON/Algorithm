class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] map = new boolean[n][n];

        // 1. Init map
        for(int[] road: roads) {
            map[road[0]][road[1]] = true;
            map[road[1]][road[0]] = true;
        }


        // 2. All Case
        int result = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = 0;
                for(int k = 0; k < n; k++) {
                    if (map[k][i])
                        temp++;
                    if (map[k][j])
                        temp++;
                }

                if (map[i][j] && map[j][i])
                    temp--;

                result = Math.max(result, temp);
            }
        }

        return result;
    }
}