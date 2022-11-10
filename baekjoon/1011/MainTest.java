package baekjoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test01() {
        Integer output = Main.solve(0, 3);

        Assertions.assertEquals(3, output);
    }

    @Test
    void test02() {
        Integer output = Main.solve(1, 5);

        Assertions.assertEquals(3, output);
    }

    @Test
    void test03() {
        Integer output = Main.solve(45, 50);

        Assertions.assertEquals(4, output);
    }
}