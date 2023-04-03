import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] inOrder = new int[N];
        int[] postOrder = new int[N];
        for (int i = 0; i < 2; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i == 0)
                    inOrder[j] = Integer.parseInt(tk.nextToken());
                else
                    postOrder[j] = Integer.parseInt(tk.nextToken());
            }
        }

        if (N == 1) {
            System.out.println(inOrder[0]);
            return;
        } else if (N == 2) {
            System.out.println(inOrder[0] + " " + inOrder[1]);
            return;
        }
        preOrder(inOrder, postOrder, 0, N, 0, N);
    }

    private void preOrder(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
        System.out.print(postOrder[postEnd - 1] + " ");

        int inOrderRoot = find(inOrder, postOrder[postEnd - 1]);

        // left
        if (inStart < inOrderRoot)
            preOrder(inOrder, postOrder, inStart, inOrderRoot, postStart, postStart + (inOrderRoot - inStart));

        // right
        if (inOrderRoot + 1 < inEnd)
            preOrder(inOrder, postOrder, inOrderRoot + 1, inEnd, postStart + (inOrderRoot - inStart), postEnd - 1);
    }

    private int find(int[] inOrder, int i) {
        for (int j = 0; j < inOrder.length; j++) {
            if (inOrder[j] == i)
                return j;
        }
        return -1;
    }
}