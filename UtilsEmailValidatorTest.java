import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import test1.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class UtilsEmailValidatorTest {

    private String email;
    private boolean isValid;

    public UtilsEmailValidatorTest(String email, boolean isValid) {
        this.email = email;
        this.isValid = isValid;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {"a@b.c", true},
                {"a-a@b.c", true},
                {"a.a@b.c", true},
                {"a_a@b.c", true},
                {"a@b.", false},
                {"a@bc", false},
                {"a@.c", false},
                {"a@.", false},
                {"@b.c", false},
                {"a#a@b.c", false},
                {".a@b.c", false},
                {"a..a@b.c", false},
                {"a@b..c", false},
                {"@b#c.d", false},
                {"@", false},
                {"a", false},
                {"b.c", false},
                {"", false}
        });
    }

    @Test()
    public void testIsValidEmailAddress() {

        Utils utils = new Utils();
        boolean result = utils.isValidEmailAddress(email);
        assertEquals(isValid, result);

    }




}
