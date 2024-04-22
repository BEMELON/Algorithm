class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, ArrayList<Int>>()

        for(i in nums.indices) {
            val num = nums[i]

            if (!map.containsKey(num)) {
                map[num] = arrayListOf(i)
            } else {
                val list = map[num]!!

                for (idx in list) {
                    if (i - idx <= k) return true
                }

                map[num]?.add(i)
            }
        }

        return false
    }
}