// 13:33 분 시작 ~ 13:58
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] nums;
    static int n;
    // 덧셈 / 뺄셈 / 곱셈/ 나눗셈
    static int[] counts; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ex3.txt")));   

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer stk  = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        counts = new int[4]; 
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            counts[i] = Integer.parseInt(stk.nextToken());
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 

        // 연산자간 순열을 계산하는 식으로...  
        List<int[]> permutations = getPermutations(counts[0], counts[1], counts[2], counts[3]);
        for(int[] permutation: permutations) {
            // printExpr(permutation);
            int result = nums[0]; 
            
            for(int i = 0; i < permutation.length; i++) {
                result = cal(result, nums[i + 1], permutation[i]);
            }
            max = Math.max(max,  result);
            min = Math.min(min, result);
        }

        System.out.println(max);
        System.out.println(min);
    }

    private static int cal(int result, int next, int op) {
        if (op == 0) {
            return result + next;
        } else if (op == 1) {
            return result - next;
        } else if (op == 2) {
            return result * next;
        } else {
            if (next < 0) {
                return -(result / Math.abs(next));
            } else {
                return result / next;
            }
            
        }
    }

    private static List<int[]> getPermutations(int plus, int minus, int mult, int div) {
        List<int[]> list = new ArrayList<>();

        recur(plus, minus, mult, div, new int[n - 1], 0, list);
        return list; 
    }

    private static void recur(int plus, int minus, int mult, int div, int[] is, int i, List<int[]> list) {
        if (i > n - 2) {
            list.add(is.clone()); return ; 
        }

        if (plus > 0) {
            is[i] = 0; 
            recur(plus - 1, minus, mult, div, is, i + 1, list);
        }

        if (minus > 0) {
            is[i] = 1; 
            recur(plus, minus - 1, mult, div, is, i + 1, list);
        }

        if (mult > 0) {
            is[i] = 2; 
            recur(plus, minus, mult - 1, div, is, i + 1, list);
        }

        if (div > 0) {
            is[i] = 3; 
            recur(plus, minus, mult, div - 1, is, i + 1, list);
        }
    }

    private static void printExpr(int[] op) {
        StringBuilder sb = new StringBuilder();

        sb.append(nums[0]).append(" ");
        for(int i = 0; i < op.length; i++) {
            String oper = "";
            if (op[i] == 0) oper = "+";
            else if (op[i] == 1) oper = "-";
            else if (op[i] == 2) oper = "*";
            else if (op[i] == 3) oper = "/";
            sb.append(oper).append(" ").append(nums[i + 1]).append(" ");
        }
        System.out.println(sb.toString());
    }
}