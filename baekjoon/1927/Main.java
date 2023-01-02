import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] minHeap = new int[N + 1];

        int size = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (size == 0) {
                    sb.append(0).append("\n");
                    continue;
                }

                sb.append(deleteMin(minHeap, size)).append("\n");
                size--;
            } else {
                size++;
                insertMin(minHeap, num, size);
            }
            // System.out.printf("num: %d, i: %d, size: %d\n", num, i, size);
            // System.out.println("minHeap: " + Arrays.toString(minHeap));
        }

        System.out.printf(sb.toString());
    }

    private void insertMin(int[] minHeap, int num, int size) {
        minHeap[size] = num;

        int index = size;
        while (index > 1) {
            int parent = index / 2;
            if (minHeap[parent] > minHeap[index]) {
                swap(minHeap, parent, index);
            } else {
                break;
            }

            index = parent;
        }
    }

    private int deleteMin(int[] minHeap, int size) {
        int min = minHeap[1];
        minHeap[1] = minHeap[size];

        int index = 1;
        while (true) {
            int left = index * 2;
            int right = index * 2 + 1;

            // leaf node
            if (left > size) {
                break;
            }

            // has only left child
            if (right > size) {
                if (minHeap[index] > minHeap[left]) {
                    swap(minHeap, index, left);
                }

                index = left;
                break;
            }

            if (minHeap[index] < minHeap[left] && minHeap[index] < minHeap[right]) {
                break;
            }

            // has both children
            if (minHeap[left] > minHeap[right]) {
                swap(minHeap, index, right);
                index = right;
            } else {
                swap(minHeap, index, left);
                index = left;
            }
        }

        return min;
    }

    private void swap(int[] minHeap, int index, int left) {
        int temp = minHeap[index];
        minHeap[index] = minHeap[left];
        minHeap[left] = temp;
    }

}