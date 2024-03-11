package org.wea4saken.algorithms.lecture1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileFormattingTest {

    @Test
    public void testFileFormatting2() {

        testInput("5\n1\n4\n12\n9\n0\n", "8");
    }

    private void testInput(String input, String expectedOutput) {
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        FileFormatting.main(null);
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
        System.setIn(System.in);
    }
}