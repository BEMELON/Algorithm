class Solution {
    public int solution(int[][] triangle) {
        if (triangle.length == 1) return triangle[0][0];

        int[][] dp = new int[triangle.length][];
        // Init DP 
        for(int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
            for(int j = 0 ; j < triangle[i].length; j++) {
                dp[i][j] = triangle[i][j];
            }
        }
        dp[0][0] = triangle[0][0];


        int[] dx = {-1, -1}, dy = {-1, 0};
        for(int row = 1; row < triangle.length; row++) {
            for(int col = 0; col < triangle[row].length; col++) {
                for(int d = 0; d < 2; d++) {
                    int px = row + dx[d], py = col + dy[d];

                    if (py < 0 || py >= triangle[row - 1].length) continue;

                    dp[row][col] = Math.max(dp[row][col], dp[px][py] + triangle[row][col]);
                }
            }
        }

        int answer = 0;
        for(int col = 0; col < triangle[triangle.length - 1].length; col++) {
            answer = Math.max(answer, dp[triangle.length - 1][col]);
        }

        return answer;

    }
}