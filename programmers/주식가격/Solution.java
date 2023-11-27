import java.util.Arrays;

class Solution {
    // N^2 돌아가나? 
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];


            for(int j = i; j < prices.length; j++) {
                if (prices[j] >= price) {
                    result[i] += 1;
                } else {
                    break;
                }
            }
            result[i] = Math.min(prices.length - (i + 1), result[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[] {1, 2, 3, 2, 3})));
    }
}