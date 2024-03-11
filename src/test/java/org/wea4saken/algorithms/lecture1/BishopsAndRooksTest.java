package session1;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BishopsAndRooks2Test {

    @Test
    public void testCountEmptyCells() {
        String input1 =                             // Test 6
                "********\n" +
                        "***B****\n" +
                        "**BRB***\n" +
                        "***B****\n" +
                        "********\n" +
                        "********\n" +
                        "********\n" +
                        "********";

        String input2 =                             // Test 7
                "********\n" +
                        "**B*B***\n" +
                        "*BR*RB**\n" +
                        "***B****\n" +
                        "*BR*RB**\n" +
                        "**B*B***\n" +
                        "********\n" +
                        "********";

        String input3 =                             // Test 8
                "********\n" +
                        "BBBBBBBB\n" +
                        "********\n" +
                        "********\n" +
                        "********\n" +
                        "********\n" +
                        "RRRRRRRR\n" +
                        "********";

        assertEquals(41, countEmptyCells(input1));
        assertEquals(27, countEmptyCells(input2));
        assertEquals(0, countEmptyCells(input3));
    }

    private int countEmptyCells(String input) {
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        BishopsAndRooks2.main(new String[]{});

        System.setIn(originalSystemIn);
        System.setOut(System.out);

        String output = baos.toString().trim();
        return Integer.parseInt(output);
    }
}