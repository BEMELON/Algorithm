import java.util.*;

class Truck {
    int insertedTime, weight;

    public Truck(int time, int weight) {
        this.insertedTime = time;
        this.weight = weight;
    }

    public String toString() {
        return "insertedAt : " + insertedTime + ", weight : " + weight;
    }
}

class Solution {
    static int time, weight;
    static Queue<Truck> bridge;
    static int bridgeLoad, truckIdx;

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        init(weight);
        while (truckIdx < truck_weights.length || !bridge.isEmpty()) {
            // 1. 트럭 빼기
            while (!bridge.isEmpty()) {
                Truck t = bridge.peek();

                if (time - t.insertedTime >= bridge_length) {
                    bridge.poll();
                    bridgeLoad -= t.weight;
                } else {
                    break;
                }
            }

            // 2. 트럭 넣기 (1초에 1대만 가능한듯)
            if (truckIdx < truck_weights.length && canLoad(truck_weights[truckIdx])) {
                bridgeLoad += truck_weights[truckIdx];
                bridge.add(new Truck(time, truck_weights[truckIdx]));
                truckIdx++;
            }


            // 3. 시간 진행
            time += 1;
        }

        return time;
    }

    private void init(int weight) {
        time = 0;
        Solution.weight = weight;
        bridgeLoad = 0;
        bridge = new LinkedList<>();
    }

    private boolean canLoad(int w) {
        return bridgeLoad + w <= weight;
    }
}