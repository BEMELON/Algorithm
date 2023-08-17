public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1Idx = 0;
        int w2Idx = 0;
        StringBuilder sb = new StringBuilder();

        int total_len = word1.length() + word2.length();
        for(int i = 0; i < total_len; i++) {
            if (i % 2 == 0) {
                if (w1Idx >= word1.length()) {
                    sb.append(word2.charAt(w2Idx++));
                } else {
                    sb.append(word1.charAt(w1Idx++));
                }
            } else {
                if (w2Idx >= word2.length()) {
                    sb.append(word1.charAt(w1Idx++));
                } else {
                    sb.append(word2.charAt(w2Idx++));
                }
            }
        }
        return sb.toString();
    }
}
