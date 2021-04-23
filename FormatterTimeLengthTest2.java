import org.junit.Test;

import test1.Formatter;

public class FormatterTimeLengthTest2 {

    @Test(expected = IllegalArgumentException.class)
    public void testFormatAsTimeLength() {
        Formatter formatter = new Formatter();
        formatter.formatAsTimeLength(-50);
    }
}
