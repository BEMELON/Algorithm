import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int answer = Integer.MAX_VALUE;
    private static final int BOARD_SIZE = 8;
    private static final char WHITE = 'W';
    private static final char BLACK = 'B';
    public static void solver(String[] board, int c_row, int c_col, int max_row, int max_col) {
        // 보드 사이즈가 8보다 작은 경우
        if (!(max_col - c_col >= BOARD_SIZE && max_row - c_row >= BOARD_SIZE))
            return;

        // 시작이 검정인 경우와 하얀색인 경우 분리
        for (int chessCase = 0; chessCase < 2; chessCase++) {
            // 변경해야 하는 셀의 개수
            int counter = 0;

            // 좌측 상단의 셀 색상
            char prevColor;

            if (chessCase == 0) prevColor = WHITE;
            else prevColor = BLACK;

            for (int row = c_row; row < (c_row + BOARD_SIZE); row++) {
                for(int col = c_col; col < (c_col + BOARD_SIZE); col++) {
                    char color = board[row].charAt(col);
                    if (color != prevColor)
                        counter += 1;

                    // 색 변경
                    prevColor = prevColor == BLACK ? WHITE : BLACK;
                }
                // 행간 색 보정
                prevColor = prevColor == BLACK ? WHITE : BLACK;
            }

            // 최솟값 업데이트
            answer = Math.min(answer, counter);
        }

        solver(board, c_row + 1, c_col, max_row, max_col);
        solver(board, c_row, c_col + 1, max_row, max_col);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        scanner.nextLine();
        String[] board = new String[row];
        for(int i = 0; i < row; i++) {
            board[i] = scanner.nextLine();
        }

        solver(board, 0, 0, row, col);
        System.out.println(answer);
    }
}
