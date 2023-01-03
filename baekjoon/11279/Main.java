import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] MAX_HEAP = new int[N + 1];

        int size = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (size == 0) {
                    sb.append("0\n");
                    continue;
                }

                sb.append(deleteMax(MAX_HEAP, size)).append("\n");
                size--;
            } else {
                size++;
                insertNum(MAX_HEAP, size, num);
            }
        }

        System.out.println(sb);
    }

    private void insertNum(int[] heap, int size, int num) {
        heap[size] = num; 

        int idx = size;
        while (idx > 1) {
            int parent = idx / 2;
            if (heap[parent] < heap[idx]) {
                swap(heap, parent, idx);
            } else {
                break;
            }

            idx = parent;
        }
    }

    private int deleteMax(int[] heap, int size) {
        int max = heap[1];
        heap[1] = heap[size]; 

        int index = 1;
        while (true) {
            int left = index * 2;
            int right = index * 2 + 1;

            // Leaf node
            if (left > size) 
                break; 

            // Only left child
            if (right > size) {
                if (heap[left] > heap[index]) {
                    swap(heap, index, left);
                }
                break;
            }

            // if already heap 
            if (heap[index] > heap[left] && heap[index] > heap[right])
                break;

            if (heap[right] < heap[left]) {
                swap(heap, index, left);
                index = left;
            } else {
                swap(heap, index, right);
                index = right;
            }

        }

        return max;
    }

    private void swap(int[] heap, int index, int left) {
        int temp = heap[index];
        heap[index] = heap[left];
        heap[left] = temp;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}