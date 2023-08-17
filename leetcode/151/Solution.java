class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        String[] words = s.split(" ");

        for(int i = words.length - 1; i >= 0; i--) {
            String word = words[i];

            if (!word.isEmpty()) {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }
}