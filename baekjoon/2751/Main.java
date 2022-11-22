import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 1. 내장 정렬 => 시간초과
 * 2. 힙 정렬 ==> 시간초과
 * 3. 메모리 사용해서 ==> 시간초과
 * 4. 병합 정렬 ==> 시간초과
 * 5. Collections.sort + 출력을 StringBuilder 형식으로.
 */
public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(numbers.get(i)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
