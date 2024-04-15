// Follow-up : Leetcode 792
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var idx = 0;

        for (i in s) {
            idx = t.indexOf(i, idx);
            if (idx == -1) {
                return false;
            }
            idx++;
        }

        return true;
    }
}