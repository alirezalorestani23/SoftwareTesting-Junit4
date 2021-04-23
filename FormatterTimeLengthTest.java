import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import test1.Formatter;

@RunWith(value = Parameterized.class)
public class FormatterTimeLengthTest {

    private long time;
    private String expectedResult;

    public FormatterTimeLengthTest(long time, String expectedResult) {
        this.time = time;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {2, "2 milli seconds"},
                {2000, "2 seconds"},
                {2800, "2 seconds 800 milli seconds"},
                {61000, "1 minutes 1 seconds"},
                {61800, "1 minutes 1 seconds 800 milli seconds"},
                {3600000, "1 hour 0 minutes"},
                {3661000, "1 hour 1 minutes 1 seconds"},
                {3661800, "1 hour 1 minutes 1 seconds 800 milli seconds"}
        });
    }

    @Test
    public void testFormatAsTimeLength() {
        Formatter formatter = new Formatter();
        String result = formatter.formatAsTimeLength(time);
        assertEquals(expectedResult, result);
    }
}
