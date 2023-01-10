import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int cnt = 0;
        int answer = 0;
        for(int i = 1;  i < M - 1; i++) {
            if (str.charAt(i - 1) == 'I' && str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                i++;
                cnt++;

                if (cnt == N) {
                    answer++;
                    cnt--;
                }
            } else {
                cnt = 0;
            }
        }
        System.out.println(answer);

    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}