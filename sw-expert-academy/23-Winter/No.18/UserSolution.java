public class UserSolution {
    private int[][] relation;
    private int[] relationCount;

	public void dfs_init(int N, int[][] path) {
        relation = new int[101][101];
        relationCount = new int[101];

        for(int i = 0; i < path.length; i++) {
            relation[path[i][0]][relationCount[path[i][0]]++] = path[i][1];
        }

	}
	
	public int dfs(int N) {
        for(int i = 0; i < relationCount[N]; i++) {
            int child = relation[N][i];
            int result = run_dfs(N, child); 

            if (result > N) {
                return result;
            }
        }

        return -1;
	}

    private int run_dfs(int n, int child) {
        if (child > n) {
            return child;
        }

        for(int i = 0; i < relationCount[child]; i++) {
            int grandChild = relation[child][i];
            int result = run_dfs(n, grandChild);

            if (result > n) {
                return result;
            }
        }

        return -1;
    }
}