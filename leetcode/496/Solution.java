class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            boolean found_i = false;
            boolean found_bigger = false;
            for(int j = 0; j < nums2.length; j++) {
                if (!found_i) {
                    if (nums1[i] == nums2[j])
                        found_i = true;
                } else {
                    if (nums2[j] > nums1[i]) {
                        answer[i] = nums2[j];
                        found_bigger = true;
                        break;
                    }
                }
            }

            if (!found_bigger)
                answer[i] = -1;
        }

        return answer;
    }
}
