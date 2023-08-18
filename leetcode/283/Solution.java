class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for(int num: nums) {
            if (num != 0) {
                nums[p++] = num;
            }
        }

        while (p < nums.length)
            nums[p++] = 0;
    }
}