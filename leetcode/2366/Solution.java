class Solution {
    public long minimumReplacement(int[] nums) {
        long replacements = 0;
        long prev = nums[nums.length - 1];
        for(int idx = nums.length - 2; idx >=0; idx--) {
            if (nums[idx] > prev) {
                long parts = nums[idx] / prev;
                if (nums[idx] % prev != 0)
                    parts++;

                replacements += parts - 1;
                prev = nums[idx] / parts;
            } else {
                prev = nums[idx];
            }
        }

        return replacements;
    }
}