import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();
            int[] arr = new int[N];
            arr = strToIntArr(arrStr, N);

            boolean hasError = false;
            boolean reverse = false;
            int start = 0;
            int end = arr.length;
            for (int j = 0; j < p.length() && !hasError; j++) {
                if (j < p.length() - 1 && p.charAt(j) == 'P' && p.charAt(j + 1) == 'P') {
                    continue;
                }
                switch (p.charAt(j)) {
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':
                        if (start >= end) {
                            sb.append("error\n");
                            hasError = true;
                            break;
                        }

                        if (reverse) {
                            end--;
                        } else {
                            start++;
                        }
                        break;
                }
            }

            if (!hasError) {
                sb.append("[")
                        .append(arrToStr(arr, start, end, reverse))
                        .append("]")
                        .append("\n");
            }

        }
        System.out.println(sb.toString());
    }

    // substring arr from start to end
    // if reverse true reverse arr
    private String arrToStr(int[] arr, int start, int end, boolean reverse) {
        StringBuilder sb = new StringBuilder();
        if (reverse) {
            for (int i = end - 1; i >= start; i--) {
                sb.append(arr[i]).append(",");
            }
        } else {
            for (int i = start; i < end; i++) {
                sb.append(arr[i]).append(",");
            }
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    private int[] strToIntArr(String arrStr, int n) {
        int[] arr = new int[n];
        String[] strArr = arrStr.substring(1, arrStr.length() - 1).split(",");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        return arr;
    }
}