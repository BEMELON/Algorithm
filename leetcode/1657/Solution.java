import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        for(int i = 0; i < word1.length(); i++) {
            String s = Character.toString(word1.charAt(i));
            String s2 = Character.toString(word2.charAt(i));
            m1.put(s, m1.getOrDefault(s, 0) + 1);
            m2.put(s2, m2.getOrDefault(s2, 0) + 1);
        }


        // Operation 1) Check All alphabets are exists  
        for(String s: m1.keySet()) {
            if (m2.get(s) == null) {
                return false;
            }
        }

        // Operation 2) Check alphabets 
        Set<String> verified = new HashSet<>();
        for(String s: m1.keySet()) {
            int occur = m1.get(s);

            boolean flag = true;
            for(String w: m2.keySet()) {
                if (!verified.contains(w) && m2.get(w) == occur) {
                    verified.add(w);
                    flag = false;
                    break;
                }
            }

            if (flag)
                return false;
        }

        return true;
    }
}