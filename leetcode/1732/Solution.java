class Solution {
    public int largestAltitude(int[] gain) {
        int current_height = 0;
        int max_height = 0;
        for(int g: gain) {
            current_height += g;
            max_height = Math.max(max_height, current_height);
        }

        return max_height;
    }
}