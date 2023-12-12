import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Pos other = (Pos) obj;

        return other.x == x && other.y == y;
    }
}
public class Main {
    static StringTokenizer stk;
    static int n, m;
    static int[][] graph, nextGraph;
    static List<Pos> chickens;
    static  List<ArrayList<Integer>> permutations;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new int[n][n];
        chickens = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n ; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
                if (graph[i][j] == 2) {
                    chickens.add(new Pos(i, j));
                }
            }
        }

        permutations = new ArrayList<>();
        getPermutation(0, new ArrayList<>());
//        System.out.println(permutations);


        int answer = Integer.MAX_VALUE;
        for(ArrayList<Integer> permutation: permutations) {
            initGraph(permutation);

            answer = Math.min(answer, getChickenDist(permutation));
        }

        System.out.println(answer);
    }

    private static int getChickenDist(List<Integer> p) {
        int distSum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (nextGraph[i][j] != 1) continue;

                int minDist = Integer.MAX_VALUE / 16;

                for(Integer chickIdx: p) {
                    minDist = Math.min(minDist, getDistance(chickens.get(chickIdx), i, j));
                }

                distSum += minDist;
            }
        }

        return distSum;
    }

    private static int getDistance(Pos pos, int x, int y) {
        return Math.abs(pos.x - x) + Math.abs(pos.y - y);
    }

    private static void initGraph(ArrayList<Integer> permutation) {
        nextGraph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (graph[i][j] != 2)
                    nextGraph[i][j] = graph[i][j];
            }
        }

        for(int i: permutation) {
            Pos p = chickens.get(i);
            nextGraph[p.x][p.y] = 2;
        }
    }

    private static void getPermutation(int idx, ArrayList<Integer> p) {
        if (p.size() == m) {
            permutations.add((ArrayList<Integer>) p.clone());
            return ;
        }

        for(int i = idx; i < chickens.size(); i++) {
            p.add(i);
            getPermutation(i + 1, p);
            p.remove(p.size() - 1);
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
