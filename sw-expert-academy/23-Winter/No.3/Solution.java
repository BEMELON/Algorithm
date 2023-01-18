import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static int[][] res;
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        /******************************
         * 비트마스크를 이용해 방장과 전날에 있던
         * 사람들을 파악하고 이전 방의 사람들이 
         * 키를 가질 수 있는 모든 경우를 탐색하여
         * 경우의 수를 구한다.
         * 
         * A  -> A ->
         *          AB->    
         * 
         * AB -> A ->
         *       ~~
         *    -> B ->
         *       ~~
         *    -> AB ->
         *       ~~
         *******************************/
        for(int t = 1; t <= T; t++) {
            String masters = sc.next();
            res = new int[masters.length()][16];
            ans = 0;
            sol(masters);
            System.out.println("#"+t+" "+ans);
        }
        
    }
    public static void sol(String masters) {
        for(int k = 0; k < masters.length(); k++) {
            
            int master = 1 << (masters.charAt(k) - 'A');
            
            for(int i = 1; i < 16; i ++) {
                if(k == 0) {// 첫날
                    if((i&master)!=0 && (i&1)!=0) {
                        res[k][i] = 1;
                    }
                }else {
                    if(res[k-1][i] != 0) {// 두번째 날부터
                        for(int j = 1; j < 16;j++) {
                            if((i&j)!=0 && (j&master)!=0) {
                                res[k][j] =(res[k][j] + res[k-1][i]) % 1000000007;
                                // 모든경우의 수를 앞쪽으로 누적
                            }
                        }
                    }
                }
                
            }
            
        }
        
       for(int i = 1; i < 16; ++i) {
            ans =(ans+res[masters.length()-1][i]) % 1000000007;
        }
        
    }
}