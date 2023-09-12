import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        int[] count = new int['z' - 'a' + 1];

        for(Character ch: s.toCharArray())  {
            count[ch - 'a'] += 1;
        }

        Set<Integer> countSet = new HashSet<>();
        int result = 0;

        for(int c: count) {
            int movement = 0;
            while (c > 0 && countSet.contains(c)) {
                movement++; c--;
            }

            result += movement;
            countSet.add(c);
        }

        return result;
    }
}