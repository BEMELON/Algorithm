import java.util.*;

class Solution {
    // 1. MaxHeap, MinHeap 2개 유지해보기 
    //  > 원소가 유일해야 함, 유일하다는 조건이 없음 PASS 

    // 2. idx를 기반으로 MaxHeap, MinHeap 2개 유지? 
    //  > 최솟 값만 N - 1개를 삭제하고, 마지막 1개를 최댓값을 삭제하는 경우
    //  > (N - 1)log N * Nlog N >> N^2  (시간초과)

    // 3. MinMax Heap 구현
    // 이거 밖에 없나.. 

    // 4. TreeMap 
    // 어차피 최소 최대만 가져가기 때문에 가능할지도? 

    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(String op: operations) {
            String[] cmds = op.split(" ");
            String cmd = cmds[0];
            int arg = Integer.parseInt(cmds[1]);

            if (cmd.equals("I")) {
                map.put(arg, 1);
            } else if (arg == 1) {
                // 최댓값 
                map.pollLastEntry();
            } else {
                map.pollFirstEntry();
            }
        }

        if (map.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {map.lastKey(), map.firstKey()};
        }

    }
}