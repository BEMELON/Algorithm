import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // find minus in input
        String newString = "";
        boolean isMinus = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                isMinus = true;
            }

            if (input.charAt(i) == '+' && isMinus) {
                newString += '-';
            } else {
                newString += input.charAt(i);
            }
        }

        // calculate newString
        int result = 0;
        int offset = 0;
        int sign = 1;
        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) == '+' || newString.charAt(i) == '-') {
                result += Integer.parseInt(newString.substring(offset, i)) * sign;

                if (newString.charAt(i) == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }

                // System.out.printf("result: %d, sign: %d, value: %d\n", result, sign,
                // Integer.parseInt(newString.substring(offset, i)));
                offset = i + 1;
            }
        }
        result += Integer.parseInt(newString.substring(offset, newString.length())) * sign;
        System.out.println(result);
    }
}