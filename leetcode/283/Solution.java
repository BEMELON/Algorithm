class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = p1 + 1;

        while (p2 < nums.length) {
            if (nums[p1] != 0) {
                p1++;
            } else if (nums[p1] == 0 && nums[p2] != 0) {
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;

                p1++;
            }

            p2++;
        }
    }
}