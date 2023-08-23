import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeStars(String s) {
        Deque<Character> q = new ArrayDeque<>();

        for(char ch: s.toCharArray()) {
            if (ch == '*')
                q.removeLast();
            else
                q.addLast(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: q) {
            sb.append(ch);
        }

        return sb.toString();
    }
}