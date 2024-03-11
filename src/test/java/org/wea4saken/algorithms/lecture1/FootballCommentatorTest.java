package session1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FootballCommentatorTest {

    @Test
    public void testFootballCommentator() {
        testInput("0:0\n0:0\n1\n", "1"); // test 1
        testInput("0:2\n0:3\n1\n", "5"); // test 2
        testInput("0:2\n0:3\n2\n", "6"); // test 3
        testInput("5:2\n0:5\n1\n", "3"); // test 20
        testInput("1:2\n2:3\n1\n", "2"); // test 25
        testInput("4:2\n0:3\n1\n", "2"); // test 29
        testInput("1:4\n4:2\n1\n", "1"); // test 26
        testInput("0:5\n2:1\n1\n", "4"); // test 48
        testInput("4:3\n0:3\n2\n", "2"); // test 49
        testInput("5:2\n0:5\n2\n", "3"); // test 51
        testInput("0:5\n5:5\n2\n", "6"); // test 11
        testInput("2:4\n3:3\n2\n", "3"); // test 23
    }

    private void testInput(String input, String expectedOutput) {
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        FootballCommentator.main(null);
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
        System.setIn(System.in);
    }
}