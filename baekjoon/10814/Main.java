import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    class Person {
        public int age;
        public int order;
        public String name;

        Person(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Person> members = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] inputs = bf.readLine().split(" ");
            members.add(new Person(Integer.parseInt(inputs[0]), inputs[1], i));
        }

        members.sort((m1, m2) -> {
            if (m1.age != m2.age)
                return m1.age - m2.age;
            return m1.order - m2.order;
        });

        for(int i = 0; i < N; i++) {
            System.out.println(members.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
