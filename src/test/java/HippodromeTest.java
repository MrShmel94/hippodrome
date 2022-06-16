import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;


public class HippodromeTest {

    @Test
    void HippodromeConstructorNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void HippodromeConstructorNullMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null)).getMessage();
        Assertions.assertEquals("Horses cannot be null.", message);
    }

    @Test
    void HippodromeConstructorEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    void HippodromeConstructorEmptyMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>())).getMessage();
        Assertions.assertEquals("Horses cannot be empty.", message);
    }
}
