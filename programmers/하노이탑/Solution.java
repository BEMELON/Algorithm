import java.util.*;

class Solution {
    List<int[]> record;

    public int getNext(int x, int y) {
        int[] pool = new int[4];
        pool[x] = 1;
        pool[y] = 1;
        for (int i = 1; i < 4; i++)
            if (pool[i] == 0) return i;
        return -1;
    }

    public void solve(int from, int to, int n) {
        if (n == 1) {
            record.add(new int[]{from, to});
            return;
        }

        int next = getNext(from, to);

        solve(from, next, n - 1);
        record.add(new int[]{from, to});
        solve(next, to, n - 1);

    }

    public int[][] solution(int n) {
        record = new LinkedList<>();

        solve(1, 3, n);

        return record.toArray(new int[0][0]);
    }
}