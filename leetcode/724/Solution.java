class Solution {
    public int pivotIndex(int[] nums) {
        int right_sum = 0;
        for(int i = 0; i < nums.length; i++) {
            right_sum += nums[i];
        }

        int left_sum = 0;
        int pivot = 0;
        while (pivot < nums.length) {
            right_sum -= nums[pivot];
            if (left_sum == right_sum) {
                return pivot;
            }

            left_sum += nums[pivot];
            pivot++;
        }

        return -1;
    }
}