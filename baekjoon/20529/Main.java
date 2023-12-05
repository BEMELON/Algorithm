import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] listOfMBTI = br.readLine().split(" ");

            if (n > 32) {
                System.out.println(0);
                continue;
            }

            int minDistance = Integer.MAX_VALUE;
            int[][] diff = new int[listOfMBTI.length][listOfMBTI.length];

            for(int i = 0; i < listOfMBTI.length; i++) {
                for(int j = i + 1; j < listOfMBTI.length; j++) {
                    int distance = calculate(listOfMBTI[i], listOfMBTI[j]);

                    diff[i][j] = distance;
                    diff[j][i] = distance;
                }
            }

            for(int i = 0; i < listOfMBTI.length; i++) {
                for(int j = i + 1; j < listOfMBTI.length; j++) {
                    for(int k = j + 1; k < listOfMBTI.length; k++) {
                        minDistance = Math.min(minDistance, diff[i][j] + diff[i][k] + diff[j][k]);
                    }
                }
            }

            System.out.println(minDistance);
        }
    }



    private static int calculate(String a, String b) {
        int diff = 0;

        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff += 1;
        }

        return diff;
    }

}
