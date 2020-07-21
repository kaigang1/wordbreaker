package cn.com.wb.util;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class WordBreakerTest {

    WordBreaker wb;

    @BeforeEach
    void setUp() {

        String[] words = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man", "go", "and"};
        wb = WordBreaker.getInstance(words);
    }

    @Test
    void getInstanceTestNull() {

        wb = WordBreaker.getInstance(null);
        Assertions.assertNull(wb);
    }

    @Test
    void getInstanceTestEmpty() {

        wb = WordBreaker.getInstance(new String[]{});
        Assertions.assertNull(wb);
    }

    @Test
    void breakWordTestNormal1() {

        List<String> expected = new ArrayList<String>();
        expected.add("i like sam sung mobile");
        expected.add("i like samsung mobile");

        List<String> output = wb.breakWord("ilikesamsungmobile");
        Assertions.assertArrayEquals(expected.toArray(), output.toArray());
    }

    @Test
    void breakWordTestNormal2() {

        List<String> expected = new ArrayList<String>();
        expected.add("i like ice cream and man go");

        List<String> output = wb.breakWord("ilikeicecreamandmango");
        Assertions.assertArrayEquals(expected.toArray(), output.toArray());
    }

    @Test
    void breakWordTestEmpty() {

        List<String> output = wb.breakWord("");
        Assertions.assertArrayEquals(new String[]{}, output.toArray());
    }

    @Test
    void breakWordTestNull() {

        List<String> output = wb.breakWord(null);
        Assertions.assertArrayEquals(new String[]{}, output.toArray());
    }

    @Test
    void breakWordTestEmptyReturn() {

        // test with no output, means there is word not in the dictionary
        List<String> output = wb.breakWord("ilikesamsungmobiletest");
        Assertions.assertArrayEquals(new String[]{}, output.toArray());
    }
}