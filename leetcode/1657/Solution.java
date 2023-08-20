class Solution {

    public int[] getFrequency(String w) {
        int[] alphabets = new int[26];

        for(char ch: w.toCharArray()) {
            alphabets[ch - 'a'] += 1;
        }

        return alphabets;
    }
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] f1 = getFrequency(word1);
        int[] f2 = getFrequency(word2);

        for(int i = 0; i < 26; i++) {
            if (f1[i] * f2[i] == 0 && // 알파벳이 하나의 단어에만 있는 경우
                    f1[i] + f2[i] != 0) {
                return false;
            }
        }

        // 빈도 순으로 정렬
        Arrays.sort(f1);
        Arrays.sort(f2);

        // 빈도가 서로 같은지 체크
        return Arrays.equals(f1, f2);
    }
}