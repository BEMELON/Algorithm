import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    class Person {
        public int weight;
        public int height;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        boolean isHeavyThen(Person p) {
            return (weight > p.weight && height > p.height);
        }
    }
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(tk.nextToken());
            int h = Integer.parseInt(tk.nextToken());
            list.add(new Person(w, h));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int rank = 1;
            Person p = list.get(i);
            for(int j = 0; j < N; j++) {
                if (i == j) continue;

                if (list.get(j).isHeavyThen(p))
                    rank++;
            }

            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();   
    }
}