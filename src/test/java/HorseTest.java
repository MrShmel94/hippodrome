import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HorseTest {

    @Test
    void HorseConstructorNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2.5));
    }

    @Test
    void HorseConstructorNullMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2.1)).getMessage();
        Assertions.assertEquals("Name cannot be null.", message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void HorseConstructorArgumentTest(String s) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(s, 2.5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void HorseConstructorArgumentMessageTest(String s) {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(s, 2.5)).getMessage();
        Assertions.assertEquals("Name cannot be blank.", message);
    }

    @Test
    void HorseConstructorNegativeValueSecondParameterTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", -1));
    }

    @Test
    void HorseConstructorNegativeValueSecondParameterMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", -1)).getMessage();
        Assertions.assertEquals("Speed cannot be negative.", message);
    }

    @Test
    void HorseConstructorNegativeValueThirdParameterTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", 1, -1));
    }

    @Test
    void HorseConstructorNegativeValueThirdParameterMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", 1, -1)).getMessage();
        Assertions.assertEquals("Distance cannot be negative.", message);
    }
}
