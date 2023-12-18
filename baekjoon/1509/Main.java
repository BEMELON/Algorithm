import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    static int result;
    static String word;
    static boolean[][] palindrome;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        result = word.length();

        // dp[i][j] = i ~ j 번째의 문자열이 Palindrome 한지
        palindrome = new boolean[word.length()][word.length()];

        // CASE 1
        for(int i = 0; i < word.length(); i++) {
            palindrome[i][i] =  true;
        }

        // CASE 2
        for(int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
            }
        }

        // CASE 3
        for(int len = 3; len <= word.length(); len++) {
            for(int start = 0; start + len - 1  < word.length(); start++) {
                int end = start + len - 1;

                if (word.charAt(start) == word.charAt(end) && palindrome[start + 1][end - 1]) palindrome[start][end] = true;
            }
        }


        dp = new int[word.length() + 1];

        for(int end = 1; end <= word.length(); end++) {
            dp[end] = Integer.MAX_VALUE;
            for(int start = 1; start <= end; start++) {
                if (palindrome[start - 1][end - 1]) {
                    dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                }
            }
        }
        
        System.out.println(dp[word.length()]);
    }

}