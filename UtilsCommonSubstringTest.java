import org.junit.Test;

import test1.Utils;

import static org.junit.Assert.fail;

public class UtilsCommonSubstringTest {

    private String firstInput;
    private String secondInput;
    private String longestCommonSubstring;

    public UtilsCommonSubstringTest(String firstInput, String secondInput, String longestCommonSubstring) {

        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.longestCommonSubstring = longestCommonSubstring;
    }


    @Test()
    public void testLongestCommonSubstring() {
        Utils utils = new Utils();
        try {
            utils.longestCommonSubstring(null, "as");
        } catch (Exception e) {
            fail("function should not throws any exception");
        }
    }
}
