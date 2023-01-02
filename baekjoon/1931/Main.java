import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solve();
    }

    class Appointment {
        int start;
        int end;

        public Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private void solve() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Appointment[] appointments = new Appointment[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            appointments[i] = new Appointment(start, end);
        }

        Arrays.sort(appointments, new Comparator<Appointment>() {
            @Override
            public int compare(Appointment o1, Appointment o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int count = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if (endTime <= appointments[i].start) {
                count++;
                endTime = appointments[i].end;
            }
        }

        System.out.println(count);
    }
}