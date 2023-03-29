import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int num, weight;

    public Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}


public class Main {
    public int max = 0;
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 양방향 인접리스트 
        List<Node> list[] = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            int weight = Integer.parseInt(tk.nextToken()); 

            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }

        // 모든 노드에 대해서 DFS 후 가장 큰 값 
        for(int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, list, 0, visited);
        }
        
        System.out.println(max);
    }

    private void dfs(int start, List<Node>[] list, int sum, boolean[] visited) {
        for(Node node: list[start]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, list, sum + node.weight, visited);
            }
        }

        max = Math.max(max, sum);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }
}