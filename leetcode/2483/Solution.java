class Solution {
    public int bestClosingTime(String customers) {
        int count_Y = 0;
        int count_N = 0;
        for(Character ch: customers.toCharArray()) {
            if (ch == 'Y') count_Y++;
            else count_N++;
        }

        int min_idx = Integer.MAX_VALUE;
        int min_penalty = Integer.MAX_VALUE;
        int current_penalty = count_Y;

        for(int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);

            // Current State
            if (min_penalty > current_penalty) {
                min_penalty = current_penalty;
                min_idx = i;
            }


            // Next State
            if (ch == 'Y') current_penalty--;
            else current_penalty++;
        }

        if (min_penalty > count_N) {
            return customers.length();
        }

        return min_idx;
    }
}