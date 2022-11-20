import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    @BeforeEach
    public void init() {
        Main.answer = Integer.MAX_VALUE;
    }

    @Test
    public void case1() {
        String[] board = new String[] {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBBBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW"
        };

        Main.solver(board, 0, 0, 8, 8);

        assertEquals(1, Main.answer);
    }

    @Test
    public void case2() {

        String[] board = new String[] {
            "BBBBBBBBWBWBW",
            "BBBBBBBBBWBWB",
            "BBBBBBBBWBWBW",
            "BBBBBBBBBWBWB",
            "BBBBBBBBWBWBW",
            "BBBBBBBBBWBWB",
            "BBBBBBBBWBWBW",
            "BBBBBBBBBWBWB",
            "WWWWWWWWWWBWB",
            "WWWWWWWWWWBWB"
        };

        Main.solver(board, 0, 0, 10, 13);

        assertEquals(12, Main.answer);
    }

    @Test
    public void case3() {
        String[] board = new String[] {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB"
        };

        Main.solver(board, 0, 0, 8, 8);

        assertEquals(0, Main.answer);
    }

    @Test
    public void case4() {
        String[] board = new String[] {
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBW"
        };

        Main.solver(board, 0, 0, 9, 23);

        assertEquals(31, Main.answer);
    }

    @Test
    public void case5() {
        String[] board = new String[] {
            "BBBBBBBBBB",
            "BBWBWBWBWB",
            "BWBWBWBWBB",
            "BBWBWBWBWB",
            "BWBWBWBWBB",
            "BBWBWBWBWB",
            "BWBWBWBWBB",
            "BBWBWBWBWB",
            "BWBWBWBWBB",
            "BBBBBBBBBB"
        };

        Main.solver(board, 0, 0, 10, 10);

        assertEquals(0, Main.answer);
    }

    @Test
    public void case6() {
        String[] board = new String[] {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBBBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWWWB",
            "BWBWBWBW"
        };

        Main.solver(board, 0, 0, 8, 8);

        assertEquals(2, Main.answer);
    }

    @Test
    public void case7() {
        String[] board = new String[] {
            "BWWBWWBWWBWW",
            "BWWBWBBWWBWW",
            "WBWWBWBBWWBW",
            "BWWBWBBWWBWW",
            "WBWWBWBBWWBW",
            "BWWBWBBWWBWW",
            "WBWWBWBBWWBW",
            "BWWBWBWWWBWW",
            "WBWWBWBBWWBW",
            "BWWBWBBWWBWW",
            "WBWWBWBBWWBW"
        };

        Main.solver(board, 0, 0, 11, 12);

        assertEquals(15, Main.answer);
    }
}