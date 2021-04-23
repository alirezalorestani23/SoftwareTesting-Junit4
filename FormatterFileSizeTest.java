import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import test1.Formatter;

@RunWith(value = Parameterized.class)
public class FormatterFileSizeTest {

    private long fileSize;
    private String expectedResult;

    public FormatterFileSizeTest(long fileSize, String expectedResult) {
        this.fileSize = fileSize;
        this.expectedResult = expectedResult;
    }


    //TODO:add other test cases
    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {1000, "1000 B"},//less than 1024
                {1023, "1023 B"},
                {1025, "1.00 KB"},
                {2000, "1.95 KB"},//for . dar
                {2048, "2.0 KB"}//for . nadar
////                {1024*1024-1, false},
////                {1024*1024, false},
////                {1024*1024+100, false},
////                {1024*1024-1, false}
        });
    }

    @Test
    public void testFormatAsFileSize() {
        Formatter formatter = new Formatter();
        String result = formatter.formatAsFileSize(fileSize);
        assertEquals(expectedResult, result);
    }


}
