public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int total_len = word1.length() + word2.length();
        StringBuilder result = new StringBuilder();

        while (i < total_len) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }

            i++;
        }

        return result.toString();
    }
}
